package com.mainticket.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.context.ApplicationContext;

import com.agent.dao.Flight;
import com.agent.dao.Ticket;
import com.agent.dao.TicketDaoImpl;
import com.agent.dao.TicketDaoImplService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bank.dao.BillDaoImpl;
import com.bank.dao.BillDaoImplService;
import com.mainticket.dao.LocalTicketDao;
import com.mainticket.entity.Customer;
import com.mainticket.entity.Idcard;
import com.mainticket.entity.LocalTicket;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public final static int IDCARD_NOT_EXIST = 1;
	public final static int PASSWORD_WRONG = 2;
	public final static int PASSWORD_TRUE = 3;
	public final static int COST_MINUS = 4;
	public final static int INSERT_BILL_FALSE = 5;
	public final static int INSERT_BILL_TRUE = 6;
	public final static int UPDATE_BALANCE_FALSE = 7;
	public final static int CHARGE_TRUE = 8;
	public final static int BALANCE_NOT_ENOUGH = 9;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		// AccountDaoImplService factory = new AccountDaoImplService();
		// AccountDaoImpl ad = factory.getAccountDaoImplPort();
		BillDaoImplService bfactory = new BillDaoImplService();
		BillDaoImpl bd = bfactory.getBillDaoImplPort();
		String method = request.getParameter("method");
		if (method.equals("charge")) {
			String idcard = request.getParameter("idcard");
			String password = request.getParameter("password");
			int cost = Integer.parseInt(request.getParameter("cost"));
			String fromCompany = "XX机票网";
			System.out.println(
					"idcard=" + idcard + "password=" + password + "cost=" + cost + "fromCompany=" + fromCompany);
			int charge = bd.charge(idcard, password, cost, fromCompany, xmlToDate(new Date()));
			String responseMes = "付款失败!";
			if (charge == IDCARD_NOT_EXIST) {
				responseMes = "该ID未在该网站注册!";
			} else if (charge == PASSWORD_WRONG) {
				responseMes = "密码不正确!";
			} else if (charge == COST_MINUS) {
				responseMes = "付费金额不能为负数!";
			} else if (charge == BALANCE_NOT_ENOUGH) {
				responseMes = "余额不足!";
			} else if (charge == UPDATE_BALANCE_FALSE) {
				responseMes = "扣费失败!";
			} else if (charge == INSERT_BILL_FALSE) {
				responseMes = "账单生成失败!";
			} else if (charge == CHARGE_TRUE) {
				responseMes = "付款成功!";
			}
			System.out.println("responseMes=" + responseMes);
			JSONObject jo = new JSONObject();
			jo.put("responseMes", responseMes);
			if (responseMes.equals("付款成功!")) {
				// 得到要购买的航班
				String flightInfo = request.getParameter("flightInfo");
				String fromBank =request.getParameter("fromBank");
				String fromAgent=request.getParameter("fromAgent");
				Flight f = JSONObject.parseObject(flightInfo, Flight.class);
				String flight = f.getFlight();// 航班号
				XMLGregorianCalendar beginTime = f.getBeginTime();// 起飞时间
				int price = f.getPrice();// 价格
				String fromWhere = f.getFromWhere();// 出发地
				String toWhere = f.getToWhere();// 目的地
				int seatsNum = f.getSeatsNum();// 座位数量
				System.out.println(flight + " " + beginTime + " " + price + " ");
				// 得到要购买该机票的乘客的身份证表
				List<Idcard> idcards = JSONArray.parseArray(request.getParameter("selectcustomers"), Idcard.class);
				// 得到代理商的机票购买接口
				TicketDaoImplService tfactory = new TicketDaoImplService();
				TicketDaoImpl td = tfactory.getTicketDaoImplPort();
				// 创建机票列表
				// List<Ticket> tickets=new ArrayList<Ticket>();
				List<LocalTicket> localTickets = new ArrayList<LocalTicket>();
				// 得到当前登陆的用户名
				Customer c = (Customer) request.getSession().getAttribute("user");
				// 得到本网站的机票数据库
				ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("springContext");
				LocalTicketDao ltd = ac.getBean(LocalTicketDao.class);
				for (int i = 0; i < idcards.size(); i++) {
					Idcard id = idcards.get(i);
					// 向代理商购买机票并得到购买到的机票的信息
					Ticket t = td.buyTickets(id.getIdcard(), id.getRealname(), flight, beginTime);
					if (t == null) {
						t = new Ticket();
						t.setFlight(flight + "[购买失败]");
					} else {
						// 将机票信息存入本网站的数据库
						boolean flag = ltd.addTicket(c.getUsername(), t.getFlight(), DateToXML(beginTime), fromWhere, toWhere,
								id.getRealname(), id.getIdcard(), t.getSeatNumber(), price,fromBank,fromAgent);
						//如果存入数据库失败
						if(!flag) {
							t.setFlight(t.getFlight()+"[购买成功但存入本网站数据库失败]");
						}
					}
					// 创建机票Bean并存入list
					LocalTicket lt = new LocalTicket(c.getUsername(), t.getFlight(), DateToXML(beginTime), fromWhere,
							toWhere, id.getRealname(), id.getIdcard(), t.getSeatNumber(), price,fromBank,fromAgent);
					localTickets.add(lt);
				}
				// 机票列表转换成json字符串
				String tickets_str = JSON.toJSONString(localTickets);
				System.out.println(localTickets);
				System.out.println(tickets_str);
				jo.put("localTickets", tickets_str);
			} else {
				jo.put("localTickets", false);
			}
			response.getWriter().write(jo.toJSONString());
		}
	}

	// ISO日期转换为UTC日期
	public static XMLGregorianCalendar xmlToDate(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;
	}

	// UTC日期转换为ISO日期
	public Date DateToXML(XMLGregorianCalendar gc) {
		GregorianCalendar ca = gc.toGregorianCalendar();
		return ca.getTime();
	}
}

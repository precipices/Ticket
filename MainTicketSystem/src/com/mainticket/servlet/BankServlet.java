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
			String fromCompany = "XX��Ʊ��";
			System.out.println(
					"idcard=" + idcard + "password=" + password + "cost=" + cost + "fromCompany=" + fromCompany);
			int charge = bd.charge(idcard, password, cost, fromCompany, xmlToDate(new Date()));
			String responseMes = "����ʧ��!";
			if (charge == IDCARD_NOT_EXIST) {
				responseMes = "��IDδ�ڸ���վע��!";
			} else if (charge == PASSWORD_WRONG) {
				responseMes = "���벻��ȷ!";
			} else if (charge == COST_MINUS) {
				responseMes = "���ѽ���Ϊ����!";
			} else if (charge == BALANCE_NOT_ENOUGH) {
				responseMes = "����!";
			} else if (charge == UPDATE_BALANCE_FALSE) {
				responseMes = "�۷�ʧ��!";
			} else if (charge == INSERT_BILL_FALSE) {
				responseMes = "�˵�����ʧ��!";
			} else if (charge == CHARGE_TRUE) {
				responseMes = "����ɹ�!";
			}
			System.out.println("responseMes=" + responseMes);
			JSONObject jo = new JSONObject();
			jo.put("responseMes", responseMes);
			if (responseMes.equals("����ɹ�!")) {
				// �õ�Ҫ����ĺ���
				String flightInfo = request.getParameter("flightInfo");
				String fromBank =request.getParameter("fromBank");
				String fromAgent=request.getParameter("fromAgent");
				Flight f = JSONObject.parseObject(flightInfo, Flight.class);
				String flight = f.getFlight();// �����
				XMLGregorianCalendar beginTime = f.getBeginTime();// ���ʱ��
				int price = f.getPrice();// �۸�
				String fromWhere = f.getFromWhere();// ������
				String toWhere = f.getToWhere();// Ŀ�ĵ�
				int seatsNum = f.getSeatsNum();// ��λ����
				System.out.println(flight + " " + beginTime + " " + price + " ");
				// �õ�Ҫ����û�Ʊ�ĳ˿͵����֤��
				List<Idcard> idcards = JSONArray.parseArray(request.getParameter("selectcustomers"), Idcard.class);
				// �õ������̵Ļ�Ʊ����ӿ�
				TicketDaoImplService tfactory = new TicketDaoImplService();
				TicketDaoImpl td = tfactory.getTicketDaoImplPort();
				// ������Ʊ�б�
				// List<Ticket> tickets=new ArrayList<Ticket>();
				List<LocalTicket> localTickets = new ArrayList<LocalTicket>();
				// �õ���ǰ��½���û���
				Customer c = (Customer) request.getSession().getAttribute("user");
				// �õ�����վ�Ļ�Ʊ���ݿ�
				ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("springContext");
				LocalTicketDao ltd = ac.getBean(LocalTicketDao.class);
				for (int i = 0; i < idcards.size(); i++) {
					Idcard id = idcards.get(i);
					// ������̹����Ʊ���õ����򵽵Ļ�Ʊ����Ϣ
					Ticket t = td.buyTickets(id.getIdcard(), id.getRealname(), flight, beginTime);
					if (t == null) {
						t = new Ticket();
						t.setFlight(flight + "[����ʧ��]");
					} else {
						// ����Ʊ��Ϣ���뱾��վ�����ݿ�
						boolean flag = ltd.addTicket(c.getUsername(), t.getFlight(), DateToXML(beginTime), fromWhere, toWhere,
								id.getRealname(), id.getIdcard(), t.getSeatNumber(), price,fromBank,fromAgent);
						//����������ݿ�ʧ��
						if(!flag) {
							t.setFlight(t.getFlight()+"[����ɹ������뱾��վ���ݿ�ʧ��]");
						}
					}
					// ������ƱBean������list
					LocalTicket lt = new LocalTicket(c.getUsername(), t.getFlight(), DateToXML(beginTime), fromWhere,
							toWhere, id.getRealname(), id.getIdcard(), t.getSeatNumber(), price,fromBank,fromAgent);
					localTickets.add(lt);
				}
				// ��Ʊ�б�ת����json�ַ���
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

	// ISO����ת��ΪUTC����
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

	// UTC����ת��ΪISO����
	public Date DateToXML(XMLGregorianCalendar gc) {
		GregorianCalendar ca = gc.toGregorianCalendar();
		return ca.getTime();
	}
}

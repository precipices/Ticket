package com.mainticket.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.agent.dao.Flight;
import com.agent.dao.FlightDaoImpl;
import com.agent.dao.FlightDaoImplService;
import com.agent.dao.TicketDaoImpl;
import com.agent.dao.TicketDaoImplService;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		FlightDaoImplService factory = new FlightDaoImplService();
		FlightDaoImpl fd = factory.getFlightDaoImplPort();
		String method=request.getParameter("method");
		if(method.equals("getAllFlights")) {
			List<Flight> l=fd.getAllFlights();
			String str=JSON.toJSONString(l);
			System.out.println(l);
			System.out.println(str);
			response.getWriter().write(str);
		}else if(method.equals("getFlights")) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date beginTime;
			try {
				beginTime = sdf.parse(request.getParameter("beginTime"));
			} catch (ParseException e) {
				System.out.println("时间类型不正确!");
				response.getWriter().write("时间类型不正确!");//TIMETYPE_ERROR
				return;
			}
			String fromWhere=request.getParameter("fromWhere");
			String toWhere= request.getParameter("toWhere");
			List<Flight> l=fd.getFlights(xmlToDate(beginTime), fromWhere, toWhere);
			String str=JSON.toJSONString(l);
			System.out.println(str);
			response.getWriter().write(str);
		}else if(method.equals("getFlightLeftTickets")) {
			TicketDaoImplService factory2=new TicketDaoImplService();
			TicketDaoImpl td=factory2.getTicketDaoImplPort();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date beginTime;
			try {
				System.out.println("request.getParameter(\"beginTime\")="+request.getParameter("beginTime"));
				beginTime =new Date(Long.parseLong(request.getParameter("beginTime")));
				System.out.println("Date beginTime="+beginTime);
			} catch (Exception e) {
				System.out.println("时间类型不正确!");
				response.getWriter().write("时间类型不正确!");//TIMETYPE_ERROR
				return;
			}
			System.out.println("beginTime="+beginTime);
			String flight=request.getParameter("flight");
			int num=td.getFlightLeftTickets(flight, xmlToDate(beginTime));
			System.out.println("余量:"+num);
			response.getWriter().write(num+"");
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
}

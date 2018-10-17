package com.agent.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.agent.dao.FlightDao;
import com.agent.dao.FlightDaoImpl;
import com.agent.entity.Flight;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/SelectFlightServlet")
public class SelectFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectFlightServlet() {
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
		ApplicationContext context = (ApplicationContext) request.getServletContext().getAttribute("springContext");
		FlightDao fd = (FlightDaoImpl) context.getBean("flightDao");
		String method=request.getParameter("method");
		if(method.equals("getAllFlights")) {
//			Gson g=new Gson();
			List<Flight> l=fd.getAllFlights();
			String str=JSONObject.toJSONString(l);
//			String str=g.toJson(l);
			System.out.println(l);
			System.out.println(str);
			response.getWriter().write(str);
		}else if(method.equals("getFlights")) {
//			Gson g=new Gson();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date beginTime;
			try {
				beginTime = sdf.parse(request.getParameter("beginTime"));
			} catch (ParseException e) {
				return;
			}
			String fromWhere=request.getParameter("fromWhere");
			String toWhere= request.getParameter("toWhere");
			List<Flight> l=fd.getFlights(beginTime, fromWhere, toWhere);
			String str=JSONObject.toJSONString(l);
			System.out.println(str);
			response.getWriter().write(str);
		}else if(method.equals("addFlight")) {
			String flight=request.getParameter("flight");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date beginTime=null;
			try {
				beginTime = sdf.parse(request.getParameter("beginTime"));
			} catch (ParseException e) {
				response.getWriter().write("失败,日期格式不正确!");
			}
			String fromWhere=request.getParameter("fromWhere");
			String toWhere= request.getParameter("toWhere");
			int price=Integer.parseInt(request.getParameter("price"));
			int seatsNum=Integer.parseInt(request.getParameter("seatsNum"));
			if(fd.addFlight(flight, beginTime, fromWhere, toWhere, price, seatsNum)) {
				response.getWriter().write("添加成功!");
			}else {
				response.getWriter().write("添加失败!");
			}
		}
	}

}

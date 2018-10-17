package com.agent.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.agent.dao.FlightDao;
import com.agent.entity.Ticket;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class DeleteFlightServlet
 */
@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ApplicationContext ac=(ApplicationContext) request.getServletContext().getAttribute("springContext");
		FlightDao fd=ac.getBean(FlightDao.class);

		String method=request.getParameter("method");
		if(method.equals("deleteFlight")) {
			String flight=request.getParameter("flight");
			Date beginTime=new Date(Long.parseLong(request.getParameter("beginTime")));
			boolean flag=fd.deleteFlight(flight, beginTime);
			if(flag) {
				response.getWriter().write("É¾³ý³É¹¦!");
			}else {
				response.getWriter().write("É¾³ýÊ§°Ü!");
			}
		}
	}

}

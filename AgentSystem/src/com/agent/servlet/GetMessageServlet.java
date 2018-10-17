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
import com.agent.dao.FlightDaoImpl;
import com.agent.dao.TicketDao;
import com.agent.entity.Ticket;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class GetMessageServlet
 */
@WebServlet("/GetMessageServlet")
public class GetMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessageServlet() {
        super();
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
		TicketDao td=ac.getBean(TicketDao.class);

		String method=request.getParameter("method");
		if(method.equals("getFlightTickets")) {
			String flight=request.getParameter("flight");
			Date beginTime=new Date(Long.parseLong(request.getParameter("beginTime")));
			List<Ticket> tickets=td.getFlightTickets(flight, beginTime);
			response.getWriter().write(JSON.toJSONString(tickets));
		}
		
	}

}

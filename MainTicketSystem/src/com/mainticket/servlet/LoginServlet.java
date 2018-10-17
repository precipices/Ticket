package com.mainticket.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.mainticket.dao.CustomerDao;
import com.mainticket.entity.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
//		response.setContentType("text/html");
		ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("springContext");
		CustomerDao cd=ac.getBean(CustomerDao.class);
		//----------------
		List<Customer> l=cd.getAllCustomers();
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
		//----------------
		String username=(String) request.getParameter("username");
		String password=(String) request.getParameter("password");
		Customer c=cd.getCustomer(username);
		System.out.println("���յ�������:username="+username+"	password="+password);
		System.out.println("���յ�������:"+c);
		String returnMes="";
		if(c==null) {
			returnMes="��ID������!";
		}else if(!c.getPassword().equals(password)) {
			returnMes="���벻��ȷ!";
		}else {
			request.getSession().setAttribute("user", c);
			returnMes="��½�ɹ�!";
			//request.getRequestDispatcher("mainticket.html").forward(request, response);
			//return;
		}
		response.getWriter().write(returnMes);
//		cd.getCustomer("");
		
	}

}

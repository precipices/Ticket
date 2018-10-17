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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username=(String) request.getParameter("user");
		String password=(String) request.getParameter("passwd");
		String idcard=(String) request.getParameter("idcard");
		String realname=(String) request.getParameter("realname");
		System.out.println("���յ�������:username="+username+"	password="+password+"	idcard="+idcard+"	realname="+realname);
		Customer c=cd.getCustomer(username);
		if(c!=null) {
			System.out.println("�ѱ�ע��:"+c);
			response.getWriter().write("���֤���ѱ�ע��!");
			return;
		}
		if(cd.addCustomer( username, password,idcard,realname)) {
			response.getWriter().write("ע��ɹ�!");
			return;
		}else {
			response.getWriter().write("ע��ʧ��!");
			return;
		}
//		cd.getCustomer("");
		
	}

}

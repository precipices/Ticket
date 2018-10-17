package com.bank.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;
import com.bank.dao.AccountDao;
import com.bank.dao.BillDao;
import com.bank.entity.Account;
import com.bank.entity.Bill;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		AccountDao ad=ac.getBean(AccountDao.class);
		BillDao bd=ac.getBean(BillDao.class);
		String method=request.getParameter("method");
		if(method.equals("addAccount")) {
			String idcard=request.getParameter("idcard");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			int balance=Integer.parseInt(request.getParameter("balance"));
			if(ad.addAccount(idcard, password, name, balance)) {
				response.getWriter().write("添加成功!");
			}else{
				response.getWriter().write("添加失败!");
			}
		}else if(method.equals("deleteAccount")){
			String idcard=request.getParameter("idcard");
			if(ad.deleteAccount(idcard)){
				response.getWriter().write("删除成功!");
			}else{
				response.getWriter().write("删除失败!");
			}
		}else if(method.equals("getAccount")){
			String idcard=request.getParameter("idcard");
			Account a=ad.getAccount(idcard);
			if(a==null) {
				response.getWriter().write("该身份证号尚未注册!");
				return;
			}
			String str=JSON.toJSONString(a);
			response.getWriter().write(str);
		}else if(method.equals("getAccountsByName")) {
			String name=request.getParameter("name");
			List<Account> l=ad.getAccountsByName(name);
			String str=JSON.toJSONString(l);
			//-------------------------
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
			}
			System.out.println(str);
			//-------------------------
			response.getWriter().write(str);
		}else if(method.equals("getAllAccounts")) {
			List<Account> l=ad.getAllAccounts();
			String str=JSON.toJSONString(l);
			//-------------------------
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
			}
			System.out.println(str);
			//-------------------------
			response.getWriter().write(str);
		}else if(method.equals("getAccountBills")) {
			String idcard=request.getParameter("idcard");
			List<Bill> l=bd.getAccountBills(idcard);
			String str=JSON.toJSONString(l);
			//-------------------------
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
			}
			System.out.println(str);
			//-------------------------
			response.getWriter().write(str);
		}else if(method.equals("getAllBills")) {
			List<Bill> l=bd.getAllBills();
			String str=JSON.toJSONString(l);
			//-------------------------
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
			}
			System.out.println(str);
			//-------------------------
			response.getWriter().write(str);
		}
	}

}

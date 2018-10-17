package com.mainticket.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSON;
import com.mainticket.dao.IdcardsDao;
import com.mainticket.entity.Customer;
import com.mainticket.entity.Idcard;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/IdcardServlet")
public class IdcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdcardServlet() {
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
		IdcardsDao id=ac.getBean(IdcardsDao.class);
		String method=request.getParameter("method");
		Customer c=(Customer) request.getSession().getAttribute("user");
		if(c==null) {
			response.getWriter().write("ÉÐÎ´µÇÂ½!");
			return;
		}
		if(method.equals("getIdcards")) {
//			Gson g=new Gson();
			List<Idcard> l=id.getIdcards(c.getUsername());
			String str=JSON.toJSONString(l);
			//-------------------------
			for(int i=0;i<l.size();i++) {
				System.out.println(l.get(i));
			}
			System.out.println(str);
			//-------------------------
			response.getWriter().write(str);
		}else if(method.equals("addIdcard")) {
			String idcard=request.getParameter("idcard");
			String realname=request.getParameter("realname");
			if(id.addIdcard(c.getUsername(), idcard, realname)) {
				response.getWriter().write("Ìí¼Ó³É¹¦!");
			}else{
				response.getWriter().write("Ìí¼ÓÊ§°Ü!");
			}
		}
	}

}

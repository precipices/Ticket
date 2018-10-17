package com.mainticket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainticket.entity.Customer;

/**
 * Servlet Filter implementation class NotLoginFilter
 */
@WebFilter(filterName = "/NotLoginFilter", urlPatterns = { "/*" })
public class NotLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public NotLoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("****************进入了过滤器****************");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path=req.getRequestURI();
		System.out.println("path="+path);
		 // 登录页面不过滤
        if (path.indexOf("/index.html") > -1) {
            chain.doFilter(request, response);
            return;
        }
        if (path.indexOf("/LoginServlet") > -1) {
            chain.doFilter(request, response);
            return;
        }
        if (path.indexOf("/RegisterServlet") > -1) {
            chain.doFilter(request, response);
            return;
        }
        // css和js不过滤
        if (path.indexOf(".css") > -1) {
            chain.doFilter(request, response);
            return;
        }
        if (path.indexOf(".js") > -1) {
            chain.doFilter(request, response);
            return;
        }
        //判断是否登陆,未登陆则跳转到登陆页面
        Customer user= (Customer) req.getSession().getAttribute("user");
		System.out.println("user=" + user);
		if (user==null) {
			System.out.println("未登陆,跳转到登陆页面!");
			res.sendRedirect("index.html");
//			request.getRequestDispatcher("index.html").forward(request, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

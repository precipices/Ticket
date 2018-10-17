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
		System.out.println("****************�����˹�����****************");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path=req.getRequestURI();
		System.out.println("path="+path);
		 // ��¼ҳ�治����
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
        // css��js������
        if (path.indexOf(".css") > -1) {
            chain.doFilter(request, response);
            return;
        }
        if (path.indexOf(".js") > -1) {
            chain.doFilter(request, response);
            return;
        }
        //�ж��Ƿ��½,δ��½����ת����½ҳ��
        Customer user= (Customer) req.getSession().getAttribute("user");
		System.out.println("user=" + user);
		if (user==null) {
			System.out.println("δ��½,��ת����½ҳ��!");
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

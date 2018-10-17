package com.bank.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.dao.AccountDao;
import com.bank.dao.BillDao;
import com.bank.dao.DaoConfig;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
    	sce.getServletContext().setAttribute("springContext", context);
		Endpoint.publish("http://localhost:10002/Service/AccountDao", context.getBean(AccountDao.class));
		Endpoint.publish("http://localhost:10002/Service/BillDao", context.getBean(BillDao.class));
    }
	
}

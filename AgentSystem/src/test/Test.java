package test;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.agent.dao.DaoConfig;
import com.agent.dao.FlightDao;
import com.agent.dao.FlightDaoImpl;

public class Test {
	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
//		FlightDao fd = (FlightDaoImpl) context.getBean("flightDao");
		Endpoint.publish("http://localhost:8081/Service/FlightDao", context.getBean("flightDao"));
		Endpoint.publish("http://localhost:8081/Service/TicketDao", context.getBean("ticketDao"));
		System.out.println("发布成功!");
	}
}

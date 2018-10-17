package test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mainticket.dao.CustomerDao;
import com.mainticket.dao.DaoConfig;
import com.mainticket.dao.LocalTicketDao;
import com.mainticket.entity.Customer;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(DaoConfig.class);
		CustomerDao cd= ac.getBean(CustomerDao.class);
		LocalTicketDao ltd=ac.getBean(LocalTicketDao.class);
		System.out.println("*****************getAllCustomers**********************");
		List<Customer> l=cd.getAllCustomers();
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
		System.out.println("*****************getCustomer**********************");
		Customer c=cd.getCustomer("4212");
		System.out.println(c);
		System.out.println("*****************addCustomer**********************");
//		boolean ab=cd.addCustomer("4216", "123", "123");
//		System.out.println(ab);
		System.out.println("*****************addCustomer**********************");
		boolean db=cd.deleteCustomer("4216");
		System.out.println(db);
		System.out.println("*****************addTicket**********************");
//		A102[存入本网站数据库失败]	2018/10/11 上午10:30:00	上海	北京	张三	4213	1
		System.out.println(ltd.addTicket("z3", "A102", new Date(), "上海", "北京", "张三", "4213", 0, 123,"XX银行","XX代理商"));
	}
}

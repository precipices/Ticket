package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.dao.BillDao;
import com.bank.dao.DaoConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=DaoConfig.class)
public class test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
		BillDao dao=context.getBean(BillDao.class);
		System.out.println("************************begin***************************");
//		System.out.println(dao.addBill("4213", 1500, "XX航空公司", new Date()));
		System.out.println(dao.charge("4213","123", 1500, "XX航空公司", new Date()));
		
		System.out.println("************************end***************************");
	}

}

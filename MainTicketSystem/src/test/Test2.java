package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.agent.dao.Flight;
import com.agent.dao.FlightDaoImpl;
import com.agent.dao.FlightDaoImplService;
import com.agent.dao.TicketDaoImpl;
import com.agent.dao.TicketDaoImplService;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightDaoImplService factory = new FlightDaoImplService();
		FlightDaoImpl dao = factory.getFlightDaoImplPort();
		List<Flight> fs = dao.getAllFlights();
		for (int i = 0; i < fs.size(); i++) {
			System.out.println(fs.get(i).getFlight());
		}
		TicketDaoImplService ticketfactory = new TicketDaoImplService();
		TicketDaoImpl td = ticketfactory.getTicketDaoImplPort();
		Date date = new Date();// "2018-10-10 23:10:00"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			date = sdf.parse("2018-10-10 23:10:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(td.getFlightLeftTickets("A101", xmlToDate(date)));
	}

	// ISO日期转换为UTC日期
	public static XMLGregorianCalendar xmlToDate(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;
	}

	// UTC日期转换为ISO日期
	public static Date DateToXML(XMLGregorianCalendar gc) {
		GregorianCalendar ca = gc.toGregorianCalendar();
		return ca.getTime();
	}
}

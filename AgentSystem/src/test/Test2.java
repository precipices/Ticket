package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
	public static void main(String[] args) {
//		Map m=new HashMap();
//		m.put("date", new Date());
//		Gson g=new Gson();
////		String s="{\"date\":\"2018-01-01 00:00:00.0\"}";
//		System.out.println(m);
////		g.
//		String j=g.toJson(m);
//		System.out.println(j);

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date beginTime=null;
		try {
			beginTime = sdf.parse("2018-01-01 00:00:01.1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(beginTime);
	}
}

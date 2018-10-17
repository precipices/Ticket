package com.agent.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DaoConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=agent_system");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=agent_system");
//		ds.setUsername("sa");
//		ds.setPassword("sa");
//		ds.setInitialSize(5);
//		ds.setMaxIdle(10);
//		return ds;
//	}
	@Bean(name="flightDao")
	public FlightDao flightDao() {
		FlightDao dao=new FlightDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public TicketDao ticketDao() {
		TicketDao dao=new TicketDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
}

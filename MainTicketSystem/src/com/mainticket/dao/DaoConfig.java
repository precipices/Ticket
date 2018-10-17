package com.mainticket.dao;

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
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=mainTicket_system");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
	@Bean
	public CustomerDao customerDao() {
		CustomerDao dao=new CustomerDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public IdcardsDao idcardsDao() {
		IdcardsDao dao=new IdcardsDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public LocalTicketDao localTicketDao() {
		LocalTicketDao dao=new LocalTicketDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
}

package com.bank.dao;

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
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=bank_system");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
	@Bean
	public AccountDao accountDao() {
		AccountDao dao=new AccountDaoImpl();
		dao.setDataSource(dataSource());
		return dao;
	}
	@Bean
	public BillDao billDao() {
		BillDao dao=new BillDaoImpl();
		dao.setDataSource(dataSource());
		dao.setAccountDao(accountDao());
		return dao;
	}
}

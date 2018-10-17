package com.mainticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mainticket.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_SELECT_CUSTOMER_ONE = "select username,password,idcard,realname from customer where username=?";
	private static String SQL_INSERT_CUSTOMER = "insert into customer (username,password,idcard,realname) values(?,?,?,?)";
	private static String SQL_DELETE_CUSTOMER_ONE = "delete  from customer where username=?";
	private static String SQL_SELECT_CUSTOMER_ALL = "select username,password,idcard,realname from customer";

	private class CustomerMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Customer(rs.getString("username"), rs.getString("password"),rs.getString("idcard"), rs.getString("realname"));
		}
	}

	@Required
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addCustomer(String username, String password, String idcard, String realname) {
		try {
			if (jdbcTemplate.update(SQL_INSERT_CUSTOMER, username, password,idcard, realname) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(String username) {
		try {
			if (jdbcTemplate.update(SQL_DELETE_CUSTOMER_ONE, username) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer getCustomer(String username) {
		Customer f = null;
		try {
			f = jdbcTemplate.queryForObject(SQL_SELECT_CUSTOMER_ONE, new CustomerMapper(), username);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return jdbcTemplate.query(SQL_SELECT_CUSTOMER_ALL, new CustomerMapper());
	}

}

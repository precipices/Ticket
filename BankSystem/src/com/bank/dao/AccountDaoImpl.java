package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.entity.Account;

//create table customer(
//idcard varchar(20) primary key ,	--身份证号
//password varchar(20) not null,		--密码
//name nvarchar(20) not null,			--姓名
//balance int not null default 0		--余额
//)
@WebService
public class AccountDaoImpl implements AccountDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_SELECT_ACCOUNT_ONE = "select idcard, password, name, balance from customer where idcard = ?";
	private static String SQL_INSERT_ACCOUNT = "insert into customer (idcard, password, name, balance) values(?,?,?,?)";
	private static String SQL_DELETE_ACCOUNT_ONE = "delete from customer where idcard = ?";
	private static String SQL_SELECT_ACCOUNT_ALL = "select idcard, password, name, balance from customer";
	private static String SQL_SELECT_ACCOUNTS_NAME = "select idcard, password, name, balance from customer where name=?";
	private static String SQL_GET_ACCOUNT_BALANCE = "select balance from customer where idcard=? and password=?";
	private static String SQL_CHANGE_ACCOUNT_BALANCE = "update customer set balance=? where idcard=? and password=?";

	private class AccountMapper implements RowMapper<Account> {
		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Account(rs.getString("idcard"), rs.getString("password"), rs.getString("name"),
					rs.getInt("balance"));
		}
	}

	@WebMethod(exclude = true)
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@WebMethod(exclude = true)
	@Override
	public boolean addAccount(String idcard, String password, String name, int balance) {
		try {
			if (jdbcTemplate.update(SQL_INSERT_ACCOUNT, idcard, password, name, balance) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@WebMethod(exclude = true)
	@Override
	public boolean deleteAccount(String idcard) {
		try {
			if (jdbcTemplate.update(SQL_DELETE_ACCOUNT_ONE, idcard) > 0) {
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
	public Account getAccount(String idcard) {
		Account f = null;
		try {
			f = jdbcTemplate.queryForObject(SQL_SELECT_ACCOUNT_ONE, new AccountMapper(), idcard);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	@Override
	public List<Account> getAccountsByName(String name) {
		return jdbcTemplate.query(SQL_SELECT_ACCOUNTS_NAME, new AccountMapper(), name);
	}

	@Override
	public List<Account> getAllAccounts() {
		return jdbcTemplate.query(SQL_SELECT_ACCOUNT_ALL, new AccountMapper());
	}

	@Override
	public int getAccountBalance(String idcard, String password) {
		int balance = -1;
		try {
			balance = jdbcTemplate.queryForObject(SQL_GET_ACCOUNT_BALANCE, int.class, idcard, password);
		} catch (Exception e) {
			return -1;
		}
		return balance;
	}

	@WebMethod(exclude = true)
	@Override
	public boolean changeAccountBalance(String idcard, String password, int balance) {
		if (balance < 0)
			return false;
		try {
			if (jdbcTemplate.update(SQL_CHANGE_ACCOUNT_BALANCE, balance, idcard, password) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateAccountBalance(String idcard, String password, int pay) {
		int balance = getAccountBalance(idcard, password);
		if (balance == -1) {
			return false;
		} else if (balance + pay < 0) {
			return false;
		}
		return changeAccountBalance(idcard, password, balance + pay);
	}

}

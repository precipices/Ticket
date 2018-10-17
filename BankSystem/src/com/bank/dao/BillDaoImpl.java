package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bank.entity.Account;
import com.bank.entity.Bill;

//create table bill(
//idcard varchar(20) foreign key references customer(idcard) on delete cascade,			--身份证号
//cost int,					--费用
//fromCompany nvarchar(50),	--收费方
//paydate datetime			--付款时间
//)
@WebService
public class BillDaoImpl implements BillDao {
	private DataSource dataSource;
	private AccountDao accountDao;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_SELECT_BILLS_ACCOUNT = "select idcard,cost,fromCompany,paydate from bill where idcard = ?";
	private static String SQL_INSERT_BILL = "insert into bill (idcard,cost,fromCompany,paydate) values(?,?,?,?)";
	private static String SQL_SELECT_BILL_ALL = "select idcard,cost,fromCompany,paydate from bill";

	private class BillMapper implements RowMapper<Bill> {

		@Override
		public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Bill(rs.getString("idcard"), rs.getInt("cost"), rs.getString("fromCompany"),
					rs.getTimestamp("paydate"));
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
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao=accountDao;
	}
	@Override
	public List<Bill> getAccountBills(String idcard) {
		return jdbcTemplate.query(SQL_SELECT_BILLS_ACCOUNT, new BillMapper(), idcard);
	}
	@Override
	public int checkPassword(String idcard, String password) {
		Account a=accountDao.getAccount(idcard);
		if(a==null) {
			return BillDao.IDCARD_NOT_EXIST;
		}else if(!a.getPassword().equals(password)) {
			return BillDao.PASSWORD_WRONG;
		}
		return BillDao.PASSWORD_TRUE;
	}
	@Override
	public int charge(String idcard, String password,int cost, String fromCompany, Date paydate) {
		int check=checkPassword(idcard,password);
		if(check!=BillDao.PASSWORD_TRUE)
			return check;
		if(cost<=0) {
			return BillDao.COST_MINUS;
		}
		int balance = accountDao.getAccountBalance(idcard, password);
		if(cost>balance) {
			return BillDao.BALANCE_NOT_ENOUGH;
		}
		if(!accountDao.updateAccountBalance(idcard, password, -cost)) {
			return BillDao.UPDATE_BALANCE_FALSE;
		}
		if(addBill(idcard, cost, fromCompany, paydate)!=BillDao.INSERT_BILL_TRUE) {
			return BillDao.INSERT_BILL_FALSE;
		}
		return BillDao.CHARGE_TRUE;
	};
	@WebMethod(exclude = true)
	@Override
	public	int addBill(String idcard, int cost, String fromCompany, Date paydate) {
		if(cost<=0)
			return BillDao.COST_MINUS;
		try {
			if (jdbcTemplate.update(SQL_INSERT_BILL, idcard, cost, fromCompany, paydate) > 0) {
				return BillDao.INSERT_BILL_TRUE;
			} else {
				return BillDao.INSERT_BILL_FALSE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return BillDao.INSERT_BILL_FALSE;
		}
	}

	@Override
	public List<Bill> getAllBills() {
		return jdbcTemplate.query(SQL_SELECT_BILL_ALL, new BillMapper());
	}

}

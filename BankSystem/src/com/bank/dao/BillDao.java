package com.bank.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.bank.entity.Bill;
//create table bill(
//idcard varchar(20) foreign key references customer(idcard) on delete cascade,			--身份证号
//cost int,					--费用
//fromCompany nvarchar(50),	--收费方
//paydate datetime			--付款时间
//)
public interface BillDao {

	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	public void setAccountDao(AccountDao accountDao);
	/**
	 * 根据身份证号查询一个账户的所有账单的详细信息
	 * @param idcard	身份证号
	 * @return	返回List<Bill>,没有账户时,返回的List的size为0,而不是返回一个null
	 */
	public List<Bill> getAccountBills(String idcard);
	/**
	 * 得到所有账单的信息
	 * @return	没有账单时,返回的List的size为0,而不是返回一个null
	 */
	public List<Bill> getAllBills();
	public int charge(String idcard, String password, int cost, String fromCompany, Date paydate);
	public final static int IDCARD_NOT_EXIST=1;
	public final static int PASSWORD_WRONG=2;
	public final static int PASSWORD_TRUE=3;
	public final static int COST_MINUS=4;
	public final static int INSERT_BILL_FALSE=5;
	public final static int INSERT_BILL_TRUE=6;
	public final static int UPDATE_BALANCE_FALSE=7;
	public final static int CHARGE_TRUE=8;
	public final static int BALANCE_NOT_ENOUGH=9;
	public int checkPassword(String idcard, String password);
	/**
	 * 新建账单,并扣除账户相应余额
	 * @param idcard		身份证号
	 * @param cost			费用
	 * @param fromCompany	收费方
	 * @param paydate 		付款时间
	 * @return 返回一个false表示添加失败(如余额不足)
	 */
	public int addBill(String idcard, int cost, String fromCompany, Date paydate);
}

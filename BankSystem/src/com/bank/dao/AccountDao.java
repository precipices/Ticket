package com.bank.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.bank.entity.Account;
//create table customer(
//idcard varchar(20) primary key ,	--身份证号
//password varchar(20) not null,		--密码
//name nvarchar(20) not null,			--姓名
//balance int not null default 0		--余额
//)
public interface AccountDao {
	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 增加一个账户
	 * @return 若已有该账户返回false
	 */
	public boolean addAccount(String idcard,String password,String name,int balance);
	/**
	 * 删除一个账户
	 * @return 没有可删除的账户时返回false
	 */
	public boolean deleteAccount(String idcard);
	/**
	 * 根据idcard查询一个账户的详细信息
	 * @param idcard	身份证号
	 * @return	返回Account,一个账户的实体类
	 */
	public Account getAccount(String idcard);
	/**
	 * 根据姓名查询账户的详细信息
	 * @param name
	 * @return 因为可能有同名情况,所以会返回一个list
	 */
	public List<Account> getAccountsByName(String name);
	/**
	 * 得到所有账户的信息
	 * @return 没有账户时,返回的List的size为0,而不是返回一个null
	 */
	public List<Account> getAllAccounts();
	/**
	 * 得到账户余额
	 * @return	返回值为-1表示用户名或密码错误
	 */
	public int getAccountBalance(String idcard,String password);
	/**
	 * 修改账户余额
	 * @param idcard	身份证号不存在则返回false
	 * @param password	密码不正确则返回false
	 * @param balance	小于0返回false
	 * @return
	 */
	public boolean changeAccountBalance(String idcard,String password,int balance);
	/**
	 * 增加或减少账户余额
	 * @param idcard	身份证号不存在则返回false
	 * @param password	密码不正确则返回false
	 * @param pay	大于0是增加,小于0是减少,减少时若会使余额小于0则返回false;
	 * @return
	 */
	public boolean updateAccountBalance(String idcard,String password,int pay);
}

package com.mainticket.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.Customer;
//以下为数据库的建表语句:
//create table customer(
//idcard varchar(20) primary key,	--身份证号
//password varchar(20) not null,	--密码
//name nvarchar(20) not null,		--姓名 
//)
public interface CustomerDao {
	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 增加一个用户
	 * @return 若已有该用户返回false
	 */
	public boolean addCustomer(String username, String password, String idcard, String realname);
	/**
	 * 删除一个用户
	 * @return 没有可删除的用户时返回false
	 */
	public boolean deleteCustomer(String username);
	/**
	 * 根据用户名查询一个用户
	 * @param username	用户名
	 * @return	返回Customer,一个用户的实体类
	 */
	public Customer getCustomer(String username);
	/**
	 * 得到所有用户的信息
	 * @return 没有用户时,返回的List的size为0,而不是返回一个null
	 */
	public List<Customer> getAllCustomers();
}

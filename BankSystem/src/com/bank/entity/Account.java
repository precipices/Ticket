package com.bank.entity;
/**
 * 本类为数据库customer表对应的实体类
 */
//  以下为数据库的建表语句:
//create table customer(
//	idcard varchar(20) primary key ,	--身份证号
//	password varchar(20) not null,		--密码
//	name nvarchar(20) not null,			--姓名
//	balance int not null default 0		--余额
//)
public class Account {
	private String idcard;
	private String password;
	private String name;
	private int balance;
	public Account(String idcard, String password, String name, int balance) {
		super();
		this.idcard = idcard;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [idcard=" + idcard + ", password=" + password + ", name=" + name + ", balance=" + balance + "]";
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}

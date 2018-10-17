package com.bank.entity;
/**
 * ����Ϊ���ݿ�customer���Ӧ��ʵ����
 */
//  ����Ϊ���ݿ�Ľ������:
//create table customer(
//	idcard varchar(20) primary key ,	--���֤��
//	password varchar(20) not null,		--����
//	name nvarchar(20) not null,			--����
//	balance int not null default 0		--���
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

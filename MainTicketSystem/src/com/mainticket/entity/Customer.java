package com.mainticket.entity;
import java.util.Date;

/**
 * 本类为数据库customer表对应的实体类
 */
//  以下为数据库的建表语句:
//create table customer(
//	username nvarchar(50) primary key,	--用户名
//	password varchar(20) not null,		--密码
//	idcard varchar(20) not null,		--身份证号
//	realname nvarchar(20) not null,		--真实姓名
//)
public class Customer {
	private String username;
	private String password;
	private String idcard;
	private String realname;
	public Customer(String username, String password, String idcard, String realname) {
		super();
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.realname = realname;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", idcard=" + idcard + ", realname="
				+ realname + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}

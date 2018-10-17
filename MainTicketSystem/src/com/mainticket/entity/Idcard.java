package com.mainticket.entity;

/**
 * 本类为数据库idcards表对应的实体类
 */
//以下为数据库的建表语句:
//create table idcards(
//	username nvarchar(50) foreign key references customer(username),	--用户名
//	idcard varchar(20) not null,	--身份证号
//	realname nvarchar(20) not null,	--真实姓名
//)
public class Idcard {
	private String username;
	private String idcard;
	private String realname;
	public Idcard(String username, String idcard, String realname) {
		super();
		this.username = username;
		this.idcard = idcard;
		this.realname = realname;
	}
	@Override
	public String toString() {
		return "Idcard [username=" + username + ", idcard=" + idcard + ", realname=" + realname + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

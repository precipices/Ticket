package com.mainticket.entity;

/**
 * ����Ϊ���ݿ�idcards���Ӧ��ʵ����
 */
//����Ϊ���ݿ�Ľ������:
//create table idcards(
//	username nvarchar(50) foreign key references customer(username),	--�û���
//	idcard varchar(20) not null,	--���֤��
//	realname nvarchar(20) not null,	--��ʵ����
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

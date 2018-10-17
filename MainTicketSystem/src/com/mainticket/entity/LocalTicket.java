package com.mainticket.entity;

import java.util.Date;

/**
 * ����Ϊ���ݿ�idcards���Ӧ��ʵ����
 */
//����Ϊ���ݿ�Ľ������:
//create table ticket(
//		username varchar(20) foreign key references customer(username) on delete cascade,
//		flight varchar(20) not null,		--�����
//		beginTime smalldatetime not null,	--�ǻ�ʱ��
//		fromWhere nvarchar(20 )not null,	--������
//		toWhere nvarchar(20) not null,		--Ŀ�ĵ�
//		name varchar(20),					--����
//		idcard varchar(20),					--���֤��
//		seatNumber int not null,			--��λ��
//		price int default 100 not null,		--�۸�
//		primary key(flight,beginTime,idcard)
//)
public class LocalTicket {
	private String username;
	private String flight;
	private Date beginTime;
	private String fromWhere;
	private String toWhere;
	private String realname;
	private String idcard;
	private int seatNumber;
	private int price;
	private String fromBank;
	private String fromAgent;
	public LocalTicket(String username, String flight, Date beginTime, String fromWhere, String toWhere,
			String realname, String idcard, int seatNumber, int price, String fromBank, String fromAgent) {
		super();
		this.username = username;
		this.flight = flight;
		this.beginTime = beginTime;
		this.fromWhere = fromWhere;
		this.toWhere = toWhere;
		this.realname = realname;
		this.idcard = idcard;
		this.seatNumber = seatNumber;
		this.price = price;
		this.fromBank = fromBank;
		this.fromAgent = fromAgent;
	}
	@Override
	public String toString() {
		return "LocalTicket [username=" + username + ", flight=" + flight + ", beginTime=" + beginTime + ", fromWhere="
				+ fromWhere + ", toWhere=" + toWhere + ", realname=" + realname + ", idcard=" + idcard + ", seatNumber="
				+ seatNumber + ", price=" + price + ", fromBank=" + fromBank + ", fromAgent=" + fromAgent + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public String getFromWhere() {
		return fromWhere;
	}
	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}
	public String getToWhere() {
		return toWhere;
	}
	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFromBank() {
		return fromBank;
	}
	public void setFromBank(String fromBank) {
		this.fromBank = fromBank;
	}
	public String getFromAgent() {
		return fromAgent;
	}
	public void setFromAgent(String fromAgent) {
		this.fromAgent = fromAgent;
	}
}

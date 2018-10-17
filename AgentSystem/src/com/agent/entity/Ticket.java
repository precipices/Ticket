package com.agent.entity;

import java.util.Date;

/**
 * 本类为数据库ticket表对应的实体类
 */
//  以下为数据库的建表语句:
//create table ticket(
//	flight varchar(20),			--航班
//	begintime smalldatetime,	--登机时间
//	seatNumber int,				--座位号
//	idcard varchar(20),			--身份证号
//	name varchar(20),			--姓名
//	foreign key (flight,begintime) references flight(flight,begintime) on delete cascade
//)
public class Ticket {
	private String flight;
	private Date beginTime;
	private int seatNumber;
	private String idcard;
	private String name;
	public Ticket(String flight, Date beginTime, int seatNumber, String idcard, String name) {
		super();
		this.flight = flight;
		this.beginTime = beginTime;
		this.seatNumber = seatNumber;
		this.idcard = idcard;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Ticket [flight=" + flight + ", beginTime=" + beginTime + ", seatNumber=" + seatNumber + ", idcard="
				+ idcard + ", name=" + name + "]";
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
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

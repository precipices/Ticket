package com.agent.entity;
import java.util.Date;

/**
 * 本类为数据库flight表对应的实体类
 */
//  以下为数据库的建表语句:
//create table flight(
//	flight varchar(20) not null,		--航班
//	beginTime smalldatetime not null,	--登机时间
//	fromWhere nvarchar(20 )not null,	--出发地
//	toWhere nvarchar(20) not null,		--目的地
//	price int default 100 not null,		--价格
//	seatsNum int default 100 not null,	--座位数量
//	primary key(flight,begintime)
//)
public class Flight {
	private String flight;
	private Date beginTime;
	private String fromWhere;
	private String toWhere;
	private int price;
	private int seatsNum;
//	public Flight() {}
	public Flight(String flight, Date beginTime, String fromWhere, String toWhere, int price, int seatsNum) {
		super();
		this.flight = flight;
		this.beginTime = beginTime;
		this.fromWhere = fromWhere;
		this.toWhere = toWhere;
		this.price = price;
		this.seatsNum = seatsNum;
	}
	@Override
	public String toString() {
		return "Flight [flight=" + flight + ", beginTime=" + beginTime + ", fromWhere=" + fromWhere + ", toWhere="
				+ toWhere + ", price=" + price + ", seatsNum=" + seatsNum + "]";
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeatsNum() {
		return seatsNum;
	}
	public void setSeatsNum(int seatsNum) {
		this.seatsNum = seatsNum;
	}
}

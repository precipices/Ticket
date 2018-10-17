package com.bank.entity;

import java.util.Date;

/**
 * 本类为数据库bill表对应的实体类
 */
//  以下为数据库的建表语句:
//create table bill(
//	idcard varchar(20) foreign key references customer(idcard) on delete cascade,			--身份证号
//	cost int,					--费用
//	fromCompany nvarchar(50),	--收费方
//	paydate datetime			--付款时间
//)
public class Bill {
	private String idcard;
	private int cost;
	private String fromCompany;
	private Date paydate;
	public Bill(String idcard, int cost, String fromCompany, Date paydate) {
		super();
		this.idcard = idcard;
		this.cost = cost;
		this.fromCompany = fromCompany;
		this.paydate = paydate;
	}
	@Override
	public String toString() {
		return "Bill [idcard=" + idcard + ", cost=" + cost + ", fromCompany=" + fromCompany + ", paydate=" + paydate
				+ "]";
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getFromCompany() {
		return fromCompany;
	}
	public void setFromCompany(String fromCompany) {
		this.fromCompany = fromCompany;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
}

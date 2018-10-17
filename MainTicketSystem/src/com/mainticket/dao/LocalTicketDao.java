package com.mainticket.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.LocalTicket;

//以下为数据库的建表语句:
//create table ticket(
//	username varchar(20) foreign key references customer(username) on delete cascade,
//	flight varchar(20) not null,		--航班号
//	beginTime smalldatetime not null,	--登机时间
//	fromWhere nvarchar(20 )not null,	--出发地
//	toWhere nvarchar(20) not null,		--目的地
//	name varchar(20),					--姓名
//	idcard varchar(20),					--机票号
//	seatNumber int not null,			--座位号
//	price int default 100 not null,		--价格
//	primary key(flight,beginTime,idcard)
//)
public interface LocalTicketDao {
	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 增加一个机票
	 * @return 若已有该机票返回false
	 */
	public boolean addTicket(String username, String flight, Date beginTime, String fromWhere, String toWhere,
			String realname, String idcard, int seatNumber, int price,String fromBank,String fromAgent);
	/**
	 * 删除一个机票
	 * @return 没有可删除的机票时返回false
	 */
	public boolean deleteTicket(String flight,Date beginTime,String idcard);
	/**
	 * 根据用户名查询一个用户在通过本网站购买的所有机票
	 * @param username	用户名
	 * @return	没有用户时,返回的List的size为0,而不是返回一个null
	 */
	public List<LocalTicket> getTickets(String username);
}

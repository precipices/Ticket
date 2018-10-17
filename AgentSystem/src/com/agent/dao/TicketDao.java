package com.agent.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.agent.entity.Flight;
import com.agent.entity.Ticket;

public interface TicketDao {

	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 根据航班号和时间查询一个航班的所有机票的详细信息
	 * @param flight	航班号
	 * @param beginTime 登机时间
	 * @return	返回List<Ticket>,没有航班时,返回的List的size为0,而不是返回一个null
	 */
	public List<Ticket> getFlightTickets(String flight,Date beginTime);
	/**
	 * 查询某航班的剩余机票数量
	 * @param flight	航班号
	 * @param beginTime 登机时间
	 * @return 返回剩余机票数量,为0可能是余量为0,也可能是没有该航班
	 */
	public int getFlightLeftTickets(String flight,Date beginTime);
	/**
	 * 购买机票,选择该航班的一张未出售机票(座位号从小到大买),更新机票对应的idcard和姓名
	 * @param idcard	身份证号
	 * @param name		姓名
	 * @param flight	航班号
	 * @param beginTime 登机时间
	 * @return 返回一个Ticket的实体类对象,返回null表示没有机票或身份证号已购买该航班的机票
	 */
	public Ticket buyTickets(String idcard,String name,String flight,Date beginTime);
	/**
	 * 查询一张已出售的机票
	 * @param flight	航班号
	 * @param beginTime 登机时间
	 * @param idcard	身份证号
	 * @param name		姓名
	 * @return	返回一个Ticket的实体类对象,返回null表示没有该机票
	 */
	public Ticket getSoldTicket(String flight,Date beginTime,String idcard);
}

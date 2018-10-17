package com.agent.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.agent.entity.Flight;
//create table ticket(
//	flight varchar(20) not null,		--航班
//	beginTime smalldatetime not null,	--登机时间
//	fromWhere nvarchar(20 )not null,	--出发地
//	toWhere nvarchar(20) not null,		--目的地
//	price int default 100 not null,		--价格
//	seatsNum int default 100 not null,	--座位数量
//	primary key(flight,begintime)
//)
public interface FlightDao {
	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 增加一个航班
	 * @return 若已有该航班返回false
	 */
	public boolean addFlight(String flight,Date beginTime,String fromWhere,String toWhere,int price,int seatsNum);
	/**
	 * 删除一个航班
	 * @return 没有可删除的航班时返回false
	 */
	public boolean deleteFlight(String flight,Date beginTime);
	/**
	 * 根据航班号和时间查询一个航班的详细信息
	 * @param flight	航班号
	 * @param beginTime 登机时间
	 * @return	返回Flight,一个航班的实体类
	 */
	public Flight getFlight(String flight,Date beginTime);
	/**
	 * 根据航班号和时间查询一个航班的详细信息
	 * @param flight	航班号
	 * @param beginTime 登机时间,格式"yyyy-MM-dd HH:mm"
	 * @return	返回Flight,一个航班的实体类,没有该航班时返回null
	 */
	public Flight getFlight(String flight,String beginTime);
	/**
	 * 根据时间,出发地,目的地 查询当日所有该方向航班的详细信息
	 * @param beginTime	登机时间,格式"yyyy-MM-dd",最好不要带时分,带时分会自动截断,只计算日期
	 * @param fromWhere	出发地
	 * @param toWhere	目的地
	 * @return			返回List<Flight>,航班实体类的list
	 */
	public List<Flight> getFlights(Date beginTime,String fromWhere,String toWhere);
	/**
	 * 得到所有航班的信息
	 * @return 没有航班时,返回的List的size为0,而不是返回一个null
	 */
	public List<Flight> getAllFlights();
}

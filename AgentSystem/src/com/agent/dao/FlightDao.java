package com.agent.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.agent.entity.Flight;
//create table ticket(
//	flight varchar(20) not null,		--����
//	beginTime smalldatetime not null,	--�ǻ�ʱ��
//	fromWhere nvarchar(20 )not null,	--������
//	toWhere nvarchar(20) not null,		--Ŀ�ĵ�
//	price int default 100 not null,		--�۸�
//	seatsNum int default 100 not null,	--��λ����
//	primary key(flight,begintime)
//)
public interface FlightDao {
	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ����һ������
	 * @return �����иú��෵��false
	 */
	public boolean addFlight(String flight,Date beginTime,String fromWhere,String toWhere,int price,int seatsNum);
	/**
	 * ɾ��һ������
	 * @return û�п�ɾ���ĺ���ʱ����false
	 */
	public boolean deleteFlight(String flight,Date beginTime);
	/**
	 * ���ݺ���ź�ʱ���ѯһ���������ϸ��Ϣ
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��
	 * @return	����Flight,һ�������ʵ����
	 */
	public Flight getFlight(String flight,Date beginTime);
	/**
	 * ���ݺ���ź�ʱ���ѯһ���������ϸ��Ϣ
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��,��ʽ"yyyy-MM-dd HH:mm"
	 * @return	����Flight,һ�������ʵ����,û�иú���ʱ����null
	 */
	public Flight getFlight(String flight,String beginTime);
	/**
	 * ����ʱ��,������,Ŀ�ĵ� ��ѯ�������и÷��򺽰����ϸ��Ϣ
	 * @param beginTime	�ǻ�ʱ��,��ʽ"yyyy-MM-dd",��ò�Ҫ��ʱ��,��ʱ�ֻ��Զ��ض�,ֻ��������
	 * @param fromWhere	������
	 * @param toWhere	Ŀ�ĵ�
	 * @return			����List<Flight>,����ʵ�����list
	 */
	public List<Flight> getFlights(Date beginTime,String fromWhere,String toWhere);
	/**
	 * �õ����к������Ϣ
	 * @return û�к���ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Flight> getAllFlights();
}

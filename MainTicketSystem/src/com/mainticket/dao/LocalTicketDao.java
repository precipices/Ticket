package com.mainticket.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.LocalTicket;

//����Ϊ���ݿ�Ľ������:
//create table ticket(
//	username varchar(20) foreign key references customer(username) on delete cascade,
//	flight varchar(20) not null,		--�����
//	beginTime smalldatetime not null,	--�ǻ�ʱ��
//	fromWhere nvarchar(20 )not null,	--������
//	toWhere nvarchar(20) not null,		--Ŀ�ĵ�
//	name varchar(20),					--����
//	idcard varchar(20),					--��Ʊ��
//	seatNumber int not null,			--��λ��
//	price int default 100 not null,		--�۸�
//	primary key(flight,beginTime,idcard)
//)
public interface LocalTicketDao {
	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ����һ����Ʊ
	 * @return �����иû�Ʊ����false
	 */
	public boolean addTicket(String username, String flight, Date beginTime, String fromWhere, String toWhere,
			String realname, String idcard, int seatNumber, int price,String fromBank,String fromAgent);
	/**
	 * ɾ��һ����Ʊ
	 * @return û�п�ɾ���Ļ�Ʊʱ����false
	 */
	public boolean deleteTicket(String flight,Date beginTime,String idcard);
	/**
	 * �����û�����ѯһ���û���ͨ������վ��������л�Ʊ
	 * @param username	�û���
	 * @return	û���û�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<LocalTicket> getTickets(String username);
}

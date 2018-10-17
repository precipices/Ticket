package com.agent.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.agent.entity.Flight;
import com.agent.entity.Ticket;

public interface TicketDao {

	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ���ݺ���ź�ʱ���ѯһ����������л�Ʊ����ϸ��Ϣ
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��
	 * @return	����List<Ticket>,û�к���ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Ticket> getFlightTickets(String flight,Date beginTime);
	/**
	 * ��ѯĳ�����ʣ���Ʊ����
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��
	 * @return ����ʣ���Ʊ����,Ϊ0����������Ϊ0,Ҳ������û�иú���
	 */
	public int getFlightLeftTickets(String flight,Date beginTime);
	/**
	 * �����Ʊ,ѡ��ú����һ��δ���ۻ�Ʊ(��λ�Ŵ�С������),���»�Ʊ��Ӧ��idcard������
	 * @param idcard	���֤��
	 * @param name		����
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��
	 * @return ����һ��Ticket��ʵ�������,����null��ʾû�л�Ʊ�����֤���ѹ���ú���Ļ�Ʊ
	 */
	public Ticket buyTickets(String idcard,String name,String flight,Date beginTime);
	/**
	 * ��ѯһ���ѳ��۵Ļ�Ʊ
	 * @param flight	�����
	 * @param beginTime �ǻ�ʱ��
	 * @param idcard	���֤��
	 * @param name		����
	 * @return	����һ��Ticket��ʵ�������,����null��ʾû�иû�Ʊ
	 */
	public Ticket getSoldTicket(String flight,Date beginTime,String idcard);
}

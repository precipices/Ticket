package com.mainticket.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.Customer;
//����Ϊ���ݿ�Ľ������:
//create table customer(
//idcard varchar(20) primary key,	--���֤��
//password varchar(20) not null,	--����
//name nvarchar(20) not null,		--���� 
//)
public interface CustomerDao {
	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ����һ���û�
	 * @return �����и��û�����false
	 */
	public boolean addCustomer(String username, String password, String idcard, String realname);
	/**
	 * ɾ��һ���û�
	 * @return û�п�ɾ�����û�ʱ����false
	 */
	public boolean deleteCustomer(String username);
	/**
	 * �����û�����ѯһ���û�
	 * @param username	�û���
	 * @return	����Customer,һ���û���ʵ����
	 */
	public Customer getCustomer(String username);
	/**
	 * �õ������û�����Ϣ
	 * @return û���û�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Customer> getAllCustomers();
}

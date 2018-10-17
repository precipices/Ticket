package com.mainticket.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.Customer;
import com.mainticket.entity.Idcard;

//����Ϊ���ݿ�Ľ������:
//create table idcards(
//	username nvarchar(50) foreign key references customer(username),	--�û���
//	idcard varchar(20) not null,	--���֤��
//	realname nvarchar(20) not null,	--��ʵ����
//	primary key(username,idcard)
//)
public interface IdcardsDao {
	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ����һ�����֤
	 * @return �����и��û��ĸ����֤����false
	 */
	public boolean addIdcard(String username, String idcard, String realname);
	/**
	 * ɾ���û���һ�����֤
	 * @return û�п�ɾ�������֤ʱ����false
	 */
	public boolean deleteIdcard(String username, String idcard);
	/**
	 * �����û�����ѯһ���û�������������֤
	 * @param username	�û���
	 * @return	û���û�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Idcard> getIdcards(String username);
}

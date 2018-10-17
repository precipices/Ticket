package com.bank.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.bank.entity.Account;
//create table customer(
//idcard varchar(20) primary key ,	--���֤��
//password varchar(20) not null,		--����
//name nvarchar(20) not null,			--����
//balance int not null default 0		--���
//)
public interface AccountDao {
	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * ����һ���˻�
	 * @return �����и��˻�����false
	 */
	public boolean addAccount(String idcard,String password,String name,int balance);
	/**
	 * ɾ��һ���˻�
	 * @return û�п�ɾ�����˻�ʱ����false
	 */
	public boolean deleteAccount(String idcard);
	/**
	 * ����idcard��ѯһ���˻�����ϸ��Ϣ
	 * @param idcard	���֤��
	 * @return	����Account,һ���˻���ʵ����
	 */
	public Account getAccount(String idcard);
	/**
	 * ����������ѯ�˻�����ϸ��Ϣ
	 * @param name
	 * @return ��Ϊ������ͬ�����,���Ի᷵��һ��list
	 */
	public List<Account> getAccountsByName(String name);
	/**
	 * �õ������˻�����Ϣ
	 * @return û���˻�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Account> getAllAccounts();
	/**
	 * �õ��˻����
	 * @return	����ֵΪ-1��ʾ�û������������
	 */
	public int getAccountBalance(String idcard,String password);
	/**
	 * �޸��˻����
	 * @param idcard	���֤�Ų������򷵻�false
	 * @param password	���벻��ȷ�򷵻�false
	 * @param balance	С��0����false
	 * @return
	 */
	public boolean changeAccountBalance(String idcard,String password,int balance);
	/**
	 * ���ӻ�����˻����
	 * @param idcard	���֤�Ų������򷵻�false
	 * @param password	���벻��ȷ�򷵻�false
	 * @param pay	����0������,С��0�Ǽ���,����ʱ����ʹ���С��0�򷵻�false;
	 * @return
	 */
	public boolean updateAccountBalance(String idcard,String password,int pay);
}

package com.bank.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.bank.entity.Bill;
//create table bill(
//idcard varchar(20) foreign key references customer(idcard) on delete cascade,			--���֤��
//cost int,					--����
//fromCompany nvarchar(50),	--�շѷ�
//paydate datetime			--����ʱ��
//)
public interface BillDao {

	/**
	 * ��������Դ
	 */
	public void setDataSource(DataSource dataSource);
	public void setAccountDao(AccountDao accountDao);
	/**
	 * �������֤�Ų�ѯһ���˻��������˵�����ϸ��Ϣ
	 * @param idcard	���֤��
	 * @return	����List<Bill>,û���˻�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Bill> getAccountBills(String idcard);
	/**
	 * �õ������˵�����Ϣ
	 * @return	û���˵�ʱ,���ص�List��sizeΪ0,�����Ƿ���һ��null
	 */
	public List<Bill> getAllBills();
	public int charge(String idcard, String password, int cost, String fromCompany, Date paydate);
	public final static int IDCARD_NOT_EXIST=1;
	public final static int PASSWORD_WRONG=2;
	public final static int PASSWORD_TRUE=3;
	public final static int COST_MINUS=4;
	public final static int INSERT_BILL_FALSE=5;
	public final static int INSERT_BILL_TRUE=6;
	public final static int UPDATE_BALANCE_FALSE=7;
	public final static int CHARGE_TRUE=8;
	public final static int BALANCE_NOT_ENOUGH=9;
	public int checkPassword(String idcard, String password);
	/**
	 * �½��˵�,���۳��˻���Ӧ���
	 * @param idcard		���֤��
	 * @param cost			����
	 * @param fromCompany	�շѷ�
	 * @param paydate 		����ʱ��
	 * @return ����һ��false��ʾ���ʧ��(������)
	 */
	public int addBill(String idcard, int cost, String fromCompany, Date paydate);
}

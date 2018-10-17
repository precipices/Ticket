package com.mainticket.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mainticket.entity.Customer;
import com.mainticket.entity.Idcard;

//以下为数据库的建表语句:
//create table idcards(
//	username nvarchar(50) foreign key references customer(username),	--用户名
//	idcard varchar(20) not null,	--身份证号
//	realname nvarchar(20) not null,	--真实姓名
//	primary key(username,idcard)
//)
public interface IdcardsDao {
	/**
	 * 配置数据源
	 */
	public void setDataSource(DataSource dataSource);
	/**
	 * 增加一个身份证
	 * @return 若已有该用户的该身份证返回false
	 */
	public boolean addIdcard(String username, String idcard, String realname);
	/**
	 * 删除用户的一个身份证
	 * @return 没有可删除的身份证时返回false
	 */
	public boolean deleteIdcard(String username, String idcard);
	/**
	 * 根据用户名查询一个用户保存的所有身份证
	 * @param username	用户名
	 * @return	没有用户时,返回的List的size为0,而不是返回一个null
	 */
	public List<Idcard> getIdcards(String username);
}

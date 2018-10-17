package com.mainticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mainticket.entity.Idcard;

public class IdcardsDaoImpl implements IdcardsDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_INSERT_IDCARD = "insert into idcards (username,idcard,realname) values(?,?,?)";
	private static String SQL_DELETE_IDCARD_ONE = "delete from idcards where username=? and idcard=?";
	private static String SQL_SELECT_IDCARD = "select username,idcard,realname from idcards where username=?";

	private class IdcardMapper implements RowMapper<Idcard> {
		@Override
		public Idcard mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Idcard(rs.getString("username"),rs.getString("idcard"), rs.getString("realname"));
		}
	}
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addIdcard(String username, String idcard, String realname) {
		try {
			if (jdbcTemplate.update(SQL_INSERT_IDCARD, username, idcard, realname) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteIdcard(String username, String idcard) {
		try {
			if (jdbcTemplate.update(SQL_DELETE_IDCARD_ONE, username,idcard) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Idcard> getIdcards(String username) {
		return jdbcTemplate.query(SQL_SELECT_IDCARD, new IdcardMapper(),username);
	}

}

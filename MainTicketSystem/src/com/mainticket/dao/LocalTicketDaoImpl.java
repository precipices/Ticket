package com.mainticket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mainticket.entity.LocalTicket;

public class LocalTicketDaoImpl implements LocalTicketDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_INSERT_TICKET = "insert into ticket (username, flight, beginTime, fromWhere, toWhere, realname,idcard, seatNumber, price,fromBank,fromAgent) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static String SQL_DELETE_TICKET_ONE = "delete from ticket where flight=? and beginTime=? and idcard=?";
	private static String SQL_SELECT_TICKET = "select username, flight, beginTime, fromWhere, toWhere, realname,idcard, seatNumber, price from ticket where username=?";

	private class LocalTicketMapper implements RowMapper<LocalTicket> {
		@Override
		public LocalTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new LocalTicket(rs.getString("username"), rs.getString("flight"), rs.getTimestamp("beginTime"),
					rs.getString("fromWhere"), rs.getString("toWhere"), rs.getString("realname"),
					rs.getString("idcard"), rs.getInt("seatNumber"), rs.getInt("price"),rs.getString("fromBank"),rs.getString("fromAgent"));
		}
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addTicket(String username, String flight, Date beginTime, String fromWhere, String toWhere,
			String realname, String idcard, int seatNumber, int price,String fromBank,String fromAgent) {
		try {
			if (jdbcTemplate.update(SQL_INSERT_TICKET, username, flight, beginTime, fromWhere, toWhere, realname,
					idcard, seatNumber, price,fromBank,fromAgent) > 0) {
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
	public boolean deleteTicket(String flight, Date beginTime, String idcard) {
		try {
			if (jdbcTemplate.update(SQL_DELETE_TICKET_ONE, flight, beginTime, idcard) > 0) {
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
	public List<LocalTicket> getTickets(String username) {
		return jdbcTemplate.query(SQL_SELECT_TICKET, new LocalTicketMapper(), username);
	}

}

package com.agent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.agent.entity.Ticket;

@WebService
public class TicketDaoImpl implements TicketDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_SELECT_TICKETS_FLIGHT = "select flight,begintime,seatNumber,idcard,name from ticket where flight = ? and beginTime = ?";
	private static String SQL_SELECT_TICKETS_LEFT = "select COUNT(seatNumber) from ticket where (idcard is null or idcard ='') and flight=? and begintime=?";
	private static String SQL_UPDATE_TICKET_IDCARD = "update top (1) ticket set idcard=? ,name=? where (idcard is null or idcard ='') and flight=? and begintime=?";
	private static String SQL_SELECT_TICKET_SOLD = "select flight,begintime,seatNumber,idcard,name from ticket where flight = ? and beginTime = ? and idcard=?";

	private class TicketMapper implements RowMapper<Ticket> {

		@Override
		public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Ticket(rs.getString("flight"), rs.getTimestamp("beginTime"), rs.getInt("seatNumber"),
					rs.getString("idcard"), rs.getString("name"));
		}

	}
	@WebMethod(exclude = true)
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@WebMethod(exclude = true)
	@Override
	public List<Ticket> getFlightTickets(String flight, Date beginTime) {
		return jdbcTemplate.query(SQL_SELECT_TICKETS_FLIGHT, new TicketMapper(), flight, beginTime);
	}

	@Override
	public int getFlightLeftTickets(String flight, Date beginTime) {
		return jdbcTemplate.queryForObject(SQL_SELECT_TICKETS_LEFT, Integer.class, flight, beginTime);
	}

	@Override
	public Ticket buyTickets(String idcard, String name, String flight, Date beginTime) {
		if (this.getSoldTicket(flight, beginTime, idcard) == null) {
			if (jdbcTemplate.update(SQL_UPDATE_TICKET_IDCARD, idcard, name, flight, beginTime) > 0) {
				return this.getSoldTicket(flight, beginTime, idcard);
			}
		}
		return null;
	}

	@Override
	public Ticket getSoldTicket(String flight, Date beginTime, String idcard) {
		Ticket t = null;
		try {
			t = jdbcTemplate.queryForObject(SQL_SELECT_TICKET_SOLD, new TicketMapper(), flight, beginTime, idcard);
		} catch (Exception e) {
			return null;
		}
		return t;
	}

}

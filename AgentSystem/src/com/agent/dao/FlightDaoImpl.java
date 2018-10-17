package com.agent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.agent.entity.Flight;

@WebService
public class FlightDaoImpl implements FlightDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static String SQL_SELECT_FLIGHT_ONE = "select flight,beginTime,fromWhere,toWhere,price,seatsNum from flight where flight = ? and beginTime = ?";
	private static String SQL_INSERT_FLIGHT = "insert into flight (flight,beginTime,fromWhere,toWhere,price,seatsNum) values(?,?,?,?,?,?)";
	private static String SQL_DELETE_FLIGHT_ONE = "delete from flight where flight = ? and beginTime = ?";
	private static String SQL_SELECT_FLIGHT_ALL = "select * from flight";
	private static String SQL_SELECT_FLIGHTS = "select flight,beginTime,fromWhere,toWhere,price,seatsNum from flight where beginTime >= ? and beginTime < ? and fromWhere = ? and toWhere=?";

	private class FlightMapper implements RowMapper<Flight> {
		@Override
		public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
			// System.out.println("beginTime-getTimestamp="+rs.getTimestamp("beginTime")+"beginTime-getString="+rs.getString("beginTime"));
			return new Flight(rs.getString("flight"), rs.getTimestamp("beginTime"), rs.getString("fromWhere"),
					rs.getString("toWhere"), rs.getInt("price"), rs.getInt("seatsNum"));
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
	public boolean addFlight(String flight, Date beginTime, String fromWhere, String toWhere, int price, int seatsNum) {
		try {
			if (jdbcTemplate.update(SQL_INSERT_FLIGHT, flight, beginTime, fromWhere, toWhere, price, seatsNum) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@WebMethod(exclude = true)
	@Override
	public boolean deleteFlight(String flight, Date beginTime) {
		try {
			if (jdbcTemplate.update(SQL_DELETE_FLIGHT_ONE, flight, beginTime) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@WebMethod(exclude = true)
	@Override
	public Flight getFlight(String flight, String beginTime) {
		Flight f = null;
		try {
			f = jdbcTemplate.queryForObject(SQL_SELECT_FLIGHT_ONE, new Object[] { flight, beginTime },
					new FlightMapper());
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	@Override
	public Flight getFlight(String flight, Date beginTime) {
		Flight f = null;
		try {
			f = jdbcTemplate.queryForObject(SQL_SELECT_FLIGHT_ONE, new Object[] { flight, beginTime },
					new FlightMapper());
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	@Override
	public List<Flight> getAllFlights() {
		return jdbcTemplate.query(SQL_SELECT_FLIGHT_ALL, new FlightMapper());
	}

	@Override
	public List<Flight> getFlights(Date beginTime, String fromWhere, String toWhere) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = null;
		try {
			begin = sdf.parse(sdf.format(beginTime));
		} catch (ParseException e) {
			return null;
		}
		Date end = new Date(begin.getTime() + 24 * 3600 * 1000);
		return jdbcTemplate.query(SQL_SELECT_FLIGHTS, new FlightMapper(), begin, end, fromWhere, toWhere);
	}

}

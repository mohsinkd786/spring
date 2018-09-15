package com.mohsinkd786.java.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mohsinkd786.java.spring.entity.Employ;

public class EmployDao {

	@Autowired
	private JdbcTemplate template;

	public List<Employ> getEmploys() {
		return template.query("SELECT * from employs", new EmployMapper());
	}
}

class EmployMapper implements RowMapper<Employ> {

	@Override
	public Employ mapRow(ResultSet results, int rowNum) throws SQLException {
		return new Employ(results.getInt("emp_id"), results.getString("name"), results.getString("email"),
				results.getInt("p_id"), results.getInt("salary"));
	}
}
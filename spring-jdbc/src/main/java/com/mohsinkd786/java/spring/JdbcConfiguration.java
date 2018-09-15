package com.mohsinkd786.java.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfiguration {

	@Value("${mysql.driver}")
	private String dbDriver;

	@Value("${mysql.url}")
	private String dbUrl;

	@Value("${mysql.user}")
	private String dbUser;

	@Value("${mysql.pass}")
	private String dbPass;

	@Bean
	public EmployDao dao() {
		return new EmployDao();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(dbDriver);
		source.setUrl(dbUrl);
		source.setUsername(dbUser);
		source.setPassword(dbPass);
		return source;
	}

	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(dataSource());
	}
}

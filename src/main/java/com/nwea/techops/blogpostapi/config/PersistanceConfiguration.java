package com.nwea.techops.blogpostapi.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.nwea.techops.blogpostapi")
public class PersistanceConfiguration {


	@Bean(name="datasource")
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:sqlite:classpath:blog.db");
		dataSource.setInitialSize(3);
		dataSource.setDriverClassName("org.sqlite.JDBC");
		return dataSource;
	}
	
	@Bean(name="blogspotNamedJdbcTemplate")
	public NamedParameterJdbcTemplate blogspotNamedJdbcTemplate(@Qualifier(value="datasource") DataSource datasource)
	{
		return new NamedParameterJdbcTemplate(datasource);
	}
	
	@Bean(name="blogspotJdbcTemplate")
	public JdbcTemplate blogspotJdbcTemplate(@Qualifier(value="datasource") DataSource datasource)
	{
		return new JdbcTemplate(datasource);
	}

}

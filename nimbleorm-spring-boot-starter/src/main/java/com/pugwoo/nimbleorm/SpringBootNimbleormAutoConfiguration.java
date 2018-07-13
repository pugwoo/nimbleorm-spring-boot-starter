package com.pugwoo.nimbleorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.pugwoo.dbhelper.DBHelper;
import com.pugwoo.dbhelper.impl.SpringJdbcDBHelper;

@Configuration
public class SpringBootNimbleormAutoConfiguration {

	@Bean
	public DBHelper getDBHelper(JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        SpringJdbcDBHelper springJdbcDBHelper = new SpringJdbcDBHelper();
        springJdbcDBHelper.setJdbcTemplate(jdbcTemplate);
        springJdbcDBHelper.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
        springJdbcDBHelper.setTimeoutWarningValve(1000);
        return springJdbcDBHelper;
	}

}

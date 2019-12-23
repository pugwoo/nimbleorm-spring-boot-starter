package com.pugwoo.nimbleorm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.pugwoo.dbhelper.DBHelper;
import com.pugwoo.dbhelper.impl.SpringJdbcDBHelper;

@ConditionalOnClass({DataSource.class, JdbcTemplate.class, NamedParameterJdbcTemplate.class})
@Configuration
@EnableConfigurationProperties(NimbleOrmProperties.class)
public class SpringBootNimbleormAutoConfiguration {
	
	@Autowired
	private NimbleOrmProperties nimbleOrmProperties;

	@ConditionalOnProperty(value = "nimbleorm.isPrimaryBean", havingValue = "false", matchIfMissing = true)
	@Bean
	public DBHelper getDBHelper(JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return _getDBHelper(jdbcTemplate, namedParameterJdbcTemplate);
	}

	@ConditionalOnProperty(value = "nimbleorm.isPrimaryBean", havingValue = "true", matchIfMissing = false)
	@Bean
	@Primary
	public DBHelper getPrimaryDBHelper(JdbcTemplate jdbcTemplate,
									   NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return _getDBHelper(jdbcTemplate, namedParameterJdbcTemplate);
	}

	private DBHelper _getDBHelper(JdbcTemplate jdbcTemplate,
								  NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		SpringJdbcDBHelper springJdbcDBHelper = new SpringJdbcDBHelper();

		if(isNotBlank(nimbleOrmProperties.getTimeoutWarningValve())) {
			try {
				long timeoutWarningValve = Long.parseLong(nimbleOrmProperties.getTimeoutWarningValve().trim());
				if(timeoutWarningValve > 0) {
					springJdbcDBHelper.setTimeoutWarningValve(timeoutWarningValve);
				}
			} catch(Exception e) { // ignore parse
			}
		}

		if(isNotBlank(nimbleOrmProperties.getMaxPageSize())) {
			try {
				int maxPageSize = Integer.parseInt(nimbleOrmProperties.getMaxPageSize().trim());
				if(maxPageSize > 0) {
					springJdbcDBHelper.setMaxPageSize(maxPageSize);
				}
			} catch (Exception e) { // ignore parse
			}
		}

		springJdbcDBHelper.setJdbcTemplate(jdbcTemplate);
		springJdbcDBHelper.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);

		return springJdbcDBHelper;
	}

	private boolean isNotBlank(String str) {
		return str != null && !str.trim().isEmpty();
	}
}

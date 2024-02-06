package com.pugwoo.nimbleorm;

import com.pugwoo.dbhelper.DBHelper;
import com.pugwoo.dbhelper.impl.SpringJdbcDBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@ConditionalOnClass({JdbcTemplate.class})
@Configuration
@EnableConfigurationProperties(NimbleOrmProperties.class)
public class SpringBootNimbleormAutoConfiguration {
	
	@Autowired
	private NimbleOrmProperties nimbleOrmProperties;

	@ConditionalOnProperty(value = "nimbleorm.isPrimaryBean", havingValue = "false", matchIfMissing = true)
	@Bean
	public DBHelper getDBHelper(JdbcTemplate jdbcTemplate) {
		return initDBHelper(jdbcTemplate);
	}

	@ConditionalOnProperty(value = "nimbleorm.isPrimaryBean", havingValue = "true", matchIfMissing = false)
	@Bean
	@Primary
	public DBHelper getPrimaryDBHelper(JdbcTemplate jdbcTemplate) {
		return initDBHelper(jdbcTemplate);
	}

	private DBHelper initDBHelper(JdbcTemplate jdbcTemplate) {
		SpringJdbcDBHelper springJdbcDBHelper = new SpringJdbcDBHelper();

		if(isNotBlank(nimbleOrmProperties.getSlowSqlWarningValve())) {
			try {
				long slowSqlWarningValve = Long.parseLong(nimbleOrmProperties.getSlowSqlWarningValve().trim());
				if(slowSqlWarningValve > 0) {
					springJdbcDBHelper.setSlowSqlWarningValve(slowSqlWarningValve);
				}
			} catch(Exception e) { // ignore parse error, this config item is not important.
			}
		}

		if(isNotBlank(nimbleOrmProperties.getMaxPageSize())) {
			try {
				int maxPageSize = Integer.parseInt(nimbleOrmProperties.getMaxPageSize().trim());
				if(maxPageSize > 0) {
					springJdbcDBHelper.setMaxPageSize(maxPageSize);
				}
			} catch (Exception e) { // ignore parse error, this config item is not important.
			}
		}

		springJdbcDBHelper.setJdbcTemplate(jdbcTemplate);

		return springJdbcDBHelper;
	}

	private boolean isNotBlank(String str) {
		return str != null && !str.trim().isEmpty();
	}
}

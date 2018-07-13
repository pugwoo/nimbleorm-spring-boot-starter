package com.pugwoo.nimbleorm;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nimbleorm")
public class NimbleOrmProperties {

	/**
	 * 对应于DBHelper的setTimeoutWarningValve:
	 * 设置SQL执行超时的WARN log的超时时间，单位毫秒，默认为1000毫秒
	 */
	private String timeoutWarningValve;
	
	/**
	 * 对应于DBHelper的setMaxPageSize:
	 * 设置允许的每页最大的个数，当页数超过允许的最大页数时，设置为最大页数
	 */
	private String maxPageSize;

	public String getTimeoutWarningValve() {
		return timeoutWarningValve;
	}

	public void setTimeoutWarningValve(String timeoutWarningValve) {
		this.timeoutWarningValve = timeoutWarningValve;
	}

	public String getMaxPageSize() {
		return maxPageSize;
	}

	public void setMaxPageSize(String maxPageSize) {
		this.maxPageSize = maxPageSize;
	}
	
}

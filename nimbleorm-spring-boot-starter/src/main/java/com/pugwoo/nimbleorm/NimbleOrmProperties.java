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
	 * 设置允许的每页最大的个数，当每页个数超过该值时，设置为该值。
	 * 默认为不限制。
	 */
	private String maxPageSize;

	/**
	 * 是否设置为primary Bean，默认false；当只有一个DBHelper对象时，不需要设置是否为primary
	 */
	private Boolean isPrimaryBean;

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

	public Boolean getIsPrimaryBean() {
		return isPrimaryBean;
	}

	public void setIsPrimaryBean(Boolean isPrimaryBean) {
		this.isPrimaryBean = isPrimaryBean;
	}
}

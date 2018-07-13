package com.pugwoo.nimbleormspringbootstarterdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pugwoo.dbhelper.DBHelper;

/**
 * 自定义的nimbleorm配置：例如拦截器、慢sql回调等
 */
@Configuration
public class CustomsNimbleOrmConf {
	
	@Autowired
	private DBHelper dbHelper;

	@PostConstruct
	public void conf() {
		System.out.println(dbHelper);
		// 这里可以设置拦截器、慢sql回调
	}
	
}

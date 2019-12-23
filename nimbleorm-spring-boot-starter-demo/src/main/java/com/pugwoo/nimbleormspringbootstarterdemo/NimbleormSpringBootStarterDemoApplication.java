package com.pugwoo.nimbleormspringbootstarterdemo;

import java.util.List;

import com.pugwoo.dbhelper.json.NimbleOrmJSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pugwoo.dbhelper.DBHelper;
import com.pugwoo.nimbleormspringbootstarterdemo.entity.StudentDO;

@SpringBootApplication
public class NimbleormSpringBootStarterDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(NimbleormSpringBootStarterDemoApplication.class, args);
		DBHelper dbHelper = context.getBean(DBHelper.class);
		System.out.println(dbHelper);
		// 拿到dbhelper之后，接下来的用法和操作请详见https://github.com/pugwoo/nimble-orm
		
		// StudentDO的建表语句详见create_table.sql文件，建表之后自行往表里加些数据
		List<StudentDO> students = dbHelper.getAll(StudentDO.class);
		System.out.println("total:" + students.size());
		System.out.println(NimbleOrmJSON.toJson(students));
	}
}

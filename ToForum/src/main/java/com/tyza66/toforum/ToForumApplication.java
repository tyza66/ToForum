package com.tyza66.toforum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tyza66.toforum.mapper")
public class ToForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToForumApplication.class, args);
	}

}

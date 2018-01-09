package com.z4knight.bugmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.z4knight.bugmanagement.dataobject")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

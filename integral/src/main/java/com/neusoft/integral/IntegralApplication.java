package com.neusoft.integral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neusoft.integral")
public class IntegralApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntegralApplication.class, args);
	}
}

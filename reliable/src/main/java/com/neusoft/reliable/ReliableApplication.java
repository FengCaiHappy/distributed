package com.neusoft.reliable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.neusoft.reliable")
public class ReliableApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReliableApplication.class, args);
	}
}

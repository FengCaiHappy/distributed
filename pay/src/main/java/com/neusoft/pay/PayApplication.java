package com.neusoft.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neusoft.integral")
public class PayApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}
}

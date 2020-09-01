package com.jim.redarifno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.jim.redarifno.mapper")
public class RedarifnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedarifnoApplication.class, args);
	}

}

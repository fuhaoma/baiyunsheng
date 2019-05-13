package com.mfh.yueru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YueruApplication {

	public static void main(String[] args) {
		SpringApplication.run(YueruApplication.class, args);
	}

}

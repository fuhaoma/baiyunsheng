package com.mfh.yueru.yueru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mfh.*"})
@EnableScheduling
public class YueruApplication {

	public static void main(String[] args) {
		SpringApplication.run(YueruApplication.class, args);
	}

}

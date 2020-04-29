package ru.learnredis.springredisclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringRedisClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisClientApplication.class, args);
	}

}

package com.naveen.springbootcouchbasekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.naveen" })
public class SpringBootCouchbaseKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCouchbaseKafkaApplication.class, args);
	}

}

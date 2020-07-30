package com.dwarves.todoist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TodoistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoistApplication.class, args);
	}

}

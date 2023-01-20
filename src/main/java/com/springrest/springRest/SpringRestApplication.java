package com.springrest.springRest;

import com.springrest.springRest.services.TableCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

	@Autowired
	TableCreator tableCreator;
	public static void main(String[] args) {

		SpringApplication.run(SpringRestApplication.class, args);
	}
}

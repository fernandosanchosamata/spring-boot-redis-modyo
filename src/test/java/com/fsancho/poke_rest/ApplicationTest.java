package com.fsancho.poke_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fernando Sancho
 *
 */
@Configuration
@SpringBootApplication
@ComponentScan({"com.fsancho.poke_rest"})
public class ApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTest.class, args);
	}
	


}

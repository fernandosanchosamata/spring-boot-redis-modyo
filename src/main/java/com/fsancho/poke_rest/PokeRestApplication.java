package com.fsancho.poke_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Fernando Sancho
 *
 */
@EnableCaching
@SpringBootApplication
public class PokeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeRestApplication.class, args);
	}

}

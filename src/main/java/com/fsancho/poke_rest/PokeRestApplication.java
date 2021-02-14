package com.fsancho.poke_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class PokeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeRestApplication.class, args);
	}
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

}

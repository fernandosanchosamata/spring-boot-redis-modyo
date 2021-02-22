package com.fsancho.poke_rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fernando Sancho
 *
 */
@Configuration
public class GlobalConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

package com.fsancho.poke_rest.config.redis;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fernando Sancho
 *
 */
@Configuration
public class RedisConfig {

	@Bean
	public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
		return clientConfigurationBuilder -> {
			if (clientConfigurationBuilder.build().isUseSsl()) {
				clientConfigurationBuilder.useSsl().disablePeerVerification();
			}
		};
    }

}

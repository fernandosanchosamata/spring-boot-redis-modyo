package com.fsancho.poke_rest.config.redis;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("application.properties")
public class RedisConfig {

	@Bean
	public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
		return clientConfigurationBuilder -> {
			if (clientConfigurationBuilder.build().isUseSsl()) {
				clientConfigurationBuilder.useSsl().disablePeerVerification();
			}
		};
    }

//	@Autowired
//	private Environment env;
//
//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory(){
//		RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
//		redisConf.setHostName(env.getProperty("spring.redis.host"));
//		redisConf.setPort(Integer.parseInt(env.getProperty("spring.redis.port")));
//		redisConf.setPassword(RedisPassword.of(env.getProperty("spring.redis.password")));
//
//		return new LettuceConnectionFactory(redisConf);
//    }

//	@Bean
//	public RedisTemplate<String, Object> deliveryRedisTemplate(RedisConnectionFactory connectionFactory) {
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(connectionFactory);
//		return template;
//	}
}

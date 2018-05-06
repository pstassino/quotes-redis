package com.panos.redis;

import com.panos.redis.model.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableEurekaClient
@SpringBootApplication
public class QuotesRedisApplication {

    	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Quote> redisTemplate() {
		RedisTemplate<String, Quote> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}
        
	public static void main(String[] args) {
		SpringApplication.run(QuotesRedisApplication.class, args);
	}
}

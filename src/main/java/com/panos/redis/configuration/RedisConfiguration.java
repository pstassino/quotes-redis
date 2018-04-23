/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos.redis.configuration;

import com.panos.redis.model.Quote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * @author p.stassinopoulos
 */
@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

    @Bean
    RedisTemplate<String, Quote> redisTemplate() {
            RedisTemplate<String, Quote> redisTemplate = new RedisTemplate<String, Quote>();
            redisTemplate.setConnectionFactory(jedisConnectionFactory());
            return redisTemplate;
    }
   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos.redis.repositories;

import com.panos.redis.model.Quote;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author p.stassinopoulos
 */
@Repository
public class QuoteRepositoryImpl implements QuoteRepository{
    
    private final RedisTemplate<String, Quote> redisTemplate;
    private final HashOperations hashOperations;

    public QuoteRepositoryImpl(RedisTemplate<String, Quote> redisTemplate) {
        this.redisTemplate = redisTemplate;
        
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Quote quote) {
        hashOperations.put("QUOTE", quote.getStock(), quote);
    }

    @Override
    public Map<String, Quote> findAll() {
        return hashOperations.entries("QUOTE");
    }

    @Override
    public Quote findById(String id) {
        return (Quote)hashOperations.get("QUOTE", id);
    }

    @Override
    public void update(Quote quote) {
        save(quote);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("QUOTE", id);
    }
    
}


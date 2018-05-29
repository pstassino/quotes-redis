/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos.redis.repositories;

import com.panos.redis.model.Quote;
import java.util.Map;

/**
 *
 * @author p.stassinopoulos
 */
public interface QuoteRepository {
    
    void save(Quote quote);
    
    Map<String, Quote> findAll();
    
    Quote findById(String stock);
    
    void update(Quote quote);
    
    void delete(String stock);
}

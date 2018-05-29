/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos.redis.controllers;

import com.panos.redis.model.Quote;
import com.panos.redis.repositories.QuoteRepository;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author p.stassinopoulos
 */
@RestController
@RequestMapping("/quotes")
public class QuoteController {
    
    private static final Logger log = LoggerFactory.getLogger(QuoteController.class);
    private final QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }
    
    @GetMapping("/all")
    public Map<String, Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public  Quote getQuote(@PathVariable("id") final String id){
        return quoteRepository.findById(id);
    }
    
    @PostMapping("/add")
    public Quote addQuote(@RequestBody final Quote quote){
        quoteRepository.save(quote);
        return quoteRepository.findById(quote.getStock());
    }
    
    @PostMapping("/update/{id}")
    public Quote updateQuote(
            @RequestBody final Quote quote,
            @PathVariable("id") final String id){
        quoteRepository.update(quote);
        return quoteRepository.findById(id);
    }
    
    @GetMapping("/delete/{id}")
    public Map<String, Quote> deleteQuote(@PathVariable("id") final String id){
        quoteRepository.delete(id);
        return getAllQuotes();
    }
    
}

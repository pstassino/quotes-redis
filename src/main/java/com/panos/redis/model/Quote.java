/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panos.redis.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author p.stassinopoulos
 */
public class Quote implements Serializable {
    
    private String id;
    private BigDecimal price;

    public Quote(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}


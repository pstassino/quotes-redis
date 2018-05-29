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
    
   private String stock;
   private BigDecimal price;
   private BigDecimal change;
   private BigDecimal bid;
   private BigDecimal ask;

   public Quote() {
   }

   public Quote(String stock, BigDecimal price, BigDecimal change, BigDecimal bid, BigDecimal ask) {
       this.stock = stock;
       this.price = price;
       this.change = change;
       this.bid = bid;
       this.ask = ask;
   }

   public BigDecimal getBid() {
       return bid;
   }

   public void setBid(BigDecimal bid) {
       this.bid = bid;
   }

   public BigDecimal getAsk() {
       return ask;
   }

   public void setAsk(BigDecimal ask) {
       this.ask = ask;
   }

   public BigDecimal getChange() {
       return change;
   }

   public void setChange(BigDecimal change) {
       this.change = change;
   }

   public String getStock() {
       return stock;
   }

   public void setStock(String stock) {
       this.stock = stock;
   }

   public BigDecimal getPrice() {
       return price;
   }

   public void setPrice(BigDecimal price) {
       this.price = price;
   }
}

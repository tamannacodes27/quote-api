package com.tamanna.quote_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;
    private String author;

    public Quote() {
    }

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }
    public Long getId(){
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
     public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
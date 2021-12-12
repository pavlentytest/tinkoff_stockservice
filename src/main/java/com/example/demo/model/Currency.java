package com.example.demo.model;

public enum Currency {
    RUB("RUB"),
    EUR("EUR"),
    USD("USD");

    private String currency;
    Currency(String currency) {
        this.currency = currency;
    }
}

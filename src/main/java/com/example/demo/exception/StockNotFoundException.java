package com.example.demo.exception;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String message){
        super(message);
    }
}

package com.example.demo.service;

import com.example.demo.model.Stock;

public interface StockService {
    Stock getStockByTicker(String ticker);
}

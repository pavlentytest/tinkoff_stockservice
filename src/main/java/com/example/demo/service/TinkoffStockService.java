package com.example.demo.service;

import com.example.demo.exception.StockNotFoundException;
import com.example.demo.model.Currency;
import com.example.demo.model.Stock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.invest.openapi.OpenApi;

@Service
@AllArgsConstructor
public class TinkoffStockService implements StockService {
    private final OpenApi openApi;
    @Override
    public Stock getStockByTicker(String ticker) {
        var context = openApi.getMarketContext();
        var listCF = context.searchMarketInstrumentsByTicker(ticker);
        var list = listCF.join().getInstruments();
        if(list.isEmpty()) {
            throw new StockNotFoundException(String.format("Stock %s not found.",ticker));
        }
        var item = list.get(0);

        return new Stock(
            item.getTicker(),
            item.getFigi(),
            item.getName(),
            item.getType().getValue(),
                Currency.valueOf(item.getCurrency().getValue()),
                "TINKOFF"
        );
    }
}

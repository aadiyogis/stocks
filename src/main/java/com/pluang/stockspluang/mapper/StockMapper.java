package com.pluang.stockspluang.mapper;

import com.pluang.stockspluang.dto.StockDetailsRequest;
import com.pluang.stockspluang.model.Stock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class StockMapper {

    public static Stock mapRequestsToStock(StockDetailsRequest stockDetailsRequest) {
        Stock stock = new Stock();

        stock.setOpen(stockDetailsRequest.getOpen());
        stock.setClose(stockDetailsRequest.getClose());
        stock.setHigh(stockDetailsRequest.getHigh());
        stock.setLow(stockDetailsRequest.getLow());
        stock.setVolume(stockDetailsRequest.getVolume());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDate date = LocalDate.parse(stockDetailsRequest.getDate(), dateTimeFormatter);
        stock.setDate(date);

        return stock;
    }
}

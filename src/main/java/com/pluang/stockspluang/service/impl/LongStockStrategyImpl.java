package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.model.Stock;
import com.pluang.stockspluang.service.StockStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.pluang.stockspluang.constants.StockConstants.PRECISION;
import static com.pluang.stockspluang.constants.StockStrategies.LONG;
import static com.pluang.stockspluang.constants.TargetTime.CLOSE;
import static com.pluang.stockspluang.constants.TargetTime.HIGH;

@Slf4j
@Service
public class LongStockStrategyImpl implements StockStrategy {

    @Override
    public StockProfitResponse maxProfit(Stock stock) {
        log.debug("LongStockStrategyImpl --- maxProfit --- started");
        StockProfitResponse stockProfitResponse = new StockProfitResponse();
        double open = stock.getOpen();
        double high = stock.getHigh();
        double close = stock.getClose();

        double openHigh = Math.abs(open - high);
        double openClose = Math.abs(open - close);

        log.debug("open high {}, open close {}", openHigh, openClose);

        stockProfitResponse.setStrategy(LONG.getName());
        if (openHigh > openClose) {
            stockProfitResponse.setProfitPerUnit(Double.parseDouble(String.format(PRECISION, openHigh)));
            stockProfitResponse.setTargetTime(HIGH.getName());
        } else {
            stockProfitResponse.setProfitPerUnit(Double.parseDouble(String.format(PRECISION, openClose)));
            stockProfitResponse.setTargetTime(CLOSE.getName());
        }
        log.debug("LongStockStrategyImpl --- maxProfit --- ended");
        return stockProfitResponse;
    }
}

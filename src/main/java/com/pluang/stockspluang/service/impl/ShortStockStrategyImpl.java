package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.model.Stock;
import com.pluang.stockspluang.service.StockStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.pluang.stockspluang.constants.StockConstants.PRECISION;
import static com.pluang.stockspluang.constants.StockStrategies.SHORT;
import static com.pluang.stockspluang.constants.TargetTime.CLOSE;
import static com.pluang.stockspluang.constants.TargetTime.LOW;

@Slf4j
@Service
public class ShortStockStrategyImpl implements StockStrategy {

    @Override
    public StockProfitResponse maxProfit(Stock stock) {
        log.debug("ShortStockStrategyImpl --- maxProfit --- started");
        StockProfitResponse stockProfitResponse = new StockProfitResponse();
        double open = stock.getOpen();
        double low = stock.getLow();
        double close = stock.getClose();

        double openLow = Math.abs(open - low);
        double closeLow = Math.abs(open - close);

        log.debug("open low value {}, close low value {}", openLow, closeLow);

        stockProfitResponse.setStrategy(SHORT.getName());
        if (openLow > closeLow) {
            stockProfitResponse.setProfitPerUnit(Double.parseDouble(String.format(PRECISION, openLow)));
            stockProfitResponse.setTargetTime(LOW.getName());
        } else {
            stockProfitResponse.setProfitPerUnit(Double.parseDouble(String.format(PRECISION, closeLow)));
            stockProfitResponse.setTargetTime(CLOSE.getName());
        }
        log.debug("ShortStockStrategyImpl --- maxProfit --- ended");
        return stockProfitResponse;
    }
}

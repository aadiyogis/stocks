package com.pluang.stockspluang.service;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.model.Stock;

public interface StockStrategy {
    StockProfitResponse maxProfit(Stock stock);
}

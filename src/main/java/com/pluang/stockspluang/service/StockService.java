package com.pluang.stockspluang.service;

import com.pluang.stockspluang.dto.StockProfitResponse;

public interface StockService {

    StockProfitResponse getProfit(String day);

    StockProfitResponse getProfit(String start, String end);
}

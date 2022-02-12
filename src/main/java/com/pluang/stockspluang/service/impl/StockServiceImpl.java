package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockServiceImpl implements StockService {
    @Override
    public StockProfitResponse getProfit(String day) {
        return null;
    }

    @Override
    public StockProfitResponse getProfit(String start, String end) {
        return null;
    }
}

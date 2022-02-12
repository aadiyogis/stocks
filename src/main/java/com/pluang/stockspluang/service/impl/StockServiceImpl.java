package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.model.Stock;
import com.pluang.stockspluang.repository.StockRepository;
import com.pluang.stockspluang.service.StockService;
import com.pluang.stockspluang.utils.Utility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final ShortStockStrategyImpl shortStockStrategy;
    private final LongStockStrategyImpl longStockStrategy;

    @Override
    public StockProfitResponse getProfit(String day) {
        log.debug("StockServiceImpl --- getProfit --- started");
        LocalDate localDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        log.debug("StockServiceImpl --- getProfit --- input {}", day);
        Optional<Stock> stockOptional = stockRepository.findByDate(localDate);
        StockProfitResponse response = null;
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            log.debug("stock found {}", stock);

            StockProfitResponse shortStockProfitResponse = shortStockStrategy.maxProfit(stock);
            StockProfitResponse longStockProfitResponse = longStockStrategy.maxProfit(stock);

            double shortStockProfit = shortStockProfitResponse.getProfitPerUnit();
            double longStockProfit = longStockProfitResponse.getProfitPerUnit();
            log.debug("profit from short strategy {}, profit from long strategy {}", shortStockProfit, longStockProfit);
            if (shortStockProfit > longStockProfit) {
            //                shortStockProfitResponse.setProfitPerUnit(String.valueOf(Utility.roundOff(shortStockProfit, 3)));
                response = shortStockProfitResponse;
            } else {
                // longStockProfitResponse.setProfitPerUnit(String.valueOf(Utility.roundOff(longStockProfit, 3)));
                response = longStockProfitResponse;
            }
        }
        log.debug("StockServiceImpl --- getProfit --- ended");

        return response;
    }

    @Override
    public StockProfitResponse getProfit(String start, String end) {
        return null;
    }
}

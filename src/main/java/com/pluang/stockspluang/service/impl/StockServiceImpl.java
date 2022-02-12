package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.constants.StockErrorConstants;
import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.exception.StockException;
import com.pluang.stockspluang.model.Stock;
import com.pluang.stockspluang.repository.StockRepository;
import com.pluang.stockspluang.service.StockService;
import com.pluang.stockspluang.service.Validation;
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
    private final Validation validation;

    @Override
    public StockProfitResponse getProfit(String day) {
        log.debug("StockServiceImpl --- getProfit --- started");
        LocalDate localDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        StockProfitResponse response = null;
        if(validation.isValidDate(localDate)) {
            log.debug("StockServiceImpl --- getProfit --- input {}", day);
            Optional<Stock> stockOptional = stockRepository.findByDate(localDate);
            if (stockOptional.isPresent()) {
                Stock stock = stockOptional.get();
                log.debug("stock found {}", stock);

                StockProfitResponse shortStockProfitResponse = shortStockStrategy.maxProfit(stock);
                StockProfitResponse longStockProfitResponse = longStockStrategy.maxProfit(stock);

                double shortStockProfit = shortStockProfitResponse.getProfitPerUnit();
                double longStockProfit = longStockProfitResponse.getProfitPerUnit();
                log.debug("profit from short strategy {}, profit from long strategy {}", shortStockProfit, longStockProfit);
                if (shortStockProfit > longStockProfit) {
                    response = shortStockProfitResponse;
                } else {
                    response = longStockProfitResponse;
                }
            }
        } else {
            StockErrorConstants err01 = StockErrorConstants.ERR01;
            throw new StockException(err01.getErrorCode(), err01.getMessage());
        }
        log.debug("StockServiceImpl --- getProfit --- ended");

        return response;
    }

    @Override
    public StockProfitResponse getProfit(String start, String end) {
        return null;
    }
}

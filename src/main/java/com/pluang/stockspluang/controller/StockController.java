package com.pluang.stockspluang.controller;

import com.pluang.stockspluang.dto.StockProfitResponse;
import com.pluang.stockspluang.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/v1/{current}")
    public ResponseEntity<StockProfitResponse> getProfitForDay(@PathVariable("current") String currentDate) {
        log.debug("StockController --- getProfitForDay --- started");
        ResponseEntity<StockProfitResponse> stockResponse;
        StockProfitResponse profit = stockService.getProfit(currentDate);
        stockResponse = new ResponseEntity<>(profit, HttpStatus.OK);
        log.debug("StockController --- getProfitForDay --- ended");
        return stockResponse;
    }

    @GetMapping("/v2/{start}/{end}")
    public ResponseEntity<StockProfitResponse> getProfitBetweenDay(@PathVariable("start") String startDate,
                                                                   @PathVariable("end") String endDate) {
        log.debug("StockController --- getProfitForDay --- started");
        ResponseEntity<StockProfitResponse> stockResponse;
        StockProfitResponse profit = stockService.getProfit(startDate, endDate);
        stockResponse = new ResponseEntity<>(profit, HttpStatus.OK);
        log.debug("StockController --- getProfitForDay --- ended");
        return stockResponse;
    }


}

package com.pluang.stockspluang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluang.stockspluang.dto.StockDetailsRequest;
import com.pluang.stockspluang.mapper.StockMapper;
import com.pluang.stockspluang.model.Stock;
import com.pluang.stockspluang.repository.StockRepository;
import com.pluang.stockspluang.service.DataLoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataLoaderServiceImpl implements DataLoaderService {
    private final ObjectMapper objectMapper;
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    private final String path = "/data/AAPLbdc2518.json";

    @Override
    public void loadData() {
        TypeReference<List<StockDetailsRequest>> typeReference = new TypeReference<>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream(path);
        try {
            List<StockDetailsRequest> stockDetailsRequests = objectMapper.readValue(inputStream, typeReference);

            List<Stock> stocks = stockDetailsRequests.stream().map(StockMapper::mapRequestsToStock).collect(Collectors.toList());

            stockRepository.saveAllAndFlush(stocks);

            log.debug("loaded stock data");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.debug("error in loading data");
        }
    }
}

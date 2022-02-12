package com.pluang.stockspluang.bootstrap;

import com.pluang.stockspluang.service.DataLoaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockBootStrap implements CommandLineRunner {
    private final DataLoaderService dataLoaderService;

    @Override
    public void run(String... args) throws Exception {
        dataLoaderService.loadData();
    }
}

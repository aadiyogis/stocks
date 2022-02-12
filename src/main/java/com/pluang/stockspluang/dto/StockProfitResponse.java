package com.pluang.stockspluang.dto;

import lombok.Data;

@Data
public class StockProfitResponse {

    private String strategy;
    private String targetTime;
    private String profitPerUnit;

}

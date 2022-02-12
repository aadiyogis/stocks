package com.pluang.stockspluang.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockProfitResponse {

    @JsonProperty("Strategy")
    private String strategy;

    @JsonProperty("TargetTime")
    private String targetTime;

    @JsonProperty("ProfitPerUnit")
    private double profitPerUnit;

}

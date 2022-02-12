package com.pluang.stockspluang.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockProfitResponse {

    @JsonProperty("Strategy")
    private String strategy;

    @JsonProperty("TargetTime")
    private String targetTime;

    @JsonProperty("ProfitPerUnit")
    private double profitPerUnit;

}

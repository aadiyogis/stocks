package com.pluang.stockspluang.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockDetailsRequest {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Open")
    private double open;
    @JsonProperty("Close")
    private double close;
    @JsonProperty("High")
    private double high;
    @JsonProperty("Low")
    private double low;
    @JsonProperty("Volume")
    private long volume;
}

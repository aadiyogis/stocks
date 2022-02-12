package com.pluang.stockspluang.constants;

public enum StockStrategies {
    SHORT("Short"),
    LONG("Long")
    ;
    private final String name;

    StockStrategies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

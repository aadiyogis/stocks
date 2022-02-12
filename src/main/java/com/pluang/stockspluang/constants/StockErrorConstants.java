package com.pluang.stockspluang.constants;

public enum StockErrorConstants {
    ERR01(4001, "Invalid date range")
    ;

    private final int errorCode;
    private final String message;

    StockErrorConstants(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

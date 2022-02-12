package com.pluang.stockspluang.exception;

public class StockException extends RuntimeException {
    private final int errorCode;
    private final String errorMsg;

    public StockException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public StockException(String message, int errorCode, String errorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public StockException(String message, Throwable cause, int errorCode, String errorMsg) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

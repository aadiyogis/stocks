package com.pluang.stockspluang.constants;

public enum TargetTime {
    OPEN("Open"),
    HIGH("High"),
    LOW("Low"),
    CLOSE("Close");

    private final String name;

    TargetTime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

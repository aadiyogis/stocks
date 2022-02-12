package com.pluang.stockspluang.utils;

public class Utility {

    public static double roundOff(double value, int decimalpoint)
    {
        // Using the pow() method
        double rounded = value * Math.pow(10, decimalpoint);
        rounded = Math.floor(rounded);
        rounded = rounded / Math.pow(10, decimalpoint);
        return rounded;
    }
}

package com.pluang.stockspluang.service.impl;

import com.pluang.stockspluang.service.Validation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ValidationImpl implements Validation {

    @Override
    public boolean isValidDate(LocalDate localDate) {
        boolean isDate = false;
        LocalDate startDate = LocalDate.parse("01/01/20", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate endDate = LocalDate.parse("01/01/22", DateTimeFormatter.ofPattern("MM/dd/yy"));
        if (localDate.isAfter(startDate) && localDate.isBefore(endDate)) {
            isDate = true;
        }
        return isDate;
    }
}

package com.pluang.stockspluang.repository;

import com.pluang.stockspluang.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByDate(LocalDate date);
}

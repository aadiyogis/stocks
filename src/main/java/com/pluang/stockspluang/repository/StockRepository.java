package com.pluang.stockspluang.repository;

import com.pluang.stockspluang.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

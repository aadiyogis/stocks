package com.pluang.stockspluang.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STOCK")
@Getter
@Setter
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double open;
    private double close;
    private double high;
    private double low;
    private long volume;

    private LocalDate date;
}

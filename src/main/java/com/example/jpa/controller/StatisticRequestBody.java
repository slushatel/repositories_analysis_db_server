package com.example.jpa.controller;

import lombok.Data;

import java.util.Date;

@Data
public class StatisticRequestBody {
    private String metric;
    private String repository;
    private String technology;
    private Date reportDate;
    private Double value;
}

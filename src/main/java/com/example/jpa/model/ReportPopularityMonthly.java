package com.example.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "popularity_monthly")
@IdClass(ReportPopularityPK.class)
@Data
public class ReportPopularityMonthly {
    @Id
    private String metric;

    @Id
    private String repository;

    @Id
    private String technology;

    @Column(name = "report_date")
    @Id
    private Date reportDate;

    @Column(precision=33, scale=8)
    private BigDecimal value;
}

@Data
class ReportPopularityMonthlyPK implements Serializable {
    private String metric;
    private String repository;
    private String technology;
    private Date reportDate;
}

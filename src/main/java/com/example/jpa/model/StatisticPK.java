package com.example.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StatisticPK implements Serializable {
    private long metric;
    private long repository;
    private long technology;
    private Date reportDate;

    public StatisticPK() {}

    public StatisticPK(long metric, long repository, long technology, Date reportDate) {
        this.metric = metric;
        this.repository = repository;
        this.technology = technology;
        this.reportDate = reportDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticPK statisticPK = (StatisticPK) o;
        return metric == statisticPK.metric &&
                repository == statisticPK.repository &&
                technology == statisticPK.technology &&
                reportDate.equals(statisticPK.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metric, repository, technology, reportDate);
    }

    public long getMetric() {
        return metric;
    }

    public void setMetric(long metric) {
        this.metric = metric;
    }

    public long getRepository() {
        return repository;
    }

    public void setRepository(long repository) {
        this.repository = repository;
    }

    public long getTechnology() {
        return technology;
    }

    public void setTechnology(long technology) {
        this.technology = technology;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}

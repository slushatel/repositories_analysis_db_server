package com.example.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DataPK implements Serializable {
    private long metric;
    private long repository;
    private long language;
    private Date reportDate;

    public DataPK() {}

    public DataPK(long metric, long repository, long language, Date reportDate) {
        this.metric = metric;
        this.repository = repository;
        this.language = language;
        this.reportDate = reportDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataPK dataPK = (DataPK) o;
        return metric == dataPK.metric &&
                repository == dataPK.repository &&
                language == dataPK.language &&
                reportDate.equals(dataPK.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metric, repository, language, reportDate);
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

    public long getLanguage() {
        return language;
    }

    public void setLanguage(long language) {
        this.language = language;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}

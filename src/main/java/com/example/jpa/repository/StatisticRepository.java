package com.example.jpa.repository;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Metric;
import com.example.jpa.model.Statistic;
import com.example.jpa.model.StatisticPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, StatisticPK> {
    List<Statistic> findByMetricAndRepositoryInAndReportDateBetween(Metric metric, CodeRepository repository, Date dateFrom, Date dateTo);
}

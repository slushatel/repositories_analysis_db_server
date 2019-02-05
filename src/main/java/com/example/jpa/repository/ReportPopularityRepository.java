package com.example.jpa.repository;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Metric;
import com.example.jpa.model.ReportPopularity;
import com.example.jpa.model.Statistic;
import com.example.jpa.model.StatisticPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportPopularityRepository extends JpaRepository<ReportPopularity, Long> {
}

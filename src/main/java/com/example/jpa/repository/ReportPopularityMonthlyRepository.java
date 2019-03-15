package com.example.jpa.repository;

import com.example.jpa.model.ReportPopularity;
import com.example.jpa.model.ReportPopularityMonthly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportPopularityMonthlyRepository extends JpaRepository<ReportPopularityMonthly, Long> {
}

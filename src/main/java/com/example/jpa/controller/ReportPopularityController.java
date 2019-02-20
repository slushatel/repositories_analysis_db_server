package com.example.jpa.controller;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Metric;
import com.example.jpa.model.ReportPopularity;
import com.example.jpa.model.Statistic;
import com.example.jpa.model.Technology;
import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.MetricRepository;
import com.example.jpa.repository.ReportPopularityRepository;
import com.example.jpa.repository.StatisticRepository;
import com.example.jpa.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ReportPopularityController {

    @Autowired
    private ReportPopularityRepository reportPopularityRepository;

    @GetMapping("/popularity")
    public @ResponseBody
    List<ReportPopularity> getAllStatistics() {
        return reportPopularityRepository.findAll();
    }
}

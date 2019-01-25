package com.example.jpa.controller;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Metric;
import com.example.jpa.model.Statistic;
import com.example.jpa.model.Technology;
import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.MetricRepository;
import com.example.jpa.repository.StatisticRepository;
import com.example.jpa.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class VocabularyController {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private CodeRepositoryRepository codeRepositoryRepository;

    @Autowired
    private TechnologyRepository technologyRepository;


    @GetMapping("/metrics")
    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    @GetMapping("/technologies")
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    @GetMapping("/repositories")
    public List<CodeRepository> getAllRepositories() {
        return codeRepositoryRepository.findAll();
    }

}

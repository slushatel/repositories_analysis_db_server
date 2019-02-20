package com.example.jpa.controller;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Technology;
import com.example.jpa.model.Metric;
import com.example.jpa.model.Statistic;
import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.StatisticRepository;
import com.example.jpa.repository.TechnologyRepository;
import com.example.jpa.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
public class StatisticController {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private CodeRepositoryRepository codeRepositoryRepository;

    @Autowired
    private TechnologyRepository technologyRepository;


    @GetMapping("/statistics/all")
    public @ResponseBody
    List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    @GetMapping("/statistics")
    public @ResponseBody
    List<Statistic> getStatistics(@RequestParam(value = "metric_id") Long metricId,
                                  @RequestParam("repository_id") Long repositoryId,
                                  @RequestParam("date_from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
                                  @RequestParam("date_to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo) {
//        Metric metric = metricRepository.findById(metricId)
//                .orElseThrow(() -> new RuntimeException("metric is not found by id: " + metricId));
//        CodeRepository repository = codeRepositoryRepository.findById(repositoryId)
//                .orElseThrow(() -> new RuntimeException("repository is not found by id: " + repositoryId));

        Metric metric = new Metric();
        metric.setId(metricId);
        CodeRepository repository = new CodeRepository();
        repository.setId(repositoryId);

        return statisticRepository.findByMetricAndRepositoryInAndReportDateBetween(metric, repository, dateFrom, dateTo);
    }

    @PostMapping("/statistics")
    @Transactional
    public ResponseEntity postStatistic(@Valid @RequestBody List<StatisticRequestBody> statisticRequestBodyList) {
        try {
            statisticRequestBodyList.forEach(this::saveStatistic);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void saveStatistic(StatisticRequestBody statisticRequestBody) {
        Technology technology;
        String technologyName = statisticRequestBody.getTechnology();
        Optional<Technology> optLang = technologyRepository.findByName(technologyName);
        if (optLang.isPresent()) {
            technology = optLang.get();
        } else {
            technology = new Technology();
            technology.setName(technologyName);
            technologyRepository.save(technology);
        }

        CodeRepository codeRepository;
        String repoName = statisticRequestBody.getRepository();
        Optional<CodeRepository> optRepo = codeRepositoryRepository.findByName(repoName);
        if (optRepo.isPresent()) {
            codeRepository = optRepo.get();
        } else {
            codeRepository = new CodeRepository();
            codeRepository.setName(repoName);
            codeRepositoryRepository.save(codeRepository);
        }

        Metric metric;
        String metricName = statisticRequestBody.getMetric();
        Optional<Metric> metricRepo = metricRepository.findByName(metricName);
        if (metricRepo.isPresent()) {
            metric = metricRepo.get();
        } else {
            metric = new Metric();
            metric.setName(metricName);
            metricRepository.save(metric);
        }

        Statistic statistic = new Statistic();
        statistic.setMetric(metric);
        statistic.setRepository(codeRepository);
        statistic.setTechnology(technology);
        statistic.setReportDate(statisticRequestBody.getReportDate());
        statistic.setValue(new BigDecimal(statisticRequestBody.getValue()));

        statisticRepository.save(statistic);
    }
}

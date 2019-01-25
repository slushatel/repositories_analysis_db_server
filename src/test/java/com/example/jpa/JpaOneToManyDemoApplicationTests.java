package com.example.jpa;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Statistic;
import com.example.jpa.model.Technology;
import com.example.jpa.model.Metric;
import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.StatisticRepository;
import com.example.jpa.repository.TechnologyRepository;
import com.example.jpa.repository.MetricRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaOneToManyDemoApplicationTests {

	@Autowired
	private StatisticRepository statisticRepository;

	@Autowired
	private MetricRepository metricRepository;

	@Autowired
	private CodeRepositoryRepository codeRepositoryRepository;

	@Autowired
	private TechnologyRepository technologyRepository;

	@Test
	public void contextLoads() {
		Technology technology;
		String langName = "lang1";
		Optional<Technology> optLang = technologyRepository.findByName(langName);
		if (optLang.isPresent()) {
			technology = optLang.get();
		} else {
			technology = new Technology();
			technology.setName(langName);
			technologyRepository.save(technology);
		}

		CodeRepository codeRepository;
		String repoName = "repo2";
		Optional<CodeRepository> optRepo = codeRepositoryRepository.findByName(repoName);
		if (optRepo.isPresent()) {
			codeRepository = optRepo.get();
		} else {
			codeRepository = new CodeRepository();
			codeRepository.setName(repoName);
			codeRepositoryRepository.save(codeRepository);
		}

		Metric metric;
		String metricName = "metric1";
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
		statistic.setReportDate(new Date());
		statistic.setValue(new BigDecimal(123.45));

		statisticRepository.save(statistic);


	}

}

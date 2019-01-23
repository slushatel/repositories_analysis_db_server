package com.example.jpa;

import com.example.jpa.model.CodeRepository;
import com.example.jpa.model.Data;
import com.example.jpa.model.Language;
import com.example.jpa.model.Metric;
import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.DataRepository;
import com.example.jpa.repository.LanguageRepository;
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
	private DataRepository dataRepository;

	@Autowired
	private MetricRepository metricRepository;

	@Autowired
	private CodeRepositoryRepository codeRepositoryRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Test
	public void contextLoads() {
		Language language;
		String langName = "lang1";
		Optional<Language> optLang = languageRepository.findByName(langName);
		if (optLang.isPresent()) {
			language = optLang.get();
		} else {
			language = new Language();
			language.setName(langName);
			languageRepository.save(language);
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

		Data data = new Data();
		data.setMetric(metric);
		data.setRepository(codeRepository);
		data.setLanguage(language);
		data.setReportDate(new Date());
		data.setValue(new BigDecimal(123.45));

		dataRepository.save(data);


	}

}

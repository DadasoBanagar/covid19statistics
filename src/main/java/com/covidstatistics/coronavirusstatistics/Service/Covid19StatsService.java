package com.covidstatistics.coronavirusstatistics.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covidstatistics.coronavirusstatistics.constant.Covid19RestConstant;
import com.covidstatistics.coronavirusstatistics.entity.Covid19Stats;
import com.covidstatistics.coronavirusstatistics.repo.ICovid19StatsPaginationRepository;
import com.covidstatistics.coronavirusstatistics.repo.ICovid19StatsRepository;

@Service
public class Covid19StatsService implements ICovid19StatsPaginationService{

	@Autowired
	ICovid19StatsRepository covid19StatsRepository;

	@Autowired
	ICovid19StatsPaginationRepository iCovid19StatsPaginationRepository;

	@Autowired
	Covid19Stats covid19Stats;

	static RestTemplate restTemplate = new RestTemplate();

	public ResponseEntity<String> fetchCovid19USAStats() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add(Covid19RestConstant.host, Covid19RestConstant.apiHostValue);
		header.add(Covid19RestConstant.apiKey, Covid19RestConstant.apiKeyValue);
		HttpEntity<String> httpEntity = new HttpEntity<>("parameters", header);

		ResponseEntity<String> response = restTemplate.exchange(Covid19RestConstant.covid19USAUrl, HttpMethod.GET,
				httpEntity, String.class);

		return response;
	}

	public ResponseEntity<String> fetchAllCountryStatsUpdate() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add(Covid19RestConstant.host, Covid19RestConstant.apiHostValue);
		header.add(Covid19RestConstant.apiKey, Covid19RestConstant.apiKeyValue);
		HttpEntity<String> httpEntity = new HttpEntity<>("parameters", header);

		ResponseEntity<String> response = restTemplate.exchange(Covid19RestConstant.covid19AllCountryStatsUrl,
				HttpMethod.GET, httpEntity, String.class);

		return response;
	}

	public String saveCovid19AllCountryStatsUpdate(Covid19Stats covid19Stats) {
		covid19StatsRepository.save(covid19Stats);

		return "Data Inserted successfully!!";

	}

	@Override
	public List<Covid19Stats> findPaginated(int pageNo, int pageSize) {
		Pageable paging=PageRequest.of(pageNo, pageSize);
		Page<Covid19Stats> pageResult=iCovid19StatsPaginationRepository.findAll(paging);
		return pageResult.toList();
	}


}

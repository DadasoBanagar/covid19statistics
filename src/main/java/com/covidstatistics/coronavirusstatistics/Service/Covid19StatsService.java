package com.covidstatistics.coronavirusstatistics.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covidstatistics.coronavirusstatistics.CRUD.Covid19StatsRepository;
import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;
import com.covidstatistics.coronavirusstatistics.constant.Covid19RestConstant;

@Service
public class Covid19StatsService {

	@Autowired
	Covid19StatsRepository covid19StatsRepository;

	@Autowired
	Covid19Stats covid19Stats;

	static RestTemplate restTemplate = new RestTemplate();

	public ResponseEntity<String> fetchCovid19USAStats() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add(Covid19RestConstant.getHost, Covid19RestConstant.getAPIHostValue);
		header.add(Covid19RestConstant.getKey, Covid19RestConstant.getAPIKeyValue);
		HttpEntity<String> httpEntity = new HttpEntity<>("parameters", header);

		ResponseEntity<String> response = restTemplate.exchange(Covid19RestConstant.getCovid19USAUrl, HttpMethod.GET,
				httpEntity, String.class);

		return response;
	}

	public ResponseEntity<String> fetchAllCountryStatsUpdate() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add(Covid19RestConstant.getHost, Covid19RestConstant.getAPIHostValue);
		header.add(Covid19RestConstant.getKey, Covid19RestConstant.getAPIKeyValue);
		HttpEntity<String> httpEntity = new HttpEntity<>("parameters", header);

		ResponseEntity<String> response = restTemplate.exchange(Covid19RestConstant.getCovid19AllCountryStatsUrl,
				HttpMethod.GET, httpEntity, String.class);

		return response;
	}

	public String saveCovid19AllCountryStatsUpdate(Covid19Stats covid19Stats) {
		covid19StatsRepository.save(covid19Stats);

		return "Data Inserted successfully!!";

	}

}

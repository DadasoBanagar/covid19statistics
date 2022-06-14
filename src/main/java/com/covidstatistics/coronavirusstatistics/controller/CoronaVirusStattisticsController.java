package com.covidstatistics.coronavirusstatistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.covidstatistics.coronavirusstatistics.Service.Covid19StatsService;
import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CoronaVirusStattisticsController {

	static RestTemplate restTemplate = new RestTemplate();

	@Autowired
	static Covid19Stats covid19Stats;

	@Autowired
	Covid19StatsService covid19StatsService;

	@GetMapping("/covid19GetUSAUpdate")
	private ResponseEntity<String> fetchCovid19USAStats() {
		ResponseEntity<String> responsedata = covid19StatsService.fetchCovid19USAStats();
		return responsedata;
	}

	@GetMapping("/covid19AllCountrystatsUpdate")
	private ResponseEntity<String> fetchAllCountryStatsUpdate() {
		ResponseEntity<String> responsedata = covid19StatsService.fetchAllCountryStatsUpdate();

		return responsedata;
	}

	@GetMapping("/covid19StatisticsPagination/{pageNo}/{pageSize}")
	private List<Covid19Stats> getCovid19StatsPagination(@PathVariable int pageNo, @PathVariable int pageSize) {
		return covid19StatsService.findPaginated(pageNo, pageSize);

	}

	@PostMapping("/saveCovid19AllCountrystats")
	private String saveAllCountryStatsUpdate(@RequestBody Covid19Stats covid19Stats)
			throws JsonMappingException, JsonProcessingException {

		String responsedata = covid19StatsService.saveCovid19AllCountryStatsUpdate(covid19Stats);

		return responsedata;

	}
}

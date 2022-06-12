package com.covidstatistics.coronavirusstatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	static Covid19StatsService covid19StatsService;

	@GetMapping("/covid19GetUSAUpdate")
	private static ResponseEntity<String> fetchCovid19USAStats() {
		covid19StatsService = new Covid19StatsService();
		ResponseEntity<String> responsedata = covid19StatsService.fetchCovid19USAStats();
		return responsedata;
	}

	@GetMapping("/covid19AllCountrystatsUpdate")
	private static ResponseEntity<String> fetchAllCountryStatsUpdate() {
		covid19StatsService = new Covid19StatsService();
		ResponseEntity<String> responsedata = covid19StatsService.fetchAllCountryStatsUpdate();

		return responsedata;
	}

	@PostMapping("/saveCovid19AllCountrystats")
	private static String saveAllCountryStatsUpdate(@RequestBody Covid19Stats covid19Stats)
			throws JsonMappingException, JsonProcessingException {

		covid19StatsService = new Covid19StatsService();
		String responsedata = covid19StatsService.saveCovid19AllCountryStatsUpdate(covid19Stats);

		return responsedata;

	}
}

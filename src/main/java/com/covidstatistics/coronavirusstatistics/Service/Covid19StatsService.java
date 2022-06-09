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
	
	static RestTemplate restTemplate=new RestTemplate();
	
	public ResponseEntity<String> fetchCovid19USAStats()
	{
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);	
		header.add(Covid19RestConstant.getHost, Covid19RestConstant.getAPIHostValue);
		header.add(Covid19RestConstant.getKey, Covid19RestConstant.getAPIKeyValue);
		HttpEntity<String> httpEntity=new HttpEntity<>("parameters",header);
		
        ResponseEntity<String> response=restTemplate.exchange(Covid19RestConstant.getCovid19USAUrl,HttpMethod.GET,httpEntity,String.class);
		
		return response;
	}
	
	//Below API gives COVID19 the information about all country stats update
	public ResponseEntity<String> fetchAllCountryStatsUpdate()
	{
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);	
		header.add(Covid19RestConstant.getHost, Covid19RestConstant.getAPIHostValue);
		header.add(Covid19RestConstant.getKey, Covid19RestConstant.getAPIKeyValue);
		HttpEntity<String> httpEntity=new HttpEntity<>("parameters",header);
		
        ResponseEntity<String> response=restTemplate.exchange(Covid19RestConstant.getCovid19AllCountryStatsUrl,HttpMethod.GET,httpEntity,String.class);
		
		return response;
	}
	
	//Below API store COVID19 information about all country stats 

	/*public String saveAllCountryStatsUpdate(Covid19Stats covid19Stats) throws JsonMappingException, JsonProcessingException
	{
		
	
	    ObjectMapper objectMapper=new ObjectMapper();
	     
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);	
		header.add(Covid19RestConstant.getHost, Covid19RestConstant.getAPIHostValue);
		header.add(Covid19RestConstant.getKey, Covid19RestConstant.getAPIKeyValue);
		HttpEntity<String> httpEntity=new HttpEntity<>("parameters",header);
		
        ResponseEntity<String> response=restTemplate.exchange(Covid19RestConstant.getCovid19AllCountryStatsUrl,HttpMethod.GET,httpEntity,String.class);
        
		  covid19Stats.setCity("Canada"); 
		  covid19Stats.setProvince("Alberta");
		  covid19Stats.setCountry("Canada");
		  covid19Stats.setLastUpdate(LocalDateTime.now());
		  covid19Stats.setKeyId("Alberta, Canada"); covid19Stats.setConfirmed(583112);
		  covid19Stats.setDeaths(4558); covid19Stats.setRecovered(100);
		  
		  covid19StatsRepository.save(covid19Stats);
		 
        //covid19Stats = objectMapper.readValue(response.getBody(), Covid19Stats.class);
		
		return "Data Inserted successfully!!";
	}*/

	public String saveCovid19AllCountryStatsUpdate(Covid19Stats covid19Stats2) {
		// TODO Auto-generated method stub
		 covid19StatsRepository.save(covid19Stats2);
		 
	        //covid19Stats = objectMapper.readValue(response.getBody(), Covid19Stats.class);
			
			return "Data Inserted successfully!!";	
			
	}

}

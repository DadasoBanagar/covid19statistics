package com.covidstatistics.coronavirusstatistics.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;

@Service
public interface ICovid19StatsPaginationService {

	List<Covid19Stats> findPaginated(int pageNo,int pageSize);	
}

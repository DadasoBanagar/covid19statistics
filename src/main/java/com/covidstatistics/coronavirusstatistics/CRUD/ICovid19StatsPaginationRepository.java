package com.covidstatistics.coronavirusstatistics.CRUD;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;
@Service
public interface ICovid19StatsPaginationRepository extends PagingAndSortingRepository<Covid19Stats, Integer> {

}

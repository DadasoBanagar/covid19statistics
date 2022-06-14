package com.covidstatistics.coronavirusstatistics.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covidstatistics.coronavirusstatistics.entity.Covid19Stats;
@Repository
public interface ICovid19StatsPaginationRepository extends PagingAndSortingRepository<Covid19Stats, Integer> {

}

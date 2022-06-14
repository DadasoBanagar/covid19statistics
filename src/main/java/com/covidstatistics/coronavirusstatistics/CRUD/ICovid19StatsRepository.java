package com.covidstatistics.coronavirusstatistics.CRUD;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;

@Service
public interface ICovid19StatsRepository extends CrudRepository<Covid19Stats, Integer> {

}

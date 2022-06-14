package com.covidstatistics.coronavirusstatistics.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covidstatistics.coronavirusstatistics.entity.Covid19Stats;

@Repository
public interface ICovid19StatsRepository extends CrudRepository<Covid19Stats, Integer> {

}

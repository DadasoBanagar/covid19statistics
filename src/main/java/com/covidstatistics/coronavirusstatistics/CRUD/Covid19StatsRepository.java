package com.covidstatistics.coronavirusstatistics.CRUD;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covidstatistics.coronavirusstatistics.component.Covid19Stats;

@Repository

public interface Covid19StatsRepository extends CrudRepository<Covid19Stats, Integer>{

}

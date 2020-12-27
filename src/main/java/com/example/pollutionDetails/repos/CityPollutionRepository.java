package com.example.pollutionDetails.repos;

import com.example.pollutionDetails.dao.CityPollution;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityPollutionRepository extends CrudRepository<CityPollution, Integer> {


    public List<CityPollution> findByCityName(String cityName);

    public List<CityPollution> findByStateName(String stateName);
}

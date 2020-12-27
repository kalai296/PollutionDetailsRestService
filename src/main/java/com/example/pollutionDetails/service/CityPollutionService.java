package com.example.pollutionDetails.service;

import com.example.pollutionDetails.dao.CityPollution;
import com.example.pollutionDetails.repos.CityPollutionRepository;
import com.example.pollutionDetails.responses.CityPollutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CityPollutionService {

    @Autowired
    CityPollutionRepository cityPollutionRepository;

    public ResponseEntity<CityPollutionResponse> fetchPollutionByCity(String city) {
        List<CityPollution> cityPollutions = new ArrayList<CityPollution>();
        String status = "";
        try {
            cityPollutions = cityPollutionRepository.findByCityName(city);
            if (cityPollutions.size() == 0) {
                status = "No matches found for given city";
            } else {
                status = "Matches found for given city";
            }
            CityPollutionResponse cityPollutionResponse = new CityPollutionResponse("Successfully fetched pollution details by citywise", status, cityPollutions);
            return ResponseEntity.status(HttpStatus.OK).body(cityPollutionResponse);
        } catch(Exception e) {
            CityPollutionResponse cityPollutionResponse = new CityPollutionResponse("Something went wrong", "ERROR", cityPollutions);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(cityPollutionResponse);
        }
    }

    public ResponseEntity<CityPollutionResponse> fetchPollutionByState( String state) {
        List<CityPollution> cityPollutions = new ArrayList<CityPollution>();
        String status = "";
        try {
            cityPollutions = cityPollutionRepository.findByStateName(state);
            if (cityPollutions.size() == 0) {
                status = "No matches found for given state";
            } else {
                status = "Matches found for given state";
            }
            CityPollutionResponse cityPollutionResponse = new CityPollutionResponse("Successfully fetched pollution details by citywise",status, cityPollutions);
            return ResponseEntity.status(HttpStatus.OK).body(cityPollutionResponse);
        } catch (Exception e) {
            CityPollutionResponse cityPollutionResponse = new CityPollutionResponse("Something went wrong", "ERROR", cityPollutions);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(cityPollutionResponse);
        }
    }
}

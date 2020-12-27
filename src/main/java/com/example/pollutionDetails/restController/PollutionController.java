package com.example.pollutionDetails.restController;


import com.example.pollutionDetails.dao.CityPollution;
import com.example.pollutionDetails.repos.CityPollutionRepository;
import com.example.pollutionDetails.responses.CityPollutionResponse;
import com.example.pollutionDetails.responses.UploadResponse;
import com.example.pollutionDetails.service.CityPollutionService;
import com.example.pollutionDetails.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pollution")
public class PollutionController {

    @Autowired
    CityPollutionRepository cityPollutionRepository;
    @Autowired
    UploadService uploadService;
    @Autowired
    CityPollutionService cityPollutionService;


    @RequestMapping(value = "/fileUpload", method= RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<UploadResponse> uploadFile( @RequestParam("file") MultipartFile file) throws IOException {
        cityPollutionRepository.deleteAll();
        return uploadService.uploadFile(file);
    }

    @RequestMapping(value = "/city/{city}", method= RequestMethod.GET)
    public ResponseEntity<CityPollutionResponse> fetchPollutionByCity(@PathVariable String city) {
        return cityPollutionService.fetchPollutionByCity(city);
    }

    @RequestMapping(value = "/state/{state}", method= RequestMethod.GET)
    public ResponseEntity<CityPollutionResponse> fetchPollutionByState(@PathVariable String state) {
        return cityPollutionService.fetchPollutionByState(state);
    }
}

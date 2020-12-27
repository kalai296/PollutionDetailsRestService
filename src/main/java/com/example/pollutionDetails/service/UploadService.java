package com.example.pollutionDetails.service;

import com.example.pollutionDetails.Helper.csvHelper;
import com.example.pollutionDetails.dao.CityPollution;
import com.example.pollutionDetails.repos.CityPollutionRepository;
import com.example.pollutionDetails.responses.UploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
    @Autowired
    CityPollutionRepository cityPollutionRepository;

    public ResponseEntity<UploadResponse> uploadFile(MultipartFile file) {
        String message;
        try {
            cityPollutionRepository.saveAll(csvHelper.read(CityPollution.class, file.getInputStream()));
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new UploadResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            System.out.println("Upload Exception is: " + e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new UploadResponse(message));
        }
    }
}

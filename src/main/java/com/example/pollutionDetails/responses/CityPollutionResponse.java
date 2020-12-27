package com.example.pollutionDetails.responses;

import com.example.pollutionDetails.dao.CityPollution;

import java.util.List;

public class CityPollutionResponse {

    private String message;
    private String status;
    private List<CityPollution> data;

    public CityPollutionResponse(String message, String status, List<CityPollution> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CityPollution> getData() {
        return data;
    }

    public void setData(List<CityPollution> data) {
        this.data = data;
    }
}

package com.example.pollutionDetails.dao;

import javax.persistence.*;

@Entity
@Table(name = "CityPollution")
public class CityPollution {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int countryId;
    private String countryName;
    private int stateId;
    private String stateName;
    private int cityId;
    private String cityName;
    private int cityPollutionPPM;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityPollutionPPM() {
        return cityPollutionPPM;
    }

    public void setCityPollutionPPM(int cityPollutionPPM) {
        this.cityPollutionPPM = cityPollutionPPM;
    }

    @Override
    public String toString() {
        return "CityPollution{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityPollutionPPM=" + cityPollutionPPM +
                '}';
    }
}

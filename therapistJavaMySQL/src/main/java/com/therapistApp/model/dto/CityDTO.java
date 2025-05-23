package com.therapistApp.model.dto;

import java.util.UUID;

public class CityDTO {
    private String cityId;
    private String cityName;
    private String cityZIPCode;

    public CityDTO(String cityName, String cityZIPCode) {
        this.cityName = cityName;
        this.cityZIPCode = cityZIPCode;
    }

    public CityDTO(String cityId, String cityName, String cityZIPCode) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityZIPCode = cityZIPCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityZIPCode() {
        return cityZIPCode;
    }

    public void setCityZIPCode(String cityZIPCode) {
        this.cityZIPCode = cityZIPCode;
    }

}

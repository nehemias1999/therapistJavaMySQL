package com.therapistApp.service;

import com.therapistApp.exception.ValidationException;
import com.therapistApp.model.dao.CityDAO;
import com.therapistApp.model.dao.PatientDAO;
import com.therapistApp.model.dto.CityDTO;
import com.therapistApp.model.dto.PatientDTO;
import com.therapistApp.model.entity.City;
import com.therapistApp.model.entity.Patient;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CityService {
    private CityDAO cityDAO;

    public CityService() {
        this.cityDAO = new CityDAO();
    }

    public List<CityDTO> getAllCities() {
        return cityDAO.getAllCities().stream()
                .map(c -> new CityDTO(
                        c.getCityId().toString(),
                        c.getCityName(),
                        c.getCityZIPCode()
                )).collect(Collectors.toList());
    }

    public void insertCity(CityDTO cityDTO) throws SQLException, ValidationException {

        UUID cityId = UUID.randomUUID();

        String cityName = "";
        if (cityDAO.isCityNameExists(cityDTO.getCityName())) {
            throw new ValidationException("Ya existe una ciudad con nombre " + cityDTO.getCityName());
        } else {
            cityName = cityDTO.getCityName().trim().toLowerCase();
        }

        String cityZIPCode = cityDTO.getCityZIPCode().trim();

        cityDAO.insertCity(new City(
                cityId,
                cityName,
                cityZIPCode
        ));

    }

}

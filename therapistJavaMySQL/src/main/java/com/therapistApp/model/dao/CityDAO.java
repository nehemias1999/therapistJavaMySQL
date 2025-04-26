package com.therapistApp.model.dao;

import com.therapistApp.exception.DataAccessException;
import com.therapistApp.model.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CityDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_ALL_CITY =
            "SELECT * FROM tbl_city ORDER BY city_name";

    private static final String INSERT_CITY =
            "INSERT INTO tbl_city (city_id, city_name, city_zip_code) " +
                    "VALUES (?, ?, ?)";

    public List<City> getAllCities() {
        List<City> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CITY);

            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                City c = new City(

                        UUID.fromString(rs.getString("city_id")),
                        rs.getString("city_name"),
                        rs.getString("city_zip_name")

                );

                list.add(c);
            }

        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
        return list;
    }

    public boolean isCityNameExists(String cityName) {
        String SQL = "SELECT 1 FROM tbl_city WHERE city_name = ? LIMIT 1";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setString(1, cityName);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new DataAccessException("Error comprobando existencia de nombre", e);
        }
    }

    public void insertCity(City city) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_CITY)) {

            ps.setString(1, city.getCityId().toString());

            ps.setString(2, city.getCityName());

            ps.setString(3, city.getCityZIPCode());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}

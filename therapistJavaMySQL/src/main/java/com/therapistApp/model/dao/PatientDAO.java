package com.therapistApp.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.therapistApp.exception.DataAccessException;
import com.therapistApp.model.entity.Patient;

public class PatientDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static final String SELECT_ALL_PATIENT =
            "SELECT * FROM tbl_patient ORDER BY patient_dni";
	
	private static final String SELECT_PATIENT_BY_DNI =
            "SELECT * FROM tbl_patient WHERE patient_dni = ?";

    private static final String INSERT_PATIENT =
            "INSERT INTO tbl_patient (patient_id, patient_dni, patient_name, patient_last_name, patient_birth_date, patient_phone, patient_email, city_id, patient_address, patient_address_number, patient_address_floor, patient_address_department) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        
        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PATIENT);
             
        	ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	
                Patient p = new Patient(

                	UUID.fromString(rs.getString("patient_id")),
                    rs.getString("patient_dni"),
                    rs.getString("patient_name"),
                    rs.getString("patient_last_name"),
                    rs.getDate("patient_birth_date").toLocalDate(),
                    rs.getString("patient_phone"),
                    rs.getString("patient_email"),
                    UUID.fromString(rs.getString("city_id")),
                    rs.getString("patient_address"),
                    rs.getInt("patient_address_number"),
                    rs.getInt("patient_address_floor"),
                    rs.getString("patient_address_department")
                    
                );
                
                list.add(p);
            }
            
        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
        return list;
    }
    
    public Patient getPatientByPatientDNI(String patientDNI) {
    	Patient patient = null;
        
        try (Connection conn = getConnection();
        		PreparedStatement ps = conn.prepareStatement(SELECT_PATIENT_BY_DNI)) {

        		ps.setString(1, patientDNI);
	            try (ResultSet rs = ps.executeQuery()) {
	            	if (rs.next()) {
	
	                    patient = new Patient(

                                UUID.fromString(rs.getString("patient_id")),
                                rs.getString("patient_dni"),
                                rs.getString("patient_name"),
                                rs.getString("patient_last_name"),
                                rs.getDate("patient_birth_date").toLocalDate(),
                                rs.getString("patient_phone"),
                                rs.getString("patient_email"),
                                UUID.fromString(rs.getString("city_id")),
                                rs.getString("patient_address"),
                                rs.getInt("patient_address_number"),
                                rs.getInt("patient_address_floor"),
                                rs.getString("patient_address_department")
		                       
		                   );
		               }
		           }
	       } catch (SQLException e) {
	    	   throw new DataAccessException("No se pudo acceder a la base de datos", e);
	       }
	
	       return patient;
    }
    
    public boolean isPatientDNIExists(String patientDNI) {
        String SQL = "SELECT 1 FROM tbl_patient WHERE patient_dni = ? LIMIT 1";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
        	
            ps.setString(1, patientDNI);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
            
        } catch (SQLException e) {
            throw new DataAccessException("Error comprobando existencia de DNI", e);
        }
    }
    
    public boolean isPatientEmailExists(String patientEmail) {
        String SQL = "SELECT 1 FROM tbl_patient WHERE patient_email = ? LIMIT 1";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {
        	
            ps.setString(1, patientEmail);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
            
        } catch (SQLException e) {
            throw new DataAccessException("Error comprobando existencia de Email", e);
        }
    }

    public void insertPatient(Patient patient) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_PATIENT)) {
        	
        	ps.setString(1, patient.getPatientId().toString());

            ps.setString(2, patient.getPatientDNI());
            
            ps.setString(3, patient.getPatientName());
            
            ps.setString(4, patient.getPatientLastName());
            
            ps.setDate(5, Date.valueOf(patient.getPatientBirthDate()));

            ps.setString(6, patient.getPatientPhone());
            
            ps.setString(7, patient.getPatientEmail());

            ps.setString(8, patient.getCityId().toString());

            ps.setString(9, patient.getPatientAddress());
            
            ps.setInt(10, patient.getPatientAddressNumber());
            
            if (patient.getPatientAddressFloor() >= 0) {
                ps.setInt(11, patient.getPatientAddressFloor());
            } else {
                ps.setNull(11, Types.INTEGER);
            }
            
            if (patient.getPatientAddressApartment() != null) {
            	ps.setString(12, patient.getPatientAddressApartment());
            } else {
            	ps.setNull(12, Types.INTEGER);
            }

            ps.executeUpdate();
            
        } catch (SQLException e) {
        	throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}

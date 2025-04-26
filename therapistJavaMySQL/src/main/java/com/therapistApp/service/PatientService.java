package com.therapistApp.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.exception.ValidationException;
import therapist_desktopJavaApp.model.dao.PatientDAO;
import therapist_desktopJavaApp.model.dto.in.PatientDTOIN;
import therapist_desktopJavaApp.model.entity.Patient;

public class PatientService {
	private PatientDAO patientDAO;
	
    public PatientService() {
		this.patientDAO = new PatientDAO();
	}
    
	public List<PatientDTOIN> getAllPatients() {
        return patientDAO.getAllPatients().stream()
    			.map(p -> new PatientDTOIN(
    					p.getPatientId().toString(), 
    					p.getPatientDNI(), 
    					p.getPatientName(), 
    					p.getPatientLastName(), 
    					p.getPatientBirthDate().toString(), 
    					p.getPatientAddress(), 
    					String.valueOf(p.getPatientAddressNumber()), 
    					String.valueOf(p.getPatientAddressFloor()), 
    					p.getPatientAddressApartment(), 
    					p.getCountryId().toString(), 
    					p.getProvinceId().toString(), 
    					p.getCityId().toString()))
    			.collect(Collectors.toList());
    }

	public void insertPatient(PatientDTOIN patientDTO) throws SQLException, ValidationException {
		
		UUID patientId = UUID.randomUUID();
	
		String patientDNI = "";
		if (patientDAO.isPatientDNIExists(patientDTO.getPatientDTODNI())) {
			throw new ValidationException("Ya existe un paciente con DNI " + patientDTO.getPatientDTODNI());
		} else {
			patientDNI = patientDTO.getPatientDTODNI().toLowerCase();
		}
		
		String patientName = patientDTO.getPatientDTOName().toLowerCase();
		
		String patientLastName = patientDTO.getPatientDTOLastName().toLowerCase();
		
		LocalDate patientBirthDate = null;
		if (LocalDate.parse(patientDTO.getPatientDTOBirthDate()).isAfter(LocalDate.now())) {
            throw new ValidationException("La fecha de nacimiento no puede ser posterior al día de la fecha.");
        } else {
        	patientBirthDate = LocalDate.parse(patientDTO.getPatientDTOBirthDate());
        }
		
		String patientEmail = "";
		if (patientDAO.isPatientEmailExists(patientDTO.getPatientDTOEmail())) {
			throw new ValidationException("Ya existe un paciente con Email " + patientDTO.getPatientDTOEmail());
		} else {
			patientEmail = patientDTO.getPatientDTOEmail().toLowerCase();
		}
		
		String patientAddress = patientDTO.getPatientDTOAddress().toLowerCase();
		
		int patientAddressNumber = Integer.parseInt(patientDTO.getPatientDTOAddressNumber());
		
		int patientAddressFloor; 
		if (!patientDTO.getPatientDTOAddressFloor().isEmpty()) {
			patientAddressFloor = Integer.parseInt(patientDTO.getPatientDTOAddressFloor());
		} else {
			patientAddressFloor = 0;
		}
		
		String patientAddressApartment = patientDTO.getPatientDTOAddressApartment().toLowerCase();
		
		UUID countryId = UUID.fromString(patientDTO.getCountryId());
		
		UUID provinceId = UUID.fromString(patientDTO.getProvinceId());
		
		UUID cityId = UUID.fromString(patientDTO.getCityId());
		
		patientDAO.insertPatient(new Patient(
				patientId, 
				patientDNI, 
				patientName, 
				patientLastName, 
				patientBirthDate, 
				patientEmail, 
				patientAddress, 
				patientAddressNumber, 
				patientAddressFloor, 
				patientAddressApartment, 
				countryId, 
				provinceId, 
				cityId));
		
    }
	
}

package com.therapistApp.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.therapistApp.exception.ValidationException;
import com.therapistApp.model.dao.PatientDAO;
import com.therapistApp.model.dto.PatientDTO;
import com.therapistApp.model.entity.Patient;

public class PatientService {
	private PatientDAO patientDAO;
	
    public PatientService() {
		this.patientDAO = new PatientDAO();
	}
    
	public List<PatientDTO> getAllPatients() {
        return patientDAO.getAllPatients().stream()
    			.map(p -> new PatientDTO(
    					p.getPatientId().toString(), 
    					p.getPatientDNI(), 
    					p.getPatientName(), 
    					p.getPatientLastName(), 
    					p.getPatientBirthDate().toString(),
						p.getPatientPhone(),
						p.getPatientEmail(),
						p.getCityId().toString(),
    					p.getPatientAddress(), 
    					String.valueOf(p.getPatientAddressNumber()), 
    					String.valueOf(p.getPatientAddressFloor()), 
    					p.getPatientAddressApartment()
				)).collect(Collectors.toList());
    }

	public void insertPatient(PatientDTO patientDTO) throws SQLException, ValidationException {
		
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

		String patientPhone = patientDTO.getPatientDTOPhone().toLowerCase();

		String patientEmail = "";
		if (patientDAO.isPatientEmailExists(patientDTO.getPatientDTOEmail())) {
			throw new ValidationException("Ya existe un paciente con Email " + patientDTO.getPatientDTOEmail());
		} else {
			patientEmail = patientDTO.getPatientDTOEmail().toLowerCase();
		}

		UUID cityId = UUID.fromString(patientDTO.getCityId());
		
		String patientAddress = patientDTO.getPatientDTOAddress().toLowerCase();
		
		int patientAddressNumber = Integer.parseInt(patientDTO.getPatientDTOAddressNumber());
		
		int patientAddressFloor; 
		if (!patientDTO.getPatientDTOAddressFloor().isEmpty()) {
			patientAddressFloor = Integer.parseInt(patientDTO.getPatientDTOAddressFloor());
		} else {
			patientAddressFloor = 0;
		}
		
		String patientAddressApartment;
		if (!patientDTO.getPatientDTOAddressApartment().isEmpty()) {
			patientAddressApartment = "";
		} else {
			patientAddressApartment = patientDTO.getPatientDTOAddressApartment().toLowerCase();
		}

		patientDAO.insertPatient(new Patient(
				patientId, 
				patientDNI, 
				patientName, 
				patientLastName, 
				patientBirthDate,
				patientPhone,
				patientEmail,
				cityId,
				patientAddress, 
				patientAddressNumber, 
				patientAddressFloor, 
				patientAddressApartment
		));
		
    }
	
}

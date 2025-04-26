package com.therapistApp.model.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Patient {
	private UUID patientId;
    private String patientDNI;
    private String patientName;
    private String patientLastName;
    private LocalDate patientBirthDate;
    private String patientEmail;
    private String patientAddress;
    private int patientAddressNumber;
    private int patientAddressFloor;
    private String patientAddressApartment;
    private UUID countryId;
    private UUID provinceId;
    private UUID cityId;
    
	public Patient(
			UUID patientId, 
			String patientDNI, 
			String patientName, 
			String patientLastName,
			LocalDate patientBirthDate, 
			String patientEmail, 
			String patientAddress, 
			int patientAddressNumber,
			int patientAddressFloor, 
			String patientAddressApartment, 
			UUID countryId, 
			UUID provinceId, 
			UUID cityId) {
		this.patientId = patientId;
		this.patientDNI = patientDNI;
		this.patientName = patientName;
		this.patientLastName = patientLastName;
		this.patientBirthDate = patientBirthDate;
		this.patientEmail = patientEmail;
		this.patientAddress = patientAddress;
		this.patientAddressNumber = patientAddressNumber;
		this.patientAddressFloor = patientAddressFloor;
		this.patientAddressApartment = patientAddressApartment;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.cityId = cityId;
	}
	
	public UUID getPatientId() {
		return patientId;
	}
	
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientDNI() {
		return patientDNI;
	}
	
	public void setPatientDNI(String patientDNI) {
		this.patientDNI = patientDNI;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientLastName() {
		return patientLastName;
	}
	
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	public LocalDate getPatientBirthDate() {
		return patientBirthDate;
	}
	
	public void setPatientBirthDate(LocalDate patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}
	
	public String getPatientEmail() {
		return patientEmail;
	}
	
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	public String getPatientAddress() {
		return patientAddress;
	}
	
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	public int getPatientAddressNumber() {
		return patientAddressNumber;
	}
	
	public void setPatientAddressNumber(int patientAddressNumber) {
		this.patientAddressNumber = patientAddressNumber;
	}
	
	public int getPatientAddressFloor() {
		return patientAddressFloor;
	}
	
	public void setPatientAddressFloor(int patientAddressFloor) {
		this.patientAddressFloor = patientAddressFloor;
	}
	
	public String getPatientAddressApartment() {
		return patientAddressApartment;
	}
	
	public void setPatientAddressApartment(String patientAddressApartment) {
		this.patientAddressApartment = patientAddressApartment;
	}
	
	public UUID getCountryId() {
		return countryId;
	}
	
	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}
	
	public UUID getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(UUID provinceId) {
		this.provinceId = provinceId;
	}
	
	public UUID getCityId() {
		return cityId;
	}
	
	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}

}

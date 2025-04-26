package com.therapistApp.model.dto;

public class PatientDTOIN {
	private String patientDTODNI;
	private String patientDTOName;
	private String patientDTOLastName;
	private String patientDTOBirthDate;
	private String patientDTOEmail;
	private String patientDTOAddress;
	private String patientDTOAddressNumber;
	private String patientDTOAddressFloor;
	private String patientDTOAddressApartment;
	private String countryId;
	private String provinceId;
	private String cityId;
	
	public PatientDTOIN(
			String patientDTODNI, 
			String patientDTOName, 
			String patientDTOLastName,
			String patientDTOBirthDate, 
			String patientDTOEmail, 
			String patientDTOAddress,
			String patientDTOAddressNumber, 
			String patientDTOAddressFloor, 
			String patientDTOAddressApartment,
			String countryId, 
			String provinceId, 
			String cityId) {
		this.patientDTODNI = patientDTODNI;
		this.patientDTOName = patientDTOName;
		this.patientDTOLastName = patientDTOLastName;
		this.patientDTOBirthDate = patientDTOBirthDate;
		this.patientDTOEmail = patientDTOEmail;
		this.patientDTOAddress = patientDTOAddress;
		this.patientDTOAddressNumber = patientDTOAddressNumber;
		this.patientDTOAddressFloor = patientDTOAddressFloor;
		this.patientDTOAddressApartment = patientDTOAddressApartment;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.cityId = cityId;
	}
	
	public String getPatientDTODNI() {
		return patientDTODNI;
	}
	
	public void setPatientDTODNI(String patientDTODNI) {
		this.patientDTODNI = patientDTODNI;
	}
	
	public String getPatientDTOName() {
		return patientDTOName;
	}
	
	public void setPatientDTOName(String patientDTOName) {
		this.patientDTOName = patientDTOName;
	}
	
	public String getPatientDTOLastName() {
		return patientDTOLastName;
	}
	
	public void setPatientDTOLastName(String patientDTOLastName) {
		this.patientDTOLastName = patientDTOLastName;
	}
	
	public String getPatientDTOBirthDate() {
		return patientDTOBirthDate;
	}
	
	public void setPatientDTOBirthDate(String patientDTOBirthDate) {
		this.patientDTOBirthDate = patientDTOBirthDate;
	}
	
	public String getPatientDTOEmail() {
		return patientDTOEmail;
	}
	
	public void setPatientDTOEmail(String patientDTOEmail) {
		this.patientDTOEmail = patientDTOEmail;
	}
	
	public String getPatientDTOAddress() {
		return patientDTOAddress;
	}
	
	public void setPatientDTOAddress(String patientDTOAddress) {
		this.patientDTOAddress = patientDTOAddress;
	}
	
	public String getPatientDTOAddressNumber() {
		return patientDTOAddressNumber;
	}
	
	public void setPatientDTOAddressNumber(String patientDTOAddressNumber) {
		this.patientDTOAddressNumber = patientDTOAddressNumber;
	}
	
	public String getPatientDTOAddressFloor() {
		return patientDTOAddressFloor;
	}
	
	public void setPatientDTOAddressFloor(String patientDTOAddressFloor) {
		this.patientDTOAddressFloor = patientDTOAddressFloor;
	}
	
	public String getPatientDTOAddressApartment() {
		return patientDTOAddressApartment;
	}
	
	public void setPatientDTOAddressApartment(String patientDTOAddressApartment) {
		this.patientDTOAddressApartment = patientDTOAddressApartment;
	}
	
	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	public String getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getCityId() {
		return cityId;
	}
	
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}

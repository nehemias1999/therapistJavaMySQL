package com.therapistApp.model.dto;

public class ConsultationDTOIN {
	private String consultationId;
    private String patientId;
    private String startDateTime;
    private String endDateTime;
    private String consultationStatus;
    private String ConsultationNotes;
    private String createdAt;
	
    public ConsultationDTOIN(
    		String consultationId, 
    		String patientId, 
    		String startDateTime, 
    		String endDateTime,
			String consultationStatus, 
			String consultationNotes, 
			String createdAt) {
		super();
		this.consultationId = consultationId;
		this.patientId = patientId;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.consultationStatus = consultationStatus;
		ConsultationNotes = consultationNotes;
		this.createdAt = createdAt;
	}
	
	public String getConsultationId() {
		return consultationId;
	}
	
	public void setConsultationId(String consultationId) {
		this.consultationId = consultationId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public String getEndDateTime() {
		return endDateTime;
	}
	
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public String getConsultationStatus() {
		return consultationStatus;
	}
	
	public void setConsultationStatus(String consultationStatus) {
		this.consultationStatus = consultationStatus;
	}
	
	public String getConsultationNotes() {
		return ConsultationNotes;
	}
	
	public void setConsultationNotes(String consultationNotes) {
		ConsultationNotes = consultationNotes;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
    
}

package com.therapistApp.model.dto;

public class PatientNoteDTOIN {
    private String patientNoteId;
    private String patientId;
    private String patientNoteContent;
    private String createdAt;
    private String updatedAt;
	
    public PatientNoteDTOIN(
    		String patientNoteId, 
    		String patientId, 
    		String patientNoteContent, 
    		String createdAt,
			String updatedAt) {
		this.patientNoteId = patientNoteId;
		this.patientId = patientId;
		this.patientNoteContent = patientNoteContent;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public String getPatientNoteId() {
		return patientNoteId;
	}
	
	public void setPatientNoteId(String patientNoteId) {
		this.patientNoteId = patientNoteId;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientNoteContent() {
		return patientNoteContent;
	}
	
	public void setPatientNoteContent(String patientNoteContent) {
		this.patientNoteContent = patientNoteContent;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}

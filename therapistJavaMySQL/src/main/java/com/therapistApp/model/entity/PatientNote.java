package com.therapistApp.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PatientNote {
    private UUID patientNoteId;
    private UUID patientId;
    private String patientNoteContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	
    public PatientNote(
    		UUID patientNoteId, 
    		UUID patientId, 
    		String patientNoteContent, 
    		LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.patientNoteId = patientNoteId;
		this.patientId = patientId;
		this.patientNoteContent = patientNoteContent;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public UUID getPatientNoteId() {
		return patientNoteId;
	}
	
	public void setPatientNoteId(UUID patientNoteId) {
		this.patientNoteId = patientNoteId;
	}
	
	public UUID getPatientId() {
		return patientId;
	}
	
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientNoteContent() {
		return patientNoteContent;
	}
	
	public void setPatientNoteContent(String patientNoteContent) {
		this.patientNoteContent = patientNoteContent;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}

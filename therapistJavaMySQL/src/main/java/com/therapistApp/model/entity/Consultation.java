package com.therapistApp.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Consultation {
	private UUID consultationId;
    private UUID patientId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private ConsultationStatus consultationStatus;
    private String ConsultationNotes;
    private LocalDateTime createdAt;
    
	public Consultation(
			UUID consultationId, 
			UUID patientId, 
			LocalDateTime startDateTime, 
			LocalDateTime endDateTime, 
			ConsultationStatus consultationStatus, 
			String consultationNotes, 
			LocalDateTime createdAt) {
		this.consultationId = consultationId;
		this.patientId = patientId;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.consultationStatus = consultationStatus;
		this.ConsultationNotes = consultationNotes;
		this.createdAt = createdAt;
	}
	
	public UUID getConsultationId() {
		return consultationId;
	}
	
	public void setConsultationId(UUID consultationId) {
		this.consultationId = consultationId;
	}
	
	public UUID getPatientId() {
		return patientId;
	}
	
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public ConsultationStatus getConsultationStatus() {
		return consultationStatus;
	}
	
	public void setConsultationStatus(ConsultationStatus consultationStatus) {
		this.consultationStatus = consultationStatus;
	}
	
	public String getConsultationNotes() {
		return ConsultationNotes;
	}
	
	public void setConsultationNotes(String consultationNotes) {
		ConsultationNotes = consultationNotes;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}

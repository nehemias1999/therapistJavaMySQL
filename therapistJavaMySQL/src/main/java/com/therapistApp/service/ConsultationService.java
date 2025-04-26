package com.therapistApp.service;

import com.therapistApp.exception.ValidationException;
import com.therapistApp.model.dao.ConsultationDAO;
import com.therapistApp.model.dto.ConsultationDTO;
import com.therapistApp.model.entity.Consultation;
import com.therapistApp.model.enumeration.ConsultationStatus;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ConsultationService {
    private ConsultationDAO consultationDAO;

    public ConsultationService() {
        this.consultationDAO = new ConsultationDAO();
    }

    public void insertConsultation(ConsultationDTO consultationDTO) throws SQLException, ValidationException {

        UUID consultationId = UUID.randomUUID();

        UUID patientId = UUID.fromString(consultationDTO.getPatientId());

        LocalDateTime consultationStartDatetime = null;
        if (consultationDAO.isConsultationStartDatetimeExists(LocalDateTime.parse(consultationDTO.getConsultationDTOStartDateTime()))) {
            throw new ValidationException("Ya existe una cita reservada para la fecha " + consultationDTO.getConsultationDTOStartDateTime());
        } else {
            consultationStartDatetime = LocalDateTime.parse(consultationDTO.getConsultationDTOStartDateTime());
        }

        LocalDateTime consultationEndDatetime = LocalDateTime.parse(consultationDTO.getConsultationDTOEndDateTime());

        ConsultationStatus consultationStatus = ConsultationStatus.valueOf(consultationDTO.getConsultationDTOStatus());

        String consultationNotePath = consultationDTO.getConsultationDTONotePath();

        BigDecimal consultationAmount = new BigDecimal(consultationDTO.getConsultationDTOAmount());

        Boolean consultationAmountPaid = Boolean.parseBoolean(consultationDTO.getConsultationDTOAmountPaid());

        consultationDAO.insertConsultation(new Consultation(
                consultationId,
                patientId,
                consultationStartDatetime,
                consultationEndDatetime,
                consultationStatus,
                consultationNotePath,
                consultationAmount,
                consultationAmountPaid
        ));

    }

}

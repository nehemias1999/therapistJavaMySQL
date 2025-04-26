package com.therapistApp.model.dao;

import com.therapistApp.exception.DataAccessException;
import com.therapistApp.model.entity.Consultation;
import com.therapistApp.model.enumeration.ConsultationStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConsultationDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/therapist_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_CONSULTATION_BY_DATE =
            "SELECT * FROM tbl_consultation WHERE DATE(consultation_start_datetime) = ? ORDER BY consultation_start_datetime";

    private static final String SELECT_CONSULTATION_BY_PATIENT_ID =
            "SELECT * FROM tbl_consultation WHERE patient_id = ? ORDER BY consultation_start_datetime";

    private static final String INSERT_CONSULTATION =
            "INSERT INTO tbl_consultation (consultation_id, patient_id, consultation_start_datetime, consultation_end_datetime, consultation_status, consultation_note_path, consultation_amount, consultation_amount_paid) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public List<Consultation> getConsultationByConsultationDate(Date consultationDate) {
        List<Consultation> list = new ArrayList<>();

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CONSULTATION_BY_DATE);

            ResultSet rs = ps.executeQuery(consultationDate.toString())) {
            while (rs.next()) {

                Consultation c = new Consultation(

                    UUID.fromString(rs.getString("consultation_id")),
                    UUID.fromString(rs.getString("patient_id")),
                    rs.getTimestamp("consultation_start_datetime").toLocalDateTime(),
                    rs.getTimestamp("consultation_end_datetime").toLocalDateTime(),
                    ConsultationStatus.valueOf(rs.getString("consultation_status")),
                    rs.getString("consultation_note_path"),
                    rs.getBigDecimal("consultation_amount"),
                    rs.getBoolean("consultation_amount_paid")

                );

                list.add(c);
            }

        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
        return list;
    }

    public List<Consultation> getConsultationByPatientId(UUID patientId) {
        List<Consultation> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_CONSULTATION_BY_PATIENT_ID);

            ResultSet rs = ps.executeQuery(patientId.toString())) {
            while (rs.next()) {

                Consultation c = new Consultation(

                        UUID.fromString(rs.getString("consultation_id")),
                        UUID.fromString(rs.getString("patient_id")),
                        rs.getTimestamp("consultation_start_datetime").toLocalDateTime(),
                        rs.getTimestamp("consultation_end_datetime").toLocalDateTime(),
                        ConsultationStatus.valueOf(rs.getString("consultation_status")),
                        rs.getString("consultation_note_path"),
                        rs.getBigDecimal("consultation_amount"),
                        rs.getBoolean("consultation_amount_paid")

                );

                list.add(c);
            }

        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
        return list;
    }

    public boolean isConsultationStartDatetimeExists(LocalDateTime consultationStartDatetime) {
        String SQL = "SELECT 1 FROM tbl_consultation WHERE consultation_start_datetime = ? LIMIT 1";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setTimestamp(1, Timestamp.valueOf(consultationStartDatetime));

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new DataAccessException("Error comprobando existencia de fecha", e);
        }
    }

    public void insertConsultation(Consultation consultation) throws SQLException {
        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_CONSULTATION)) {

            ps.setString(1, consultation.getConsultationId().toString());

            ps.setString(2, consultation.getPatientId().toString());

            ps.setTimestamp(3, Timestamp.valueOf(consultation.getConsultationStartDateTime()));

            ps.setTimestamp(4, Timestamp.valueOf(consultation.getConsultationEndDateTime()));

            ps.setString(5, consultation.getConsultationStatus().toString());

            ps.setString(6, consultation.getConsultationNotePath());

            ps.setBigDecimal(7, consultation.getConsultationAmount());

            ps.setBoolean(8, consultation.getConsultationAmountPaid());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("No se pudo acceder a la base de datos", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}

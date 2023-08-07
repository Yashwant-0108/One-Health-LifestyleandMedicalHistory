package com.onehealth.lifestyleandhistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onehealth.lifestyleandhistory.entity.MedicalHistory;

/**
 * The `MedicalHistoryRepository` interface extends JpaRepository to provide the necessary
 * methods for performing CRUD (Create, Read, Update, Delete) operations on the
 * MedicalHistory entity. It automatically generates the implementation for the
 * repository, allowing interactions with the database and the MedicalHistory table.
 */
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

    /**
     * Retrieves a list of MedicalHistory records based on the provided patientId and userId.
     *
     * @param patientId The ID of the patient.
     * @param userId The ID of the user.
     * @return A list of MedicalHistory records associated with the specified patient and user.
     */
    List<MedicalHistory> findByPatientIdAndUserId(Long patientId, Long userId);

}

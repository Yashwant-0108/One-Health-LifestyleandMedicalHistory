package com.onehealth.lifestyleandhistory.service;

import java.util.List;

import com.onehealth.lifestyleandhistory.entity.MedicalHistory;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;

/**
 * The `MedicalHistoryService` interface defines the contract for interacting
 * with MedicalHistory-related business logic. It declares methods for
 * performing CRUD (Create, Read, Update, Delete) operations on MedicalHistory entities.
 */
public interface MedicalHistoryService {
    
    /**
     * Retrieves a list of all MedicalHistory records.
     *
     * @return A list of all MedicalHistory records.
     */
    List<MedicalHistory> getAllMedicalHistories();

    /**
     * Retrieves a MedicalHistory record by its unique record ID.
     *
     * @param recordId The unique record ID of the MedicalHistory.
     * @return The MedicalHistory object corresponding to the given record ID.
     * @throws RecordNotFoundException If no MedicalHistory record is found for the given record ID.
     */
    MedicalHistory getMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException;

    /**
     * Creates a new MedicalHistory record.
     *
     * @param medicalHistory The MedicalHistory record to create.
     * @return The created MedicalHistory record.
     */
    MedicalHistory createMedicalHistory(MedicalHistory medicalHistory);

    /**
     * Updates an existing MedicalHistory record.
     *
     * @param recordId The record ID of the MedicalHistory record to update.
     * @param medicalHistory The updated MedicalHistory information.
     * @return The updated MedicalHistory record.
     * @throws RecordNotFoundException If the MedicalHistory record is not found.
     */
    MedicalHistory updateMedicalHistory(Long recordId, MedicalHistory medicalHistory) throws RecordNotFoundException;

    /**
     * Deletes a MedicalHistory record by its record ID.
     *
     * @param recordId The record ID of the MedicalHistory record to delete.
     * @throws RecordNotFoundException If the MedicalHistory record is not found.
     */
    void deleteMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException;

    /**
     * Deletes all MedicalHistory records associated with a specific patient ID and user ID.
     *
     * @param patientId The patient ID.
     * @param userId The user ID.
     * @throws RecordNotFoundException If no MedicalHistory records are found for the given patient and user IDs.
     */
    void deleteMedicalHistoryByPatientIdAndUserId(Long patientId, Long userId) throws RecordNotFoundException;
}

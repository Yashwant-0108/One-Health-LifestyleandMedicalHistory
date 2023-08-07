package com.onehealth.lifestyleandhistory.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onehealth.lifestyleandhistory.entity.MedicalHistory;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;
import com.onehealth.lifestyleandhistory.repository.MedicalHistoryRepository;
import com.onehealth.lifestyleandhistory.service.MedicalHistoryService;

import java.util.List;

/**
 * Implementation of the MedicalHistoryService interface providing operations
 * for managing medical history-related data.
 */
@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    /**
     * Retrieves a list of all MedicalHistory records.
     *
     * @return List of MedicalHistory records.
     */
    @Override
    public List<MedicalHistory> getAllMedicalHistories() {
        return medicalHistoryRepository.findAll();
    }

    /**
     * Retrieves a specific MedicalHistory record by its recordId.
     *
     * @param recordId The unique ID of the MedicalHistory record.
     * @return The retrieved MedicalHistory record.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public MedicalHistory getMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException {
        return medicalHistoryRepository.findById(recordId)
                .orElseThrow(() -> new RecordNotFoundException("Medical history not found with recordId: " + recordId));
    }

    /**
     * Creates a new MedicalHistory record.
     *
     * @param medicalHistory The MedicalHistory object to be created.
     * @return The created MedicalHistory record.
     */
    @Override
    public MedicalHistory createMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    /**
     * Updates an existing MedicalHistory record.
     *
     * @param recordId      The unique ID of the MedicalHistory record to be updated.
     * @param medicalHistory The updated MedicalHistory object.
     * @return The updated MedicalHistory record.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public MedicalHistory updateMedicalHistory(Long recordId, MedicalHistory medicalHistory)
            throws RecordNotFoundException {
        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(recordId)
                .orElseThrow(() -> new RecordNotFoundException("Medical history not found with recordId: " + recordId));

        // Update the properties based on your needs.
        existingMedicalHistory.setAllergies(medicalHistory.getAllergies());
        existingMedicalHistory.setCurrentMedication(medicalHistory.getCurrentMedication());
        existingMedicalHistory.setPastMedication(medicalHistory.getPastMedication());
        existingMedicalHistory.setChronicDiseases(medicalHistory.getChronicDiseases());
        existingMedicalHistory.setInjuries(medicalHistory.getInjuries());
        existingMedicalHistory.setSurgeries(medicalHistory.getSurgeries());

        return medicalHistoryRepository.save(existingMedicalHistory);
    }

    /**
     * Deletes a MedicalHistory record by its recordId.
     *
     * @param recordId The unique ID of the MedicalHistory record to be deleted.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public void deleteMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException {
        if (!medicalHistoryRepository.existsById(recordId)) {
            throw new RecordNotFoundException("MedicalHistory not found with recordId: " + recordId);
        }
        medicalHistoryRepository.deleteById(recordId);
    }

    /**
     * Deletes all MedicalHistory records associated with a specific patientId and userId.
     *
     * @param patientId The unique ID of the patient.
     * @param userId    The unique ID of the user.
     * @throws RecordNotFoundException If no records are found for the given patientId and userId.
     */
    @Override
    public void deleteMedicalHistoryByPatientIdAndUserId(Long patientId, Long userId) throws RecordNotFoundException {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientIdAndUserId(patientId, userId);

        if (medicalHistories.isEmpty()) {
            throw new RecordNotFoundException("MedicalHistory not found with recordId: " + patientId + " " + userId);
        }
        medicalHistoryRepository.deleteAll(medicalHistories);
    }
}

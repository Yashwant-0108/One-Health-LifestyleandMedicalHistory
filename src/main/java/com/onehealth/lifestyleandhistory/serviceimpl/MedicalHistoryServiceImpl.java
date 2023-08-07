package com.onehealth.lifestyleandhistory.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onehealth.lifestyleandhistory.entity.MedicalHistory;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;
import com.onehealth.lifestyleandhistory.repository.MedicalHistoryRepository;
import com.onehealth.lifestyleandhistory.service.MedicalHistoryService;

import java.util.List;

@Service
/**
 * Implementation of the MedicalHistoryService interface providing operations
 * for managing medical history-related data.
 */
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(MedicalHistoryServiceImpl.class);

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistory> getAllMedicalHistories() {
        logger.info("Fetching all MedicalHistory records");

        return medicalHistoryRepository.findAll();
    }

    @Override
    public MedicalHistory getMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException {
        logger.info("Fetching MedicalHistory record by recordId: {}", recordId);

        return medicalHistoryRepository.findById(recordId)
                .orElseThrow(() -> {
                    logger.error("Medical history not found with recordId: {}", recordId);
                    return new RecordNotFoundException("Medical history not found with recordId: " + recordId);
                });
    }

    @Override
    public MedicalHistory createMedicalHistory(MedicalHistory medicalHistory) {
        logger.info("Creating new MedicalHistory record");

        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public MedicalHistory updateMedicalHistory(Long recordId, MedicalHistory medicalHistory)
            throws RecordNotFoundException {
        logger.info("Updating MedicalHistory record with recordId: {}", recordId);

        MedicalHistory existingMedicalHistory = medicalHistoryRepository.findById(recordId)
                .orElseThrow(() -> {
                    logger.error("Medical history not found with recordId: {}", recordId);
                    return new RecordNotFoundException("Medical history not found with recordId: " + recordId);
                });

        // Update the properties based on your needs.
        existingMedicalHistory.setAllergies(medicalHistory.getAllergies());
        existingMedicalHistory.setCurrentMedication(medicalHistory.getCurrentMedication());
        existingMedicalHistory.setPastMedication(medicalHistory.getPastMedication());
        existingMedicalHistory.setChronicDiseases(medicalHistory.getChronicDiseases());
        existingMedicalHistory.setInjuries(medicalHistory.getInjuries());
        existingMedicalHistory.setSurgeries(medicalHistory.getSurgeries());

        return medicalHistoryRepository.save(existingMedicalHistory);
    }

    @Override
    public void deleteMedicalHistoryByRecordId(Long recordId) throws RecordNotFoundException {
        logger.info("Deleting MedicalHistory record by recordId: {}", recordId);

        if (!medicalHistoryRepository.existsById(recordId)) {
            logger.error("MedicalHistory not found with recordId: {}", recordId);
            throw new RecordNotFoundException("MedicalHistory not found with recordId: " + recordId);
        }
        medicalHistoryRepository.deleteById(recordId);
    }

    @Override
    public void deleteMedicalHistoryByPatientIdAndUserId(Long patientId, Long userId) throws RecordNotFoundException {
        logger.info("Deleting all MedicalHistory records associated with patientId: {} and userId: {}", patientId, userId);

        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientIdAndUserId(patientId, userId);

        if (medicalHistories.isEmpty()) {
            logger.error("MedicalHistory not found with patientId: {} and userId: {}", patientId, userId);
            throw new RecordNotFoundException("MedicalHistory not found with recordId: " + patientId + " " + userId);
        }
        medicalHistoryRepository.deleteAll(medicalHistories);
    }
}

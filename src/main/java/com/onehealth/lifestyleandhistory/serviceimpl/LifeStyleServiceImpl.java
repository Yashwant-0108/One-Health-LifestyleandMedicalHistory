package com.onehealth.lifestyleandhistory.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onehealth.lifestyleandhistory.entity.LifeStyle;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;
import com.onehealth.lifestyleandhistory.repository.LifeStyleRepository;
import com.onehealth.lifestyleandhistory.service.LifeStyleService;

/**
 * Implementation of the LifeStyleService interface providing operations
 * for managing lifestyle-related data.
 */
@Service
public class LifeStyleServiceImpl implements LifeStyleService {

    @Autowired
    private LifeStyleRepository lifeStyleRepository;

    /**
     * Retrieves a list of all LifeStyle records.
     *
     * @return List of LifeStyle records.
     */
    @Override
    public List<LifeStyle> getAllLifeStyles() {
        return lifeStyleRepository.findAll();
    }

    /**
     * Retrieves a specific LifeStyle record by its lId.
     *
     * @param lId The unique ID of the LifeStyle record.
     * @return The retrieved LifeStyle record.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public LifeStyle getLifestyleBylId(Long lId) throws RecordNotFoundException {
        return lifeStyleRepository.findById(lId)
                .orElseThrow(() -> new RecordNotFoundException("Lifestyle not found with sNo: " + lId));
    }

    /**
     * Creates a new LifeStyle record.
     *
     * @param lifestyle The LifeStyle object to be created.
     * @return The created LifeStyle record.
     */
    @Override
    public LifeStyle createLifestyle(LifeStyle lifestyle) {
        return lifeStyleRepository.save(lifestyle);
    }

    /**
     * Updates an existing LifeStyle record.
     *
     * @param lId       The unique ID of the LifeStyle record to be updated.
     * @param lifestyle The updated LifeStyle object.
     * @return The updated LifeStyle record.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public LifeStyle updateLifestyle(Long lId, LifeStyle lifestyle) throws RecordNotFoundException {
        LifeStyle existingLifestyle = lifeStyleRepository.findById(lId)
                .orElseThrow(() -> new RecordNotFoundException("Lifestyle not found with sNo: " + lId));

        existingLifestyle.setSmoke(lifestyle.getSmoke());
        existingLifestyle.setAlcohol(lifestyle.getAlcohol());
        existingLifestyle.setExercise(lifestyle.getExercise());
        existingLifestyle.setFoodPreferences(lifestyle.getFoodPreferences());
        existingLifestyle.setOccupation(lifestyle.getOccupation());
        existingLifestyle.setPatientId(lifestyle.getPatientId());
        existingLifestyle.setUserId(lifestyle.getUserId());

        return lifeStyleRepository.save(existingLifestyle);
    }

    /**
     * Deletes a LifeStyle record by its lId.
     *
     * @param lId The unique ID of the LifeStyle record to be deleted.
     * @throws RecordNotFoundException If the record is not found.
     */
    @Override
    public void deleteLifestyle(Long lId) throws RecordNotFoundException {
        if (!lifeStyleRepository.existsById(lId)) {
            throw new RecordNotFoundException("Lifestyle not found with sNo: " + lId);
        }
        lifeStyleRepository.deleteById(lId);
    }
}

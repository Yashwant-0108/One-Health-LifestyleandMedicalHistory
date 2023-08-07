package com.onehealth.lifestyleandhistory.service;

import java.util.List;

import com.onehealth.lifestyleandhistory.entity.LifeStyle;
import com.onehealth.lifestyleandhistory.exception.RecordNotFoundException;

/**
 * The `LifeStyleService` interface defines the contract for interacting with
 * LifeStyle-related business logic. It declares methods for performing CRUD
 * (Create, Read, Update, Delete) operations on LifeStyle entities.
 */
public interface LifeStyleService {
    
    /**
     * Retrieves a list of all LifeStyle records.
     *
     * @return A list of all LifeStyle records.
     */
    List<LifeStyle> getAllLifeStyles();

    /**
     * Retrieves a LifeStyle record by its unique ID.
     *
     * @param lId The unique ID of the LifeStyle.
     * @return The LifeStyle object corresponding to the given ID.
     * @throws RecordNotFoundException If no LifeStyle record is found for the given ID.
     */
    LifeStyle getLifestyleBylId(Long lId) throws RecordNotFoundException;

    /**
     * Creates a new LifeStyle record.
     *
     * @param lifestyle The LifeStyle record to create.
     * @return The created LifeStyle record.
     */
    LifeStyle createLifestyle(LifeStyle lifestyle);

    /**
     * Updates an existing LifeStyle record.
     *
     * @param lId The ID of the LifeStyle record to update.
     * @param lifestyle The updated LifeStyle information.
     * @return The updated LifeStyle record.
     * @throws RecordNotFoundException If the LifeStyle record is not found.
     */
    LifeStyle updateLifestyle(Long lId, LifeStyle lifestyle) throws RecordNotFoundException;

    /**
     * Deletes a LifeStyle record by its ID.
     *
     * @param lId The ID of the LifeStyle record to delete.
     * @throws RecordNotFoundException If the LifeStyle record is not found.
     */
    void deleteLifestyle(Long lId) throws RecordNotFoundException;
}

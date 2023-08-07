package com.onehealth.lifestyleandhistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onehealth.lifestyleandhistory.entity.LifeStyle;

/**
 * The `LifeStyleRepository` interface extends JpaRepository to provide the necessary
 * methods for performing CRUD (Create, Read, Update, Delete) operations on the
 * LifeStyle entity. It automatically generates the implementation for the
 * repository, allowing interactions with the database and the LifeStyle table.
 */
public interface LifeStyleRepository extends JpaRepository<LifeStyle, Long> {

}

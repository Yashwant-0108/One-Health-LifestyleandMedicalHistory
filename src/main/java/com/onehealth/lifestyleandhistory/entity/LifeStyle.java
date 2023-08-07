package com.onehealth.lifestyleandhistory.entity;

import jakarta.persistence.*;

@Entity
/**
 * The `LifeStyle` class represents the lifestyle information of a patient.
 */
public class LifeStyle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lId")
	/** The unique ID of the lifestyle entry. */
	private Long lId;

	@Column(name = "smoke", length = 255, nullable = false)
	/** The smoking habits of the patient. */
	private String smoke;

	@Column(name = "alcohol")
	/** The alcohol consumption habits of the patient. */
	private String alcohol;

	@Column(name = "exercise")
	/** The exercise routine of the patient. */
	private String exercise;

	@Column(name = "food_preferences")
	/** The food preferences of the patient. */
	private String foodPreferences;

	@Column(name = "occupation")
	/** The occupation of the patient. */
	private String occupation;

	@Column(name = "patient_id", nullable = false)
	/** The ID of the patient associated with the lifestyle entry. */
	private Long patientId;

	@Column(name = "user_Id", nullable = false)
	/** The ID of the user associated with the lifestyle entry. */
	private Long userId;

	// Constructors, getters, setters, and other methods as needed.

	/**
	 * Default constructor for the `LifeStyle` class.
	 */
	public LifeStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public LifeStyle(Long lId, String smoke, String alcohol, String exercise, String foodPreferences, String occupation,
			Long patientId, Long userId) {
		super();
		this.lId = lId;
		this.smoke = smoke;
		this.alcohol = alcohol;
		this.exercise = exercise;
		this.foodPreferences = foodPreferences;
		this.occupation = occupation;
		this.patientId = patientId;
		this.userId = userId;
	}

	/**
	 * Getter method for the `lId` field.
	 */
	public Long getlId() {
		return lId;
	}

	/**
	 * Setter method for the `lId` field.
	 */
	public void setlId(Long lId) {
		this.lId = lId;
	}

	/**
	 * Getter method for the `smoke` field.
	 */
	public String getSmoke() {
		return smoke;
	}

	/**
	 * Setter method for the `smoke` field.
	 */
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	/**
	 * Getter method for the `alcohol` field.
	 */
	public String getAlcohol() {
		return alcohol;
	}

	/**
	 * Setter method for the `alcohol` field.
	 */
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	/**
	 * Getter method for the `exercise` field.
	 */
	public String getExercise() {
		return exercise;
	}

	/**
	 * Setter method for the `exercise` field.
	 */
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	/**
	 * Getter method for the `foodPreferences` field.
	 */
	public String getFoodPreferences() {
		return foodPreferences;
	}

	/**
	 * Setter method for the `foodPreferences` field.
	 */
	public void setFoodPreferences(String foodPreferences) {
		this.foodPreferences = foodPreferences;
	}

	/**
	 * Getter method for the `occupation` field.
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Setter method for the `occupation` field.
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Getter method for the `patientId` field.
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * Setter method for the `patientId` field.
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * Getter method for the `userId` field.
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Setter method for the `userId` field.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Overrides the default `toString` method to provide a string representation
	 * of the `LifeStyle` object.
	 */
	@Override
	public String toString() {
		return "LifeStyle [lId=" + lId + ", smoke=" + smoke + ", alcohol=" + alcohol + ", exercise=" + exercise
				+ ", foodPreferences=" + foodPreferences + ", occupation=" + occupation + ", patientId=" + patientId
				+ ", userId=" + userId + "]";
	}

}

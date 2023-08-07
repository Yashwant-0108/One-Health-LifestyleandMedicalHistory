package com.onehealth.lifestyleandhistory.entity;

import jakarta.persistence.*;

@Entity
/**
 * The `MedicalHistory` class represents the medical history records of a patient.
 */
//@Table(name = "pastmedicalrecords")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** The unique ID of the medical history record. */
    private Integer recordId;

    @Column(name = "allergies")
    /** Any allergies the patient has. */
    private String allergies;

    @Column(name = "currentmedication")
    /** Current medications being taken by the patient. */
    private String currentMedication;

    @Column(name = "pastmedication")
    /** Past medications taken by the patient. */
    private String pastMedication;

    @Column(name = "chronicdiseases")
    /** Chronic diseases or conditions the patient has. */
    private String chronicDiseases;

    @Column(name = "injuries")
    /** Previous injuries experienced by the patient. */
    private String injuries;

    @Column(name = "surgeries")
    /** Surgeries undergone by the patient. */
    private String surgeries;

    @Column(name = "patientid", nullable = false)
    /** The ID of the patient associated with the medical history record. */
    private Long patientId;

    @Column(name = "user_id", nullable = false)
    /** The ID of the user associated with the medical history record. */
    private Long userId;

    /**
     * Default constructor for the `MedicalHistory` class.
     */
	public MedicalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MedicalHistory(Integer recordId, String allergies, String currentMedication, String pastMedication,
			String chronicDiseases, String injuries, String surgeries, Long patientId, Long userId) {
		super();
		this.recordId = recordId;
		this.allergies = allergies;
		this.currentMedication = currentMedication;
		this.pastMedication = pastMedication;
		this.chronicDiseases = chronicDiseases;
		this.injuries = injuries;
		this.surgeries = surgeries;
		this.patientId = patientId;
		this.userId = userId;
	}

	/**
	 * Getter method for the `recordId` field.
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * Setter method for the `recordId` field.
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	/**
	 * Getter method for the `allergies` field.
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * Setter method for the `allergies` field.
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	/**
	 * Getter method for the `currentMedication` field.
	 */
	public String getCurrentMedication() {
		return currentMedication;
	}

	/**
	 * Setter method for the `currentMedication` field.
	 */
	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	/**
	 * Getter method for the `pastMedication` field.
	 */
	public String getPastMedication() {
		return pastMedication;
	}

	/**
	 * Setter method for the `pastMedication` field.
	 */
	public void setPastMedication(String pastMedication) {
		this.pastMedication = pastMedication;
	}

	/**
	 * Getter method for the `chronicDiseases` field.
	 */
	public String getChronicDiseases() {
		return chronicDiseases;
	}

	/**
	 * Setter method for the `chronicDiseases` field.
	 */
	public void setChronicDiseases(String chronicDiseases) {
		this.chronicDiseases = chronicDiseases;
	}

	/**
	 * Getter method for the `injuries` field.
	 */
	public String getInjuries() {
		return injuries;
	}

	/**
	 * Setter method for the `injuries` field.
	 */
	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}

	/**
	 * Getter method for the `surgeries` field.
	 */
	public String getSurgeries() {
		return surgeries;
	}

	/**
	 * Setter method for the `surgeries` field.
	 */
	public void setSurgeries(String surgeries) {
		this.surgeries = surgeries;
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

    // Constructors, getters, setters, and other methods as needed.
    
    
}

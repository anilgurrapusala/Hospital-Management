package com.hospital.management.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class DoctorDto {
private Long doctorId;

    

    
    private String name;

    private String specialization;

    private Integer experienceYears;

   
    private Double consultationFee;

    private Boolean available ;

   

    private LocalDateTime createdAt;

   
    private LocalDateTime updatedAt;


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public Integer getExperienceYears() {
		return experienceYears;
	}


	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}


	public Double getConsultationFee() {
		return consultationFee;
	}


	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}


	public Boolean getAvailable() {
		return available;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


    
}

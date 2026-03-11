package com.hospital.management.dtos;

import java.time.LocalDateTime;

public class PatientDto {

	
	 private Long patientId;


	    private String name;

	 
	    private Integer age;

	    
	    private String gender;

	  
	    private String phone;

	    
	    private String diseaseDescription;

	    
	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

		public Long getPatientId() {
			return patientId;
		}

		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getDiseaseDescription() {
			return diseaseDescription;
		}

		public void setDiseaseDescription(String diseaseDescription) {
			this.diseaseDescription = diseaseDescription;
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

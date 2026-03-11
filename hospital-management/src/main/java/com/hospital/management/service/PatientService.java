package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dtos.PatientDto;

public interface PatientService {

	PatientDto addPatient(PatientDto patientDto);

	PatientDto getPatientId(Long patientId);

	List<PatientDto> getAllPAtienst();

	

	PatientDto updatePatient(Long patientId, PatientDto patientDto);

}

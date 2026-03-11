package com.hospital.management.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dtos.PatientDto;
import com.hospital.management.entities.Patient;
import com.hospital.management.repository.PatientRepository;
import com.hospital.management.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private  PatientRepository patientRepository;
	


	@Override
	public PatientDto addPatient(PatientDto patientDto) {
		if(patientDto.getAge()<1 && patientDto.getName().isEmpty()) {
			throw new RuntimeException("age or name bothe some reuireds limit :");
		}
		Patient ptt = dtoToEntity(patientDto);
		Patient saved = patientRepository.save(ptt);
		return entityToDto(saved);
	}

	private static Patient dtoToEntity(PatientDto dto) {
		Patient patient = new Patient();
		patient.setAge(dto.getAge());
		patient.setPatientId(dto.getPatientId());
		patient.setDiseaseDescription(dto.getDiseaseDescription());
		patient.setGender(dto.getGender());
		patient.setName(dto.getName());
		patient.setCreatedAt(dto.getCreatedAt());
		patient.setPhone(dto.getPhone());
		patient.setUpdatedAt(dto.getUpdatedAt());
		return patient;

	}

	private static PatientDto entityToDto(Patient pt) {
		PatientDto dto = new PatientDto();
		dto.setAge(pt.getAge());
		dto.setPatientId(pt.getPatientId());
		dto.setDiseaseDescription(pt.getDiseaseDescription());
		dto.setGender(pt.getGender());
		dto.setName(pt.getName());
		dto.setCreatedAt(pt.getCreatedAt());
		dto.setPhone(pt.getPhone());
		dto.setUpdatedAt(pt.getUpdatedAt());
		return dto;

	}
	private static List<PatientDto> entityListToDtoList(List<Patient> ss) {
		List<PatientDto> allPatientsDto=new ArrayList<>();
		for(Patient ss1:ss) {
			PatientDto dto = new PatientDto();
		dto.setAge(ss1.getAge());
		dto.setDiseaseDescription(ss1.getDiseaseDescription());
		dto.setGender(ss1.getGender());
		dto.setName(ss1.getName());
		dto.setCreatedAt(ss1.getCreatedAt());
		dto.setPhone(ss1.getPhone());
		dto.setUpdatedAt(ss1.getUpdatedAt());
		dto.setPatientId(ss1.getPatientId());
		allPatientsDto.add(dto);
		}
		return allPatientsDto;
	}
	

	@Override
	public PatientDto getPatientId(Long patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new RuntimeException("PatientId is not exist mawa..."));
		return entityToDto(patient);
	}

	@Override
	public List<PatientDto> getAllPAtienst() {
		List<Patient> allPatients=patientRepository.findAll();	
		return entityListToDtoList(allPatients);
	}

	@Override
	public PatientDto updatePatient(Long patientId, PatientDto patientDto) {
		Patient update=patientRepository.findById(patientId).orElseThrow(
			()-> new RuntimeException("Patientid is not exist for update perpose mawa")	);
		Patient savedUpadte=dtoToEntity(patientDto);
		Patient saved=patientRepository.save(savedUpadte);
		return entityToDto(saved);
	}
}

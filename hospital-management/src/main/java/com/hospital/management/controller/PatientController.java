package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dtos.PatientDto;
import com.hospital.management.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add")
	public ResponseEntity<PatientDto> createPatient
	(@RequestBody PatientDto patientDto){
		PatientDto add=patientService.addPatient(patientDto);
		return ResponseEntity.ok(add);
	}
	@GetMapping("/{patientId}")
	public ResponseEntity<PatientDto> byPatient(@PathVariable Long patientId)
	{
		PatientDto byId=patientService.getPatientId(patientId);
		return ResponseEntity.ok(byId);
	}
	@GetMapping("/all")
	public ResponseEntity<List<PatientDto>> allPatients(){
		List<PatientDto> all=patientService.getAllPAtienst();
		return ResponseEntity.ok(all);
	}
	
	@PutMapping("/update/{patientId}")
	public ResponseEntity<PatientDto> updatePatient
	(@PathVariable Long patientId,@RequestBody PatientDto patientDto){
		PatientDto updated=patientService.updatePatient(patientId,patientDto);
		return ResponseEntity.ok(updated);
		
	}
}

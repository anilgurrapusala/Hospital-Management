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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dtos.DoctorDto;
import com.hospital.management.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/add")

	public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
		DoctorDto add = doctorService.addDoctor(doctorDto);
		return ResponseEntity.ok(add);

	}
	@GetMapping("/{doctorId}")
	public ResponseEntity<DoctorDto> doctorId(@PathVariable Long doctorId){
		DoctorDto byId=doctorService.getDoctorId(doctorId);
		return ResponseEntity.ok(byId);
	}

	@GetMapping("/all")
	public ResponseEntity<List<DoctorDto>> allDoctors(){
		List<DoctorDto> allDoctors=doctorService.getAllDoctors();
		return ResponseEntity.ok(allDoctors);
	}
	
	@PutMapping("/update/{doctorId}")
	public ResponseEntity<DoctorDto> update
	(@PathVariable Long doctorId,@RequestBody DoctorDto doctorDto){
		DoctorDto update=doctorService.update(doctorId,doctorDto);
		return ResponseEntity.ok(update);
	}
	
	@GetMapping("/filter-specialization")
	public ResponseEntity<List<DoctorDto>> getSpecialist(@RequestParam String specialist){
		List<DoctorDto> specila=doctorService.getSpecialist(specialist);
		return ResponseEntity.ok(specila);
	}
}

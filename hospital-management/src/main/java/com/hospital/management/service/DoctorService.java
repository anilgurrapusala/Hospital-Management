package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dtos.DoctorDto;

public interface DoctorService {

	DoctorDto addDoctor(DoctorDto doctorDto);

	DoctorDto getDoctorId(Long doctorId);

	List<DoctorDto> getAllDoctors();

	DoctorDto update(Long doctorId, DoctorDto doctorDto);

	List<DoctorDto> getSpecialist(String specialist);

}

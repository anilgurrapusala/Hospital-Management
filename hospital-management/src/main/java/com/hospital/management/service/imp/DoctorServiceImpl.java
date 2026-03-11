package com.hospital.management.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dtos.DoctorDto;
import com.hospital.management.entities.Doctor;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.service.DoctorService;

import jakarta.transaction.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	@Transactional
	public DoctorDto addDoctor(DoctorDto doctorDto) {

		if (doctorDto.getConsultationFee().doubleValue() <= 0) {
			throw new RuntimeException("Consultation fee must be positive");
		}

		// convert to dto to entity
		Doctor dc = dtoToEntity(doctorDto);
		//
		Doctor savedDc = doctorRepository.save(dc);
		// convert entity to dto
		DoctorDto dtos = entityToDto(savedDc);
		// retuen the dto
		return dtos;
	}

	private static Doctor dtoToEntity(DoctorDto dto) {
		Doctor entity = new Doctor();
		entity.setName(dto.getName());
		entity.setAvailable(dto.getAvailable());
		entity.setConsultationFee(dto.getConsultationFee());
		entity.setDoctorId(dto.getDoctorId());
		entity.setExperienceYears(dto.getExperienceYears());
		entity.setCreatedAt(dto.getCreatedAt());
		entity.setUpdatedAt(dto.getUpdatedAt());
		entity.setSpecialization(dto.getSpecialization());
		return entity;

	}

	private static DoctorDto entityToDto(Doctor entity) {
		DoctorDto dto = new DoctorDto();
		dto.setName(entity.getName());
		dto.setAvailable(entity.getAvailable());
		dto.setConsultationFee(entity.getConsultationFee());
		dto.setDoctorId(entity.getDoctorId());
		dto.setExperienceYears(entity.getExperienceYears());
		dto.setSpecialization(entity.getSpecialization());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());

		return dto;

	}

	@Override
	@Transactional
	public DoctorDto getDoctorId(Long doctorId) {
		Doctor byId = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RuntimeException("Doctor Id is Not Exist Mawa..."));
		return entityToDto(byId);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> all = doctorRepository.findAll();
		return entityListToDtoList(all);
	}

	private static List<DoctorDto> entityListToDtoList(List<Doctor> entity) {
		List<DoctorDto> allDtos = new ArrayList<>();
		for (Doctor ss : entity) {
			DoctorDto dto = new DoctorDto();
			dto.setName(ss.getName());
			dto.setAvailable(ss.getAvailable());
			dto.setConsultationFee(ss.getConsultationFee());
			dto.setDoctorId(ss.getDoctorId());
			dto.setExperienceYears(ss.getExperienceYears());
			dto.setCreatedAt(ss.getCreatedAt());
			dto.setUpdatedAt(ss.getUpdatedAt());
			dto.setSpecialization(ss.getSpecialization());
			allDtos.add(dto);
		}
		return allDtos;
	}

	@Override
	public DoctorDto update(Long doctorId, DoctorDto doctorDto) {
		Doctor dc = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RuntimeException("update perpose but doctorId is not existing"));
		Doctor dcUp = dtoToEntity(doctorDto);
		Doctor saveUpdate = doctorRepository.save(dcUp);
		return entityToDto(saveUpdate);
	}

	@Override
	public List<DoctorDto> getSpecialist(String specialist) {
		List<Doctor> allSpecialsit = doctorRepository.findBySpecialization(specialist);

		return entityListToDtoList(allSpecialsit);
	}
}

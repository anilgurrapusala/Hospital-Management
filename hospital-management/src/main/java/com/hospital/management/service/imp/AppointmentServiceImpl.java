package com.hospital.management.service.imp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dtos.AppointmentDto;
import com.hospital.management.entities.Appointment;
import com.hospital.management.entities.AppointmentJoins;
import com.hospital.management.entities.AppointmentJoinsDto;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
		Appointment apm = dtoToEntity(appointmentDto);
		Appointment apms = appointmentRepository.save(apm);
		return entityToDto(apms);
	}

	private static Appointment dtoToEntity(AppointmentDto dto) {
		Appointment ap = new Appointment();
		ap.setAppointmentId(dto.getAppointmentId());
		ap.setAppointmentDate(dto.getAppointmentDate());
		ap.setStatus(dto.getStatus());
		ap.setUpdatedAt(dto.getUpdatedAt());
		ap.setPatientId(dto.getPatientId());
		ap.setDoctorId(dto.getDoctorId());
		ap.setCreatedAt(dto.getCreatedAt());
		return ap;
	}

	private static AppointmentDto entityToDto(Appointment ap) {
		AppointmentDto apd = new AppointmentDto();
		apd.setAppointmentId(ap.getAppointmentId());
		apd.setAppointmentDate(ap.getAppointmentDate());
		apd.setStatus(ap.getStatus());
		apd.setUpdatedAt(ap.getUpdatedAt());
		apd.setPatientId(ap.getPatientId());
		apd.setDoctorId(ap.getDoctorId());
		apd.setCreatedAt(ap.getCreatedAt());
		return apd;
	}

	private static List<AppointmentDto> entityListToDtoList(List<Appointment> ap) {
		List<AppointmentDto> apDtos = new ArrayList<>();
		for (Appointment sss : ap) {
			AppointmentDto apd = new AppointmentDto();
			apd.setAppointmentId(sss.getAppointmentId());
			apd.setAppointmentDate(sss.getAppointmentDate());
			apd.setStatus(sss.getStatus());
			apd.setUpdatedAt(sss.getUpdatedAt());
			apd.setPatientId(sss.getPatientId());
			apd.setDoctorId(sss.getDoctorId());
			apd.setCreatedAt(sss.getCreatedAt());
			apDtos.add(apd);
		}
		return apDtos;
	}

	@Override
	public AppointmentDto geyByAppointment(Long appointmentId) {
		Appointment byIds = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("Appointment id is not exist mawa"));
		return entityToDto(byIds);
	}

	@Override
	public List<AppointmentDto> getAllAppointments() {
		List<Appointment> allAps = appointmentRepository.findAll();
		return entityListToDtoList(allAps);
	}

	@Override
	public AppointmentDto updateApp(Long appointmentId, AppointmentDto appointmentDto) {
		Appointment app = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("AppointmentId is not exist for update appointment perpose"));
		Appointment setUpdate = dtoToEntity(appointmentDto);
		Appointment saveUodate = appointmentRepository.save(setUpdate);
		return entityToDto(saveUodate);
	}

	@Override
	public List<AppointmentDto> allStatus(String status) {
		List<Appointment> allStatus = appointmentRepository.findByStatus(status);
		return entityListToDtoList(allStatus);
	}

	@Override
	public List<AppointmentDto> betweenDatesApp(LocalDateTime start, LocalDateTime end) {
		List<Appointment> allDates = appointmentRepository.findByCreatedAtBetween(start, end);
		return entityListToDtoList(allDates);
	}

	@Override
	public List<Map<Object, Object>> allJoinsFromAppointment(Long appointmentId) {
		List<Map<Object, Object>> allJoinsApById = appointmentRepository.findByJOinsAps(appointmentId);
		return allJoinsApById;

	}

	@Override
	public List<Map<Object, Object>> allJoinsFromAppointmentss() {
		List<Map<Object, Object>> allJoins = appointmentRepository.findByAllJoins();
		return allJoins;
	}

	@Override
	public List<AppointmentJoinsDto> apJoinsSeparate() {
		List<AppointmentJoins> allJoinsSp = appointmentRepository.findByJoinsApsSeparate();
		List<AppointmentJoinsDto> allDtos = new ArrayList<>();
		for (AppointmentJoins sss : allJoinsSp) {
			AppointmentJoinsDto dto = new AppointmentJoinsDto();
			dto.setAppointmentId(sss.getAppointmentId());
			dto.setAppointmentDate(sss.getAppointmentDate());
			dto.setConsultationFee(sss.getConsultationFee());
			dto.setMedicineCost(sss.getMedicineCost());

			dto.setName(sss.getName());
			dto.setStatus(sss.getStatus());
			dto.setSpecialization(sss.getSpecialization());
			dto.setPhone(sss.getPhone());
			dto.setPaymentStatus(sss.getPaymentStatus());
			allDtos.add(dto);
		}

		return allDtos;
	}

}

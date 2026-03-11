package com.hospital.management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.hospital.management.dtos.AppointmentDto;
import com.hospital.management.entities.AppointmentJoinsDto;

public interface AppointmentService {

	AppointmentDto addAppointment(AppointmentDto appointmentDto);

	AppointmentDto geyByAppointment(Long appointmentId);

	List<AppointmentDto> getAllAppointments();

	AppointmentDto updateApp(Long appointmentId, AppointmentDto appointmentDto);

	List<AppointmentDto> allStatus(String status);

	List<AppointmentDto> betweenDatesApp(LocalDateTime start, LocalDateTime end);


	List<Map<Object, Object>> allJoinsFromAppointment(Long appointmentId);

	List<Map<Object, Object>> allJoinsFromAppointmentss();

	List<AppointmentJoinsDto> apJoinsSeparate();

}

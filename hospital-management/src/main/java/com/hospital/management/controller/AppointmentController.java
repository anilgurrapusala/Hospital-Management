package com.hospital.management.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

import com.hospital.management.dtos.AppointmentDto;
import com.hospital.management.entities.AppointmentJoinsDto;
import com.hospital.management.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/add")
	public ResponseEntity<AppointmentDto> createAppointment
	(@RequestBody AppointmentDto appointmentDto){
		AppointmentDto add=appointmentService.addAppointment(appointmentDto);
		return ResponseEntity.ok(add);
	}

	@GetMapping("/{appointmentId}")
	public ResponseEntity<AppointmentDto> byAppointment
	(@PathVariable Long appointmentId){
		AppointmentDto byId=appointmentService.geyByAppointment(appointmentId);
		return ResponseEntity.ok(byId);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AppointmentDto>> allAppointments(){
		List<AppointmentDto> all=appointmentService.getAllAppointments();
		return ResponseEntity.ok(all);
	}
	
	@PutMapping("/update/{appointmentId}")
	public ResponseEntity<AppointmentDto> updateApp
	(@PathVariable Long appointmentId,@RequestBody AppointmentDto appointmentDto){
		AppointmentDto update=appointmentService.updateApp(appointmentId,appointmentDto);
		return ResponseEntity.ok(update);
	}
	@GetMapping("/appointment-status")
	public ResponseEntity<List<AppointmentDto>> status(@RequestParam String status){
		List<AppointmentDto> allStatus=appointmentService.allStatus(status);
		return ResponseEntity.ok(allStatus);
		
	}
	@GetMapping("/dates-beetween")
	public ResponseEntity<List<AppointmentDto>> betweenDates
	(@RequestParam LocalDateTime start,@RequestParam LocalDateTime end){
		List<AppointmentDto> dates=appointmentService.betweenDatesApp(start,end);
		return ResponseEntity.ok(dates);
		
}
	// here if using list it comes error listOfMap u can it will be solved mawa by id mawa
  @GetMapping("/joins from -appointment") public
  ResponseEntity<List<Map<Object, Object>>> allJoinsFromAppointment
  (@RequestParam Long appointmentId){ List<Map<Object, Object>>
 allJoinsAp=appointmentService.allJoinsFromAppointment(appointmentId); 
  return ResponseEntity.ok(allJoinsAp);
  }
  
// here if using list it comes error listOfMap u can it will be solved mawa
  @GetMapping("/joins-from-all-appointments") public
  ResponseEntity<List<Map<Object,Object>>> allJoinsFromAppointmentss()
  { 
	  List<Map<Object,Object>> allJoinsAps=appointmentService.allJoinsFromAppointmentss(); 
  return ResponseEntity.ok(allJoinsAps);
  }

  @GetMapping("/joins-seperate-class")
  public ResponseEntity<List<AppointmentJoinsDto>> apJoinsSeparate(){
	  List<AppointmentJoinsDto> apJoins=appointmentService.apJoinsSeparate(); 
	  return ResponseEntity.ok(apJoins);
  }
  
}

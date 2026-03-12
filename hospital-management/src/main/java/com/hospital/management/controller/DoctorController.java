package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dtos.DoctorDto;
import com.hospital.management.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/doctor")
@Tag(name = "Doctor API", description = "Operations related to Doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    @Operation(summary = "Add new doctor", description = "Creates a new doctor record in the system")
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto add = doctorService.addDoctor(doctorDto);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/{doctorId}")
    @Operation(summary = "Get doctor by ID", description = "Fetch doctor details using doctor ID")
    public ResponseEntity<DoctorDto> doctorId(
            @Parameter(description = "Doctor ID", example = "1")
            @PathVariable Long doctorId) {

        DoctorDto byId = doctorService.getDoctorId(doctorId);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all doctors", description = "Returns list of all doctors")
    public ResponseEntity<List<DoctorDto>> allDoctors() {
        List<DoctorDto> allDoctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(allDoctors);
    }

    @PutMapping("/update/{doctorId}")
    @Operation(summary = "Update doctor", description = "Update doctor details using doctor ID")
    public ResponseEntity<DoctorDto> update(
            @Parameter(description = "Doctor ID", example = "1")
            @PathVariable Long doctorId,

            @RequestBody DoctorDto doctorDto) {

        DoctorDto update = doctorService.update(doctorId, doctorDto);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/filter-specialization")
    @Operation(summary = "Filter doctors by specialization", description = "Returns doctors based on specialization")
    public ResponseEntity<List<DoctorDto>> getSpecialist(
            @Parameter(description = "Doctor specialization", example = "Cardiologist")
            @RequestParam String specialist) {

        List<DoctorDto> specila = doctorService.getSpecialist(specialist);
        return ResponseEntity.ok(specila);
    }
}
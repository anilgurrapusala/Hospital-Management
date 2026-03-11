package com.hospital.management.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AppointmentJoins {

	@Id
	@Column(name="appointment_id")
	private Long appointmentId;
	
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	private String status;
	
	private String specialization;
	
	
	@Column(name="consultation_fee ")
	private Double consultationFee;
	
	@Column(name="medicine_cost")
	private Double medicineCost;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	
	
	@Column(name="payment_status")
	private String paymentStatus;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Double getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(Double medicineCost) {
		this.medicineCost = medicineCost;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
	
	
}

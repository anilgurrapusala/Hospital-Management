package com.hospital.management.dtos;

import java.time.LocalDateTime;

public class BillingDto {

	
	
	 private Long  appointmentId;
	
	private Long billingId;

    private Double consultationFee;

    private Double medicineCost;


    private Double totalAmount;

   
    private String paymentStatus;

    private LocalDateTime createdAt;

  
    private LocalDateTime updatedAt;


	public Long getBillingId() {
		return billingId;
	}


	public void setBillingId(Long billingId) {
		this.billingId = billingId;
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


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public Long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}

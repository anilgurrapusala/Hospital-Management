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

import com.hospital.management.dtos.BillingDto;
import com.hospital.management.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@PostMapping("/add")
	public ResponseEntity<BillingDto> addBilling(@RequestBody BillingDto billingDto){
		BillingDto add=billingService.addBilling(billingDto);
		return ResponseEntity.ok(add);
		
	}
	@GetMapping("/{billingId}")
	public ResponseEntity<BillingDto> byBilling(@PathVariable Long billingId){
		BillingDto byId=billingService.getByBillingId(billingId);
		return ResponseEntity.ok(byId);
	
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BillingDto>> allBillings(){
		List<BillingDto> all=billingService.getAllBillings();
		return ResponseEntity.ok(all);
	}
	
	@PutMapping("/update/{billingId}")
	public ResponseEntity<BillingDto> 
	updateBilling(@RequestBody BillingDto billingDto,@PathVariable Long billingId){
		BillingDto updateBillings=billingService.UpdateBilling(billingDto,billingId);
		return ResponseEntity.ok(updateBillings);
		
	}
}

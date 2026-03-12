package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dtos.BillingDto;

public interface BillingService {

	BillingDto addBilling(BillingDto billingDto);

	BillingDto getByBillingId(Long billingId);

	List<BillingDto> getAllBillings();

	BillingDto UpdateBilling(BillingDto billingDto, Long billingId);

	List<BillingDto> getAllbillingsfee();

}

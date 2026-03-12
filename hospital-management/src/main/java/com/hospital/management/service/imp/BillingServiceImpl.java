package com.hospital.management.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dtos.BillingDto;
import com.hospital.management.entities.Billing;
import com.hospital.management.repository.BillingRepository;
import com.hospital.management.service.BillingService;
@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepository;
	
	@Override
	public BillingDto addBilling(BillingDto billingDto) {
		Billing b1=dtoToEntity(billingDto);
		b1.setTotalAmount(b1.getConsultationFee()+b1.getMedicineCost());
		Billing b2=billingRepository.save(b1);
		return entityToDto(b2);
	}
	private static Billing dtoToEntity(BillingDto bb) {
		Billing billing=new Billing();
		billing.setBillingId(bb.getBillingId());
		billing.setAppointmentId(bb.getAppointmentId());
		billing.setConsultationFee(bb.getConsultationFee());
		billing.setCreatedAt(bb.getCreatedAt());
		billing.setMedicineCost(bb.getMedicineCost());
		billing.setTotalAmount(bb.getTotalAmount());
		billing.setPaymentStatus(bb.getPaymentStatus());
		billing.setUpdatedAt(bb.getUpdatedAt());
		return billing;
	}

	private static BillingDto entityToDto(Billing bb) {
		BillingDto billing=new BillingDto();
		billing.setBillingId(bb.getBillingId());
		billing.setAppointmentId(bb.getAppointmentId());
		billing.setConsultationFee(bb.getConsultationFee());
		billing.setCreatedAt(bb.getCreatedAt());
		billing.setMedicineCost(bb.getMedicineCost());
		billing.setTotalAmount(bb.getTotalAmount());
		billing.setPaymentStatus(bb.getPaymentStatus());
		billing.setUpdatedAt(bb.getUpdatedAt());
		return billing;
	}
	private static List<BillingDto> entityListToDtoList(List<Billing> ss) {
		List<BillingDto> allBillingDtos=new ArrayList<>();
		for(Billing sss:ss) {
			
			BillingDto billing=new BillingDto();
			billing.setBillingId(sss.getBillingId());
			billing.setAppointmentId(sss.getAppointmentId());
			billing.setConsultationFee(sss.getConsultationFee());
			billing.setCreatedAt(sss.getCreatedAt());
			billing.setMedicineCost(sss.getMedicineCost());
			billing.setTotalAmount(sss.getTotalAmount());
			billing.setPaymentStatus(sss.getPaymentStatus());
			billing.setUpdatedAt(sss.getUpdatedAt());
			allBillingDtos.add(billing);
		
		}
		return 	allBillingDtos;	
		
	}
	@Override
	public BillingDto getByBillingId(Long billingId) {
		Billing byIds=	billingRepository.findById(billingId)
				.orElseThrow(() -> new RuntimeException("Billing Id is not exist mawa.."));
		return entityToDto(byIds);
	}
	@Override
	public List<BillingDto> getAllBillings() {
		List<Billing> allEntities=billingRepository.findAll();
		return entityListToDtoList(allEntities);
	}
	@Override
	public BillingDto UpdateBilling(BillingDto billingDto, Long billingId) {
		Billing bbId=billingRepository.findById(billingId).orElseThrow(
		() -> new RuntimeException
		("billingId is not existing for update billing perpose mawa "));
		//not setTotal to id mawa 
		//bbId.setTotalAmount(billingDto.getConsultationFee()+billingDto.getMedicineCost());
		Billing setUpadtes=dtoToEntity(billingDto);
		// after get the dto reference that time only setTotal Amount to save entity
		setUpadtes.setTotalAmount(billingDto.getConsultationFee()+billingDto.getMedicineCost());
		Billing saveUpdates=billingRepository.save(setUpadtes);
		return entityToDto(bbId);
	}
	@Override
	public List<BillingDto> getAllbillingsfee() {
		List<Billing> allFees	=billingRepository.findConsutanceFee();
		return entityListToDtoList(allFees);
	}
}

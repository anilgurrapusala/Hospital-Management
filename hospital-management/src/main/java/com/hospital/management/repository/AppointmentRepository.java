package com.hospital.management.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.management.entities.Appointment;
import com.hospital.management.entities.AppointmentJoins;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByStatus(String status);

	List<Appointment> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

	@Query(value = "select  ap.appointment_id as appointmentId ,appointment_date  as appointmentDate, status ,d.name ,d.specialization,d.consultation_fee as consultationFee , p.name,p.phone\r\n"
			+ "from Appointment as ap\r\n" + "left join doctor as d\r\n" + "on\r\n" + "ap.doctor_id=d.doctor_id \r\n"
			+ "left join patient as p\r\n" + "on \r\n"
			+ "ap.patient_id=p.patient_id where ap.appointment_id=?1", nativeQuery = true)
	List<Map<Object, Object>> findByJOinsAps(Long appointmentId);

	@Query(value = "select  ap.appointment_id as appointmentId ,appointment_date  as appointmentDate, status ,d.name ,d.specialization,d.consultation_fee as consultationFee , p.name,p.phone\r\n"
			+ "from Appointment as ap\r\n" + "left join doctor as d\r\n" + "on\r\n" + "ap.doctor_id=d.doctor_id \r\n"
			+ "left join patient as p\r\n" + "on \r\n" + "ap.patient_id=p.patient_id ", nativeQuery = true)
	List<Map<Object,Object>> findByAllJoins();

	@Query(value=" select  ap.appointment_id  ,\r\n"
			+ "    appointment_date ,\r\n"
			+ "  status ,d.specialization, p.name,p.phone ,\r\n"
			+ "  b.consultation_fee ,b.medicine_cost ,b.total_amount ,b.payment_status \r\n"
			+ "  from Appointment as ap\r\n"
			+ "left join doctor as d\r\n"
			+ "on\r\n"
			+ "ap.doctor_id=d.doctor_id \r\n"
			+ "left join patient as p\r\n"
			+ "on \r\n"
			+ "ap.patient_id=p.patient_id \r\n"
			+ "left join billing as b\r\n"
			+ "on \r\n"
			+ "ap.appointment_id=b.billing_id",nativeQuery = true)
	List<AppointmentJoins> findByJoinsApsSeparate();

}

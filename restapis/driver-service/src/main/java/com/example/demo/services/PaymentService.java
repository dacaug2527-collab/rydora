package com.example.demo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Payment;
import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	
		
		//get by id
		public Payment getByPaymentId(Integer id) {
			Payment p = null;
			Optional<Payment> op = paymentRepository.findById(id);
			try {
				 p = op.get();
				
			}catch(NoSuchElementException ns) {
				ns.printStackTrace();
			}
			return p;
	}
		


		public void startKM(Integer paymentId, Double startkm) {
			Payment p = getByPaymentId(paymentId);
		     p.setStartKM(startkm);
		     paymentRepository.save(p);
			
		}
		
		public void endKM(Integer paymentId, Double endkm) {
			Payment p = getByPaymentId(paymentId);
		     p.setEndKM(endkm);
		     paymentRepository.save(p);
			
		}




		public Double totalKM(Integer paymentId) {
	        Payment p = getByPaymentId(paymentId);
			if(p.getStartKM() != null && p.getEndKM() != null) {
				Double totalkm = p.getEndKM()-p.getStartKM();
				p.setTotalKM(totalkm);
				paymentRepository.save(p);
				return p.getTotalKM();
			}
			return -1.0;
		}
		
		
		
		
}

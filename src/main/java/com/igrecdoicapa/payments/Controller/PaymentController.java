package com.igrecdoicapa.payments.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igrecdoicapa.payments.Entity.Payment;
import com.igrecdoicapa.payments.Entity.Payment.PaymentBuilder;

@RestController
public class PaymentController {
	
	@GetMapping("/payment-history")
	public List<Payment> getPayments() {
		List<Payment> payments = new ArrayList<>();
		
		Random random = new Random();
		int randomInt = random.nextInt(20);
		randomInt +=1;
		
		//Using builder design pattern. Fields are receiving values in PaymentBuilder setters
		PaymentBuilder paymentBuilder = new PaymentBuilder();
		
		while(payments.size() != randomInt) {
			paymentBuilder.setPaymentId()
				.setInvoiceId()
				.setType()
				.setInvoiceSerial()
				.setInvoiceNumber()
				.setPaymentDate()
				.setInvoiceValue();
			Payment payment = paymentBuilder.build();
			payments.add(payment);
		}
		
		
		return payments;
	}

}

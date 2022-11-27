package com.igrecdoicapa.payments.Entity;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Payment {
	private int paymentId;
	private int invoiceId;
	private String type;
	private String invoiceSerial;
	private String invoiceNumber;
	private LocalDate paymentDate;
	private double invoiceValue;
	
	private Payment() {
	}

	private Payment(int paymentId, int invoiceId, String type, String invoiceSerial, String invoiceNumber,
			LocalDate paymentDate, double invoiceValue) {
		super();
		this.paymentId = paymentId;
		this.invoiceId = invoiceId;
		this.type = type;
		this.invoiceSerial = invoiceSerial;
		this.invoiceNumber = invoiceNumber;
		this.paymentDate = paymentDate;
		this.invoiceValue = invoiceValue;
	}
	
	
	
	public int getPaymentId() {
		return paymentId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public String getType() {
		return type;
	}

	public String getInvoiceSerial() {
		return invoiceSerial;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public double getInvoiceValue() {
		return invoiceValue;
	}



	public static class PaymentBuilder {
		private int paymentId;
		private int invoiceId;
		private String type;
		private String invoiceSerial;
		private String invoiceNumber;
		private LocalDate paymentDate;
		private double invoiceValue;
		
		Random random = new Random();
		
		public PaymentBuilder() {
		}

		public PaymentBuilder setPaymentId() {
			
	        int randomInt = random.nextInt(9999);
	        randomInt +=1;
			this.paymentId = randomInt;
			return this;
		}

		public PaymentBuilder setInvoiceId() {
			int randomInt = random.nextInt(999999);
			randomInt +=1;
			this.invoiceId = randomInt;
			return this;
		}

		public PaymentBuilder setType() {
			int randomInt = random.nextInt(3);
			randomInt +=1;
			switch (randomInt) {
				case 1: this.type = "Plata online";
				break;
				case 2: this.type = "Chitanta";
				break;
				case 3: this.type = "PayPoint";
				break;
			}
			return this;
		}

		public PaymentBuilder setInvoiceSerial() {
			
			String letters = "QWERTYUIOPASDFGHJKLZXCVBNM";
			String tempSerial ="";
			
			while(tempSerial.length() != 4) {
				int randomInt = random.nextInt(26);
				tempSerial += Character.toString(letters.charAt(randomInt));
			}
			
			this.invoiceSerial = tempSerial;
			return this;
		}

		public PaymentBuilder setInvoiceNumber() {
			int randomInt = random.nextInt(9999999);
			randomInt +=1;
			String tempInvoiceNumber = Integer.toString(randomInt);
			while(tempInvoiceNumber.length() != 7) {
				tempInvoiceNumber = "0" + tempInvoiceNumber;
			}
			this.invoiceNumber = tempInvoiceNumber;
			return this;
		}

		public PaymentBuilder setPaymentDate() {
			LocalDateTime startDate = LocalDateTime.of(2021, 01, 01, 0, 0);
			LocalDateTime today = LocalDateTime.now();
			Duration duration = Duration.between(startDate, today);
			
			int randomInt = random.nextInt((int) duration.toDays());
			randomInt +=1;
			
			this.paymentDate = startDate.plusDays(randomInt).toLocalDate();
			
			return this;
		}

		public PaymentBuilder setInvoiceValue() {
			DecimalFormat df = new DecimalFormat("0.00");
			String tempInvoiceValue = df.format(random.nextDouble() * (15100.00 - 0.00) + 0.00);
			this.invoiceValue = Double.parseDouble(tempInvoiceValue);
			return this;
		}
		
		public Payment build() {
			return new Payment(this.paymentId, this.invoiceId, this.type, this.invoiceSerial, this.invoiceNumber, this.paymentDate, this.invoiceValue);
		}
		
	}

	
}

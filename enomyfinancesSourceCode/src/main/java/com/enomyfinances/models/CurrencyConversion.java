package com.enomyfinances.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "currencyConversion")
public class CurrencyConversion {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "transactionId")
	    private Long transactionId;
	 	
	 	@Column(name = "amount")
	 	private double amount;

	    @Column(name = "convertedAmount")
	    private double convertedAmount;

	    @Column(name = "toCurrency")
	    private String toCurrency;

	    @Column(name = "fromCurrency")
	    private String fromCurrency;

	    @Column(name = "finalAmount")
	    private double finalAmount;

	    @Column(name = "fee")
	    private double fee;

	    @ManyToOne
	    @JoinColumn(name = "userId", referencedColumnName = "userId")
	    private User user;
	    
	    public void setUser(User user) {
	        this.user = user;
	    }
	    
	    public CurrencyConversion(User user, double amount, double convertedAmount, String toCurrency, String fromCurrency,
	            double finalAmount, double fee) {
	        this.user = user;
	        this.amount = amount;
	        this.convertedAmount = convertedAmount;
	        this.toCurrency = toCurrency;
	        this.fromCurrency = fromCurrency;
	        this.finalAmount = finalAmount;
	        this.fee = fee;
	    }
	    
		public CurrencyConversion() {
		}

		public Long getTransactionId() {
			return transactionId;
		}


		public void setTransactionId(Long transactionId) {
			this.transactionId = transactionId;
		}
		
		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public double getConvertedAmount() {
			return convertedAmount;
		}


		public void setConvertedAmount(double convertedAmount) {
			this.convertedAmount = convertedAmount;
		}


		public String getToCurrency() {
			return toCurrency;
		}


		public void setToCurrency(String toCurrency) {
			this.toCurrency = toCurrency;
		}


		public String getFromCurrency() {
			return fromCurrency;
		}


		public void setFromCurrency(String fromCurrency) {
			this.fromCurrency = fromCurrency;
		}


		public double getFinalAmount() {
			return finalAmount;
		}


		public void setFinalAmount(double finalAmount) {
			this.finalAmount = finalAmount;
		}


		public double getFee() {
			return fee;
		}


		public void setFee(double fee) {
			this.fee = fee;
		}


}

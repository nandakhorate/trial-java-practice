package com.ked.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FLATPAYMENT")
public class FlatPayment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FLATPAYMENT_ID")
	private long id;

	@Column(name="PAYMENT_DATA")
	private Date paymentData;
	
	@Column(name="PAYMENT_AMOUNET")
	private double paymentAmount;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="FLATPAYMENT_CUSTOMER",joinColumns=@JoinColumn(name="FLATPAYMENT_ID"),inverseJoinColumns=@JoinColumn(name="CUSTOMER_ID"))
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FLAT_ID")
    private Flat flat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(Date paymentData) {
		this.paymentData = paymentData;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	
}

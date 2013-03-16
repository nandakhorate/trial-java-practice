package com.ked.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private long id;

	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Flat> flats = new HashSet<Flat>();
	
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<FlatPayment> flatPayments = new HashSet<FlatPayment>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Flat> getFlats() {
		return flats;
	}

	public void setFlats(Set<Flat> flats) {
		this.flats = flats;
	}

	public Set<FlatPayment> getFlatPayments() {
		return flatPayments;
	}

	public void setFlatPayments(Set<FlatPayment> flatPayments) {
		this.flatPayments = flatPayments;
	}

	public void addCustomerFlat(Flat flat){
		flats.add(flat);
		flat.setCustomer(this);
	}
	
	public void addFlatPayment(FlatPayment flatPayment){
		flatPayments.add(flatPayment);
		flatPayment.setCustomer(this);
	}
	

}

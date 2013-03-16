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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="FLAT")
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FLAT_ID")
	private long id;
	
	@Column(name="FLAT_NO")
	private long flatNo;
	
	@Transient
	private long siteId;
	
	@Transient
	private long buildingId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="FLAT_BUILDING",joinColumns=@JoinColumn(name="FLAT_ID"),inverseJoinColumns=@JoinColumn(name="BUILDING_ID"))
	private Building building;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="FLAT_CUSTOMER",joinColumns=@JoinColumn(name="FLAT_ID"),inverseJoinColumns=@JoinColumn(name="CUSTOMER_ID"))
	private Customer customer;
	
	@OneToMany(mappedBy="flat",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(mappedBy="flat")
    private Set<FlatPayment> flatPayments = new HashSet<FlatPayment>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(long flatNo) {
		this.flatNo = flatNo;
	}

	
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<FlatPayment> getFlatPayments() {
		return flatPayments;
	}

	public void setFlatPayments(Set<FlatPayment> flatPayments) {
		this.flatPayments = flatPayments;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}

	public void addFlatPayment(FlatPayment flatPayment){
		flatPayments.add(flatPayment);
		flatPayment.setFlat(this);
	}
	
	public void addDocument(Document document){
		documents.add(document);
		document.setFlat(this);
	}

	
	
}

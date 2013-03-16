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
@Table(name="BUILDING")
public class Building {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BUILDING_ID")
	private  long id;
	
	@Column(name="BUILDING_NAME")
	private  String name;
	
	@Column(name="BUILDING_ADDRESS")
	private  String address;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="BUILDING_SITE",joinColumns=@JoinColumn(name="BUILDING_ID"),inverseJoinColumns=@JoinColumn(name="SITE_ID"))
	private Site site;
	
	@OneToMany(mappedBy="building",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<Flat> flats = new HashSet<Flat>();
	
	@Transient
	private long siteId;


	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Site getSite() {
		return site;
	}




	public void setSite(Site site) {
		this.site = site;
	}




	public Set<Flat> getFlats() {
		return flats;
	}




	public void setFlats(Set<Flat> flats) {
		this.flats = flats;
	}




	public void addFlat(Flat flat){
		flats.add(flat);
		flat.setBuilding(this);
	}



}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.Cascade;


@Entity
@Table(name="SITE")
public class Site {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SITE_ID")
	private long id;
	
	@Column(name="NAME")
	private  String name;
	
	@Column(name="ADDRESS")
	private  String address;
	
	@OneToMany(mappedBy="site",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	//@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	Set<Building> buildings = new HashSet<Building>();

	
	
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



	public Set<Building> getBuildings() {
		return buildings;
	}



	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}



	public void addBuilding(Building building){
		buildings.add(building);
		building.setSite(this);
	}

}

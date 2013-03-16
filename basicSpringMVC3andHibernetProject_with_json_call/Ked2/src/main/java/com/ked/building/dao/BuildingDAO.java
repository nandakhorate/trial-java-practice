package com.ked.building.dao;

import java.util.List;

import com.ked.pojo.Building;
import com.ked.pojo.Site;


public interface BuildingDAO {
	
	public void addBuilding(Building building);
	public List<Building> listBuilding();
	public void removeBuilding(long id);
	public Building getBuilding(long id);
	public void updateBuilding(Building building);
}

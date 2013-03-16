package com.ked.building.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.building.dao.BuildingDAO;
import com.ked.pojo.Building;
import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDAO buildingDAO;
	
	@Transactional
	public void addBuilding(Building building) {
		buildingDAO.addBuilding(building);
	}

	@Transactional
	public List<Building> listBuilding() {

		return buildingDAO.listBuilding();
	}

	@Transactional
	public void removeBuilding(long id) {
		buildingDAO.removeBuilding(id);
	}
	@Transactional
	public Building getBuilding(long id) {
		return buildingDAO.getBuilding(id);
	}
	@Transactional
	public void updateBuilding(Building building) {
		buildingDAO.updateBuilding(building);
		
	}

	
}

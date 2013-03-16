package com.ked.building.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.Building;
import com.ked.pojo.Site;

@Repository
public class BuildingDAOImpl implements BuildingDAO {
	 protected Class<Building> domainClass = Building.class;
	@Autowired
	private SessionFactory sessionFactory;

	public void addBuilding(Building building) {
		sessionFactory.getCurrentSession().save(building);
	}

	public List<Building> listBuilding() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Building.class);
		List<Building> results = cr.list();
		return results;
		//return sessionFactory.getCurrentSession().createQuery("from Building").list();
	}

	public void removeBuilding(long id) {
		Building building = (Building) sessionFactory.getCurrentSession().get(
				Building.class, id);
		if (null != building) {
			sessionFactory.getCurrentSession().delete(building);
		}

	}

	public Building getBuilding(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		Building building = (Building) sessionFactory.getCurrentSession().get(Building.class, id);
		return building;
	}

	public void updateBuilding(Building building) {
		sessionFactory.getCurrentSession().update(building);
		
	}

}

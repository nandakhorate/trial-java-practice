package com.ked.flat.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.Flat;
import com.ked.pojo.Site;

@Repository
public class FlatDAOImpl implements FlatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFlat(Flat flat) {
		sessionFactory.getCurrentSession().save(flat);
	}

	public List<Flat> listFlat() {

		return sessionFactory.getCurrentSession().createQuery("from Flat").list();
	}

	public void removeFlat(long id) {
		Flat flat = (Flat) sessionFactory.getCurrentSession().get(
				Flat.class, id);
		if (null != flat) {
			sessionFactory.getCurrentSession().delete(flat);
		}

	}

	public Flat getFlat(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		Flat flat = (Flat) sessionFactory.getCurrentSession().get(Flat.class, id);
		return flat;
	}

	public void updateFlat(Flat flat) {
		sessionFactory.getCurrentSession().update(flat);
		
	}

}

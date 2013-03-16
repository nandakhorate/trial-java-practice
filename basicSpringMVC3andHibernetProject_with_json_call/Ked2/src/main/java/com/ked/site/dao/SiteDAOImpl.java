package com.ked.site.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.Site;

@Repository
public class SiteDAOImpl implements SiteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSite(Site site) {
		sessionFactory.getCurrentSession().save(site);
	}

	public List<Site> listSite() {

		return sessionFactory.getCurrentSession().createQuery("from Site").list();
	}

	public void removeSite(long id) {
		Site site = (Site) sessionFactory.getCurrentSession().get(
				Site.class, id);
		if (null != site) {
			sessionFactory.getCurrentSession().delete(site);
		}

	}

	public Site getSite(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		Site site = (Site) sessionFactory.getCurrentSession().get(Site.class, id);
		return site;
	}

	public void updateSite(Site site) {
		sessionFactory.getCurrentSession().update(site);
		
	}
}

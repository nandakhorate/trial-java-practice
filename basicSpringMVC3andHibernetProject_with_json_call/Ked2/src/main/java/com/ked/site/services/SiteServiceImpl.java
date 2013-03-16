package com.ked.site.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDAO siteDAO;
	
	@Transactional
	public void addSite(Site site) {
		siteDAO.addSite(site);
	}

	@Transactional
	public List<Site> listSite() {

		return siteDAO.listSite();
	}

	@Transactional
	public void removeSite(long id) {
		siteDAO.removeSite(id);
	}
	@Transactional
	public Site getSite(long id) {
		return siteDAO.getSite(id);
	}
	@Transactional
	public void updateSite(Site site) {
		siteDAO.updateSite(site);
		
	}

	
}

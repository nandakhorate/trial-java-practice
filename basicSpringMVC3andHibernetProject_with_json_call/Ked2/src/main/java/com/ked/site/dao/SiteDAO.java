package com.ked.site.dao;

import java.util.List;

import com.ked.pojo.Site;


public interface SiteDAO {
	
	public void addSite(Site site);
	public List<Site> listSite();
	public void removeSite(long id);
	public Site getSite(long id);
	public void updateSite(Site site);
}

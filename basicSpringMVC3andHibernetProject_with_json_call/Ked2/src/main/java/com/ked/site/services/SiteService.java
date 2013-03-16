package com.ked.site.services;

import java.util.List;

import com.ked.pojo.Site;


public interface SiteService {
	
	public void addSite(Site site);
	public List<Site> listSite();
	public void removeSite(long id);
	public Site getSite(long id);
	public void updateSite(Site customer);
}

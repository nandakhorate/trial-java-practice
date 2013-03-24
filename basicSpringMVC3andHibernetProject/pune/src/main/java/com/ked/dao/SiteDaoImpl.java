package com.ked.dao;

import org.springframework.stereotype.Repository;

import com.ked.idao.SiteDao;
import com.ked.pojo.Site;

@Repository
public class SiteDaoImpl extends GenericDaoImpl<Long,Site> implements SiteDao<Long,Site> {
	
	SiteDaoImpl() {
		super(Site.class);
	}
	
}

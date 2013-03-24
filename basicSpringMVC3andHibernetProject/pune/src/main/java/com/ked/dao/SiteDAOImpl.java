package com.ked.dao;

import org.springframework.stereotype.Repository;

import com.ked.idao.ISiteDAO;
import com.ked.pojo.Site;

@Repository
public class SiteDAOImpl extends GenericDAOImpl<Long,Site> implements ISiteDAO<Long,Site> {
	
	SiteDAOImpl() {
		super(Site.class);
	}
	
}

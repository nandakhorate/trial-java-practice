package com.ked.site;

import org.springframework.stereotype.Repository;

import com.ked.generic.GenericDAOImpl;

@Repository
public class SiteDAOImpl extends GenericDAOImpl<Long,Site> implements SiteDAO<Long,Site> {
	
	SiteDAOImpl() {
		super(Site.class);
	}
	
}

package com.ked.document.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.Document;
import com.ked.pojo.Site;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDocument(Document document) {
		sessionFactory.getCurrentSession().save(document);
	}

	public List<Document> listDocument() {

		return sessionFactory.getCurrentSession().createQuery("from Document").list();
	}

	public void removeDocument(long id) {
		Document document = (Document) sessionFactory.getCurrentSession().get(
				Document.class, id);
		if (null != document) {
			sessionFactory.getCurrentSession().delete(document);
		}

	}

	public Document getDocument(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		Document document = (Document) sessionFactory.getCurrentSession().get(Document.class, id);
		return document;
	}

	public void updateDocument(Document document) {
		sessionFactory.getCurrentSession().update(document);
		
	}

}

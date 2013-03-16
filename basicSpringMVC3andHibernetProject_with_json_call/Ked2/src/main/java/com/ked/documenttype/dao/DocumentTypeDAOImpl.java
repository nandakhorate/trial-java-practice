package com.ked.documenttype.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ked.pojo.DocumentType;
import com.ked.pojo.Site;

@Repository
public class DocumentTypeDAOImpl implements DocumentTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDocumentType(DocumentType documenttype) {
		sessionFactory.getCurrentSession().save(documenttype);
	}

	public List<DocumentType> listDocumentType() {

		return sessionFactory.getCurrentSession().createQuery("from DocumentType").list();
	}

	public void removeDocumentType(long id) {
		DocumentType documenttype = (DocumentType) sessionFactory.getCurrentSession().get(
				DocumentType.class, id);
		if (null != documenttype) {
			sessionFactory.getCurrentSession().delete(documenttype);
		}

	}

	public DocumentType getDocumentType(long id) {
		//if you write load then null value pass (lazy loading happed) so i used get method.
		DocumentType documenttype = (DocumentType) sessionFactory.getCurrentSession().get(DocumentType.class, id);
		return documenttype;
	}

	public void updateDocumentType(DocumentType documenttype) {
		sessionFactory.getCurrentSession().update(documenttype);
		
	}

}

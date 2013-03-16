package com.ked.documenttype.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.documenttype.dao.DocumentTypeDAO;
import com.ked.pojo.DocumentType;
import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

	@Autowired
	private DocumentTypeDAO documenttypeDAO;
	
	@Transactional
	public void addDocumentType(DocumentType documenttype) {
		documenttypeDAO.addDocumentType(documenttype);
	}

	@Transactional
	public List<DocumentType> listDocumentType() {

		return documenttypeDAO.listDocumentType();
	}

	@Transactional
	public void removeDocumentType(long id) {
		documenttypeDAO.removeDocumentType(id);
	}
	@Transactional
	public DocumentType getDocumentType(long id) {
		return documenttypeDAO.getDocumentType(id);
	}
	@Transactional
	public void updateDocumentType(DocumentType documenttype) {
		documenttypeDAO.updateDocumentType(documenttype);
		
	}

	
}

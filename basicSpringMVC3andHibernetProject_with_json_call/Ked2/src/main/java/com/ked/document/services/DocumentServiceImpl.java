package com.ked.document.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ked.document.dao.DocumentDAO;
import com.ked.pojo.Document;
import com.ked.pojo.Site;
import com.ked.site.dao.SiteDAO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;
	
	@Transactional
	public void addDocument(Document document) {
		documentDAO.addDocument(document);
	}

	@Transactional
	public List<Document> listDocument() {

		return documentDAO.listDocument();
	}

	@Transactional
	public void removeDocument(long id) {
		documentDAO.removeDocument(id);
	}
	@Transactional
	public Document getDocument(long id) {
		return documentDAO.getDocument(id);
	}
	@Transactional
	public void updateDocument(Document document) {
		documentDAO.updateDocument(document);
		
	}

	
}

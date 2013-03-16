package com.ked.document.dao;

import java.util.List;

import com.ked.pojo.Document;
import com.ked.pojo.Site;


public interface DocumentDAO {
	
	public void addDocument(Document document);
	public List<Document> listDocument();
	public void removeDocument(long id);
	public Document getDocument(long id);
	public void updateDocument(Document document);
}

package com.ked.documenttype.services;

import java.util.List;

import com.ked.pojo.DocumentType;
import com.ked.pojo.Site;


public interface DocumentTypeService {
	
	public void addDocumentType(DocumentType documenttype);
	public List<DocumentType> listDocumentType();
	public void removeDocumentType(long id);
	public DocumentType getDocumentType(long id);
	public void updateDocumentType(DocumentType documenttype);
}

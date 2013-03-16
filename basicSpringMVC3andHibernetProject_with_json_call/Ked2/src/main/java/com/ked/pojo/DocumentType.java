package com.ked.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="DOCUMENT_TYPE")
public class DocumentType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOCUMENT_ID")
	private long id;
	
	@Column(name="DOCUMENT_NAME")
	private String documentName;
	
	
	@OneToMany(mappedBy="documentType")
    private Set<Document> documents = new HashSet<Document>();

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getDocumentName() {
		return documentName;
	}


	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}


	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public void addDocument(Document document){
		documents.add(document);
		document.setDocumentType(this);
	}
}

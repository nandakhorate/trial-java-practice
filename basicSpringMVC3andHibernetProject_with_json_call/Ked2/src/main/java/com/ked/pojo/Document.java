package com.ked.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENT")
public class Document {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOCUMENT_ID")
	private long id;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="STATUS")
	private boolean status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinTable(name="DOCUMENT_FLAT",joinColumns=@JoinColumn(name="DOCUMENT_ID"),inverseJoinColumns=@JoinColumn(name="FLAT_ID"))
	private Flat flat;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DOCUMENTTYPE_ID")
    private DocumentType documentType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
	
}

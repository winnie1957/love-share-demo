package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

	@CreatedBy
	@Column(name = "created_by")
	private T createdBy;
	@CreatedDate
	@Column(name = "created_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate = new Date();
	@LastModifiedBy
	@Column(name = "last_modified_by")
	private T lastModifiedBy;
	@LastModifiedDate
	@Column(name = "last_modified_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastModifiedDate = new Date();
	
	
	
	public T getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(T createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public T getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(T lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
}

package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "c_id")
	private Long cId;
	@Column(name = "c_name", nullable = false)
	private String cName;
	@Column(name = "c_sort")
	private Integer cSort;
	@Column(name = "c_code")
	private String cCode;
	
	public Category() {		
	}

	public Category(String cName) {
		this.cName = cName;
	}
	
	public Category(String cName, String cCode) {
		this.cName = cName;
		this.cCode = cCode;
	}
	
	public Category(Long cId, String cName, Integer cSort, String cCode) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cSort = cSort;
		this.cCode = cCode;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getcSort() {
		return cSort;
	}

	public void setcSort(Integer cSort) {
		this.cSort = cSort;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [cId=");
		builder.append(cId);
		builder.append(", cName=");
		builder.append(cName);
		builder.append(", cSort=");
		builder.append(cSort);
		builder.append(", cCode=");
		builder.append(cCode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

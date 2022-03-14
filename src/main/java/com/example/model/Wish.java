package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Wishes")
public class Wish extends Auditable<String> implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "w_id")
	private Long wId;
	@Column(name = "w_name", nullable = false, unique = true)
	private String wName;
	@Column(name = "w_state")
	private String wState;
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Category category;
	@Column(name = "w_quantity", nullable = false)
	private int wQuantity;
	@Column(name = "w_img")
	private String wImg;
	@Column(name = "w_desc")
	private String wDesc;
	
	
	
	public Wish() {
	}

	public Wish(Long wId, String wName, String wState, Category category, int wQuantity, String wImg, String wDesc) {
		this.wId = wId;
		this.wName = wName;
		this.wState = wState;
		this.category = category;
		this.wQuantity = wQuantity;
		this.wImg = wImg;
		this.wDesc = wDesc;
	}


	public Long getwId() {
		return wId;
	}

	public void setwId(Long wId) {
		this.wId = wId;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getwState() {
		return wState;
	}

	public void setwState(String wState) {
		this.wState = wState;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getwQuantity() {
		return wQuantity;
	}

	public void setwQuantity(int wQuantity) {
		this.wQuantity = wQuantity;
	}

	public String getwImg() {
		return wImg;
	}

	public void setwImg(String wImg) {
		this.wImg = wImg;
	}

	public String getwDesc() {
		return wDesc;
	}

	public void setwDesc(String wDesc) {
		this.wDesc = wDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wish [wId=");
		builder.append(wId);
		builder.append(", wName=");
		builder.append(wName);
		builder.append(", wState=");
		builder.append(wState);
		builder.append(", category=");
		builder.append(category);
		builder.append(", wQuantity=");
		builder.append(wQuantity);
		builder.append(", wImg=");
		builder.append(wImg);
		builder.append(", wDesc=");
		builder.append(wDesc);
		builder.append("]");
		return builder.toString();
	}



	
	
	
}

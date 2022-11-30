package com.example.model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@Column(name = "w_enabled")
	private Boolean wEnabled;
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Category category;
	@Column(name = "w_quantity", nullable = false)
	private Integer wQuantity;
	@Column(name = "w_img")
	private String wImg;
	@ManyToOne
	@JoinColumn(name = "w_wisher")
	private User wWisher;
	@Column(name = "w_startdate")
	private String wStartDate;
	@Column(name = "w_enddate")
	private String wEndDate;
//	留言
	@Lob
	@Column(name = "w_content", columnDefinition = "longtext")
	private String wContent;
	
	
	
	public Wish() {
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



	public Boolean getwEnabled() {
		return wEnabled;
	}



	public void setwEnabled(Boolean wEnabled) {
		this.wEnabled = wEnabled;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Integer getwQuantity() {
		return wQuantity;
	}



	public void setwQuantity(Integer wQuantity) {
		this.wQuantity = wQuantity;
	}



	public String getwImg() {
		return wImg;
	}
	
	

	public void setwImg(String wImg) {
		this.wImg = wImg;
	}



	public User getwWisher() {
		return wWisher;
	}



	public void setwWisher(User wWisher) {
		this.wWisher = wWisher;
	}



	public String getwContent() {
		return wContent;
	}



	public void setwContent(String wContent) {
		this.wContent = wContent;
	}



	public String getwStartDate() {
		return wStartDate;
	}



	public void setwStartDate(String wStartDate) {
		this.wStartDate = wStartDate;
	}



	public String getwEndDate() {
		return wEndDate;
	}


	public void setwEndDate(String wEndDate) {
		this.wEndDate = wEndDate;
	}


	@Transient
	public String getWishImgPath() {
		if (wImg == null || wId == null) return null;
		return "/wish-photos/" + wId + wImg;
	}

	




	
	
	
}

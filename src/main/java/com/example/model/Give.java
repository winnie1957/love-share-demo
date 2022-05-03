package com.example.model;

import java.io.Serializable;

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
@Table(name = "Gives")
public class Give extends Auditable<String> implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "g_id")
	private Long gId;
//	訂單狀態
	@Column(name = "g_state")
	private String gState;
	@Column(name = "g_enabled")
	private boolean gEnabled;
//	徵求案件
	@ManyToOne
	@JoinColumn(name = "g_wish_id", nullable = false)
	private Wish gWish;
//	捐贈數量
	@Column(name = "g_quantity", nullable = false)
	private int gQuantity;
//	配送方式
	@Column(name="g_shipping", nullable = false)
	private String gShipping;
//	捐贈者
	@ManyToOne
	@JoinColumn(name = "g_giver")
	private User gGiver;
//	留言
	@Lob
	@Column(name = "g_content", columnDefinition = "longtext")
	private String gContent;
//	配送日期
//	運費
//	商品總額,訂單金額
	

	public Give() {
		
	}
	
	public Give(Wish gWish) {
		this.gWish = gWish;
	}


	public Long getgId() {
		return gId;
	}


	public void setgId(Long gId) {
		this.gId = gId;
	}


	public String getgState() {
		return gState;
	}


	public void setgState(String gState) {
		this.gState = gState;
	}


	public Wish getgWish() {
		return gWish;
	}


	public void setgWish(Wish gWish) {
		this.gWish = gWish;
	}


	public int getgQuantity() {
		return gQuantity;
	}


	public void setgQuantity(int gQuantity) {
		this.gQuantity = gQuantity;
	}


	public String getgShipping() {
		return gShipping;
	}


	public void setgShipping(String gShipping) {
		this.gShipping = gShipping;
	}


	public String getgContent() {
		return gContent;
	}

	public void setgContent(String gContent) {
		this.gContent = gContent;
	}

	public User getgGiver() {
		return gGiver;
	}

	public void setgGiver(User gGiver) {
		this.gGiver = gGiver;
	}

	public boolean isgEnabled() {
		return gEnabled;
	}

	public void setgEnabled(boolean gEnabled) {
		this.gEnabled = gEnabled;
	}


	
	





	


	
	



	
	
	
}

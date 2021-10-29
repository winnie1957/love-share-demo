package net.codejava.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Demand_record")
public class DemandRecord implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "dr_Id", nullable = false)
	private Long drId;
//	@Column(name = "d_id", nullable = false)
//	private int dId;
//	@Column(name = "user_id", nullable = false)
//	private String userId;
	@Column(name = "dr_qua", nullable = false)
	private int drQua;
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dr_date", nullable = false)
	private Date drDate;

	@ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_d_id", referencedColumnName = "d_id")
	private DemandCase demandCase;
	@ManyToOne
	@JoinColumn(name = "FK_user_id", referencedColumnName = "user_id")
	private User user;
	
	public DemandRecord(){
		
	}

	public DemandRecord(Long drId, int drQua, Date drDate, DemandCase demandCase, User user) {
		super();
		this.drId = drId;
		this.drQua = drQua;
		this.drDate = drDate;
		this.demandCase = demandCase;
		this.user = user;
	}

	public Long getDrId() {
		return drId;
	}

	public void setDrId(Long drId) {
		this.drId = drId;
	}

	public int getDrQua() {
		return drQua;
	}

	public void setDrQua(int drQua) {
		this.drQua = drQua;
	}

	public Date getDrDate() {
		return drDate;
	}

	public void setDrDate(Date drDate) {
		this.drDate = drDate;
	}

	public DemandCase getDemandCase() {
		return demandCase;
	}

	public void setDemandCase(DemandCase demandCase) {
		this.demandCase = demandCase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemandRecord [drId=");
		builder.append(drId);
		builder.append(", drQua=");
		builder.append(drQua);
		builder.append(", drDate=");
		builder.append(drDate);
		builder.append(", demandCase=");
		builder.append(demandCase);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
}

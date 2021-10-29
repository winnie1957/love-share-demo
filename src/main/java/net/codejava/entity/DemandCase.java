package net.codejava.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Demand_case")
public class DemandCase implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "d_id")
	private Long dId;
//	@Column(name = "i_id", nullable = false)
//	private Long iId;
	@Column(name = "d_product", nullable = false)
	private String dProduct;
	@Column(name = "d_desc", nullable = false)
	private String dDesc;
	@Column(name = "d_quan", nullable = false)
	private int dQuan;
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "d_timestart", nullable = false)
	private Date dTimestart;
//   @Temporal(TemporalType.DATE)
	@Column(name = "d_timeover", nullable = false)
	private Date dTimeover;
	@Column(name = "d_contact_person", nullable = false)
	private String dContactPerson;
	@Column(name = "d_contact_phone", nullable = false)
	private String dContactPhone;
	@Column(name = "d_contact_email", nullable = false)
	private String dContactEmail;
	@Column(name = "d_contact_address", nullable = false)
	private String dContactAddress;
	@Column(name = "d_img_url", nullable = false)
	private String dImgUrl;
	@Column(name = "isFinish", nullable = false)
	private Boolean isFinish = false;
	
	@ManyToOne
	@JoinColumn(name = "FK_i_id", referencedColumnName = "i_id")
	private Institution institution;
	
	public DemandCase() {
		
	}
	public DemandCase(Long dId, String dProduct, String dDesc, int dQuan, Date dTimestart, Date dTimeover,
			String dContactPerson, String dContactPhone, String dContactEmail, String dContactAddress, String dImgUrl,
			boolean isFinish, Institution institution) {
		super();
		this.dId = dId;
		this.dProduct = dProduct;
		this.dDesc = dDesc;
		this.dQuan = dQuan;
		this.dTimestart = dTimestart;
		this.dTimeover = dTimeover;
		this.dContactPerson = dContactPerson;
		this.dContactPhone = dContactPhone;
		this.dContactEmail = dContactEmail;
		this.dContactAddress = dContactAddress;
		this.dImgUrl = dImgUrl;
		this.isFinish = isFinish;
		this.institution = institution;
	}

	public Long getdId() {
		return dId;
	}

	public void setdId(Long dId) {
		this.dId = dId;
	}

	public String getdProduct() {
		return dProduct;
	}

	public void setdProduct(String dProduct) {
		this.dProduct = dProduct;
	}

	public String getdDesc() {
		return dDesc;
	}

	public void setdDesc(String dDesc) {
		this.dDesc = dDesc;
	}

	public int getdQuan() {
		return dQuan;
	}

	public void setdQuan(int dQuan) {
		this.dQuan = dQuan;
	}

	public Date getdTimestart() {
		return dTimestart;
	}

	public void setdTimestart(Date dTimestart) {
		this.dTimestart = dTimestart;
	}

	public Date getdTimeover() {
		return dTimeover;
	}

	public void setdTimeover(Date dTimeover) {
		this.dTimeover = dTimeover;
	}

	public String getdContactPerson() {
		return dContactPerson;
	}

	public void setdContactPerson(String dContactPerson) {
		this.dContactPerson = dContactPerson;
	}

	public String getdContactPhone() {
		return dContactPhone;
	}

	public void setdContactPhone(String dContactPhone) {
		this.dContactPhone = dContactPhone;
	}

	public String getdContactEmail() {
		return dContactEmail;
	}

	public void setdContactEmail(String dContactEmail) {
		this.dContactEmail = dContactEmail;
	}

	public String getdContactAddress() {
		return dContactAddress;
	}

	public void setdContactAddress(String dContactAddress) {
		this.dContactAddress = dContactAddress;
	}

	public String getdImgUrl() {
		return dImgUrl;
	}

	public void setdImgUrl(String dImgUrl) {
		this.dImgUrl = dImgUrl;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemandCase [dId=");
		builder.append(dId);
		builder.append(", dProduct=");
		builder.append(dProduct);
		builder.append(", dDesc=");
		builder.append(dDesc);
		builder.append(", dQuan=");
		builder.append(dQuan);
		builder.append(", dTimestart=");
		builder.append(dTimestart);
		builder.append(", dTimeover=");
		builder.append(dTimeover);
		builder.append(", dContactPerson=");
		builder.append(dContactPerson);
		builder.append(", dContactPhone=");
		builder.append(dContactPhone);
		builder.append(", dContactEmail=");
		builder.append(dContactEmail);
		builder.append(", dContactAddress=");
		builder.append(dContactAddress);
		builder.append(", dImgUrl=");
		builder.append(dImgUrl);
		builder.append(", isFinish=");
		builder.append(isFinish);
		builder.append(", institution=");
		builder.append(institution);
		builder.append("]");
		return builder.toString();
	}
	
}

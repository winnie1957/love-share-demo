package net.codejava.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Institution")
public class Institution implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "i_id")
	private Long iId;
	@Column(name = "i_name", nullable = false)
	private String iName;	//帳號
	@Column(name = "i_password", nullable = false)
	private String iPassword;
	@Column(name = "i_institution", nullable = false)
	private String iInstitution;
	@Column(name = "i_desc")
	private String iDesc;
	@Column(name = "i_website")
	private String iWebsite;
	@Column(name = "i_contact_person")
	private String iContactPerson;
	@Column(name = "i_phone")
	private String iPhone;
	@Column(name = "i_email", nullable = false, unique = true)
	private String iEmail;
	@Column(name = "i_address")
	private String iAddress;
	
	public Institution() {
		
	}

	public Institution(Long iId, String iName, String iPassword, String iInstitution, String iDesc, String iWebsite,
			String iContactPerson, String iPhone, String iEmail, String iAddress) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iPassword = iPassword;
		this.iInstitution = iInstitution;
		this.iDesc = iDesc;
		this.iWebsite = iWebsite;
		this.iContactPerson = iContactPerson;
		this.iPhone = iPhone;
		this.iEmail = iEmail;
		this.iAddress = iAddress;
	}

	public Long getiId() {
		return iId;
	}

	public void setiId(Long iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiPassword() {
		return iPassword;
	}

	public void setiPassword(String iPassword) {
		this.iPassword = iPassword;
	}

	public String getiInstitution() {
		return iInstitution;
	}

	public void setiInstitution(String iInstitution) {
		this.iInstitution = iInstitution;
	}

	public String getiDesc() {
		return iDesc;
	}

	public void setiDesc(String iDesc) {
		this.iDesc = iDesc;
	}

	public String getiWebsite() {
		return iWebsite;
	}

	public void setiWebsite(String iWebsite) {
		this.iWebsite = iWebsite;
	}

	public String getiContactPerson() {
		return iContactPerson;
	}

	public void setiContactPerson(String iContactPerson) {
		this.iContactPerson = iContactPerson;
	}

	public String getiPhone() {
		return iPhone;
	}

	public void setiPhone(String iPhone) {
		this.iPhone = iPhone;
	}

	public String getiEmail() {
		return iEmail;
	}

	public void setiEmail(String iEmail) {
		this.iEmail = iEmail;
	}

	public String getiAddress() {
		return iAddress;
	}

	public void setiAddress(String iAddress) {
		this.iAddress = iAddress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Institution [iId=");
		builder.append(iId);
		builder.append(", iName=");
		builder.append(iName);
		builder.append(", iPassword=");
		builder.append(iPassword);
		builder.append(", iInstitution=");
		builder.append(iInstitution);
		builder.append(", iDesc=");
		builder.append(iDesc);
		builder.append(", iWebsite=");
		builder.append(iWebsite);
		builder.append(", iContactPerson=");
		builder.append(iContactPerson);
		builder.append(", iPhone=");
		builder.append(iPhone);
		builder.append(", iEmail=");
		builder.append(iEmail);
		builder.append(", iAddress=");
		builder.append(iAddress);
		builder.append("]");
		return builder.toString();
	}
	
	
}

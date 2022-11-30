package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Long uId;
	@Column(name = "u_username", nullable = false, unique = true)
	private String uUsername;
	@Column(name = "u_nickname")
	private String uNickname;
	@Column(name = "u_password", nullable = false)
	private String uPassword;
	@Column(name = "u_email", nullable = false)
	private String uEmail;
	@Column(name = "u_role")
	private String uRole;
    @Column(name = "u_enabled")
    private Boolean uEnabled;
	
    public User() {		
	}
    
	public User(String uUsername, String uPassword, String uEmail, String uRole) {
		super();
		this.uUsername = uUsername;
		this.uPassword = uPassword;
		this.uEmail = uEmail;
		this.uRole = uRole;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuUsername() {
		return uUsername;
	}

	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}

	public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuRole() {
		return uRole;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	public Boolean isuEnabled() {
		return uEnabled;
	}

	public void setuEnabled(Boolean uEnabled) {
		this.uEnabled = uEnabled;
	}

	
	
	

	
}

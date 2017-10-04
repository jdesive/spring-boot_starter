package com.desive.starter.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@ToString(of = { "id", "username" })
@EqualsAndHashCode(of = { "username", "enabled" })
/*
 Represents the users table

 Created by Jack DeSive on 10/3/2017 at 3:17 AM
*/
public class User {

	public static final int MAX_LENGTH_USERNAME = 30;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true, length = MAX_LENGTH_USERNAME)
	private String username;

	@Column(nullable = false)
	private String password;

	private Boolean enabled;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date creationTime;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date modificationTime;

	public User() {
	}

	@PrePersist
	public void prePersist() {
		creationTime = new Date(System.currentTimeMillis());
	}

	@PreUpdate
	public void preUpdate() {
		modificationTime = new Date(System.currentTimeMillis());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

}

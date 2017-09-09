package com.desive.starter.entities;

// @formatter:off
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of = { "username", "roles", "enabled" })
@ToString(of = { "id", "username" })
@Entity
@Table(name = "users")
public class User {

	public static final int MAX_LENGTH_USERNAME = 30;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true, length = MAX_LENGTH_USERNAME)
	private String username;

	@Column(nullable = false)
	private String password;

	private boolean enabled;
	private LocalDateTime creationTime;
	private LocalDateTime modificationTime;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	/**
	 * Constructor used exclusively by {@link com.desive.starter.support.security.CustomUserDetails}}
	 *
	 * @param user
	 */
	public User(final User user) {
		this.id = user.id;
		this.username = user.username;
		this.password = user.password;
		this.enabled = user.enabled;
	}

	@PrePersist
	public void prePersist() {
		creationTime = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		modificationTime = LocalDateTime.now();
	}

	public static int getMaxLengthUsername() {
		return MAX_LENGTH_USERNAME;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

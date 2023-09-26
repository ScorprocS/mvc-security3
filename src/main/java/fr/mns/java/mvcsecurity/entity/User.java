package fr.mns.java.mvcsecurity.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;


@Entity
@Table(name = "user",indexes = {@Index(columnList = "username")})
public class User implements Serializable {

	private static final long serialVersionUID = 5087034724117189627L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false, unique=true)
	private Long id;

	@Column(name = "username",unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@CreationTimestamp
	@Column(name = "creation_date")
	private LocalDate creationDate;

	@Column(name = "email",unique = true)
	private String email;

	@Column(name = "enabled")
	private Boolean isEnabled=true;
	
	
	
    @ElementCollection(targetClass=Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name="user_role")
	@Enumerated(EnumType.STRING)
    @Column(name="role")
	private Set<Role> roles=new HashSet<>();



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	public LocalDate getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Boolean getIsEnabled() {
		return isEnabled;
	}



	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
    
    
    

}

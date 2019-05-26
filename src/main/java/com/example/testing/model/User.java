package com.example.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * @author Marcus Lowe
 *
 */
@Data
@Entity
public class User {

	@Id
	private Long id;
	
	@Column(unique=true,nullable=false)
	@Size(max=50)
	@NotNull
	private String emailAddress;
	
	@Column(nullable=false)
	@NotNull
	private String password;
}

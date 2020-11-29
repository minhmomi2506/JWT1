package com.example.JWT1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Users {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String username;

	@Column
	private String password;

}

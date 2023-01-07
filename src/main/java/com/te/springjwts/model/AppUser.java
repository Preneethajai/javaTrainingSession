package com.te.springjwts.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "usertable")
public class AppUser {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String username;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "rolestable", joinColumns = @JoinColumn(name="id"))
	@Column(name = "role")
	private Set<String> roles;
}

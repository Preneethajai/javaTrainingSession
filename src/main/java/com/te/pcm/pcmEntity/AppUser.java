package com.te.pcm.pcmEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	@Id
	private String userName;
	private String password;
	private String roles;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Roles roles;

}

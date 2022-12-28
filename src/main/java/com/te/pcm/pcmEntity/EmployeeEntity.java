package com.te.pcm.pcmEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
	@Id
	private int empId;
	private String empName;
	private String empEmail;
	private long empPhone;
	private String empPassword;
	private String empRoles;
	
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeEntity")
//	@JoinColumn(name = "empId")
//	private AppUser appUser;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private DepartmentsEntity departmentsEntity;
}

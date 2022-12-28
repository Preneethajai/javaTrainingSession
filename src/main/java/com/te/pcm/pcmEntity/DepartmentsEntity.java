package com.te.pcm.pcmEntity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsEntity {
	@Id
	private int departmentId;
	@Column(length = 45)
	private String departmentTitle;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
	private List<ProductEntity> productEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
	private List<CategoriesEntity> categoriesEntities;
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "departmentId")
//	private EmployeeEntity employeeEntity;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId",referencedColumnName = "departmentId")
	private List<EmployeeEntity> employeeEntity;

}

package com.te.pcm.pcmdto;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.te.pcm.pcmentity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentsDto {

	private int departmentId;
	private String departmentTitle;
	
	
}

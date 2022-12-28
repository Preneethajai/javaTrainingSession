package com.te.pcm.pcmDto;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.te.pcm.pcmEntity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentsDto {

	private int departmentId;
	private String departmentTitle;
	
	
}

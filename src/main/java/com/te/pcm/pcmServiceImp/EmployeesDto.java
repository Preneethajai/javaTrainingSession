package com.te.pcm.pcmServiceImp;

import com.te.pcm.pcmDto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class EmployeesDto {
	private int empId;
	private String empName;
	private String empEmail;
	private long empPhone;
	private String empRoles;
	private String empPassword;
	private int departmentId;
}

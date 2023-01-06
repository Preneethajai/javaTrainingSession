package com.te.pcm.pcmdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private int empId;
	private String empName;
	private String empEmail;
	private long empPhone;
	private String empRoles;
	
}

package com.te.javabasic.collections;

public class Employee implements Comparable<Employee> {
	int empId;
	String empName;

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ",empName=" + empName + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return o.empName.compareTo(this.empName);// this compareTo method is from String class that converts the String
													// to the int type for comparing
//		return o.empId - this.empId;
	}

}

package com.te.javabasic.collections;

import java.util.Comparator;

public class CompareByID implements Comparator<Employee> {

	@Override
	public int compare(Employee o, Employee o1) {

		return ((Employee) o).empId - ((Employee) o1).empId;
	}

}

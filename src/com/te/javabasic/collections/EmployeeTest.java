package com.te.javabasic.collections;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee = new Employee(10, "AA");
		Employee employee1 = new Employee(40, "UU");
		Employee employee2 = new Employee(8, "PP");
		Employee employee3 = new Employee(20, "KK");

		ArrayList<Employee> arraylist = new ArrayList<Employee>();
		arraylist.add(employee);
		arraylist.add(employee1);
		arraylist.add(employee2);
		arraylist.add(employee3);

		System.out.println("Before sorting");
		for (Employee employee4 : arraylist) {
			System.out.println(employee4);
		}
		System.out.println("After sorting");
		for (Employee employee4 : arraylist) {
			System.out.println(employee4);
		}
		System.out.println("****************");
		Collections.sort(arraylist, new CompareByID());
		for (Employee employee4 : arraylist) {
			System.out.println(employee4);
		}
	}

}

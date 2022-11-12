package com.te.students.comparable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class StudentDriver {
	static Scanner s = new Scanner(System.in);
	static ArrayList<Students> arrayList;
	static int n;
	static boolean repeat = true;

	public static void main(String[] args) {
		Students students = new Students(30, "KK", 12, 80);
		Students students1 = new Students(10, "LL", 11, 90);
		Students students2 = new Students(60, "YY", 10, 87);
		Students students3 = new Students(20, "AA", 11, 67);
		Students students4 = new Students(80, "HH", 13, 44);
		arrayList = new ArrayList<Students>();
		arrayList.add(students);
		arrayList.add(students1);
		arrayList.add(students2);
		arrayList.add(students3);
		arrayList.add(students4);
		System.out.println("Before sorting");
		for (Students students5 : arrayList) {
			System.out.println(students5);
		}
		System.out.println("After sorting");
		Collections.sort(arrayList);
		for (Students students5 : arrayList) {
			System.out.println(students5);
		}

	}

}

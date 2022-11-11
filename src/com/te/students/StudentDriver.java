package com.te.students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentDriver {
static Scanner s=new Scanner(System.in);
 static ArrayList<Students> arrayList;
static int n;
static boolean repeat=true;
	public static void main(String[] args) {
		Students students = new Students(30, "KK", 12, 80);
		Students students1 = new Students(10, "LL", 11, 90);
		Students students2 = new Students(60, "YY", 10, 87);
		Students students3 = new Students(20, "AA", 11, 67);
		Students students4 = new Students(80, "HH", 13, 44);
		arrayList= new ArrayList<Students>();
		arrayList.add(students);
		arrayList.add(students1);
		arrayList.add(students2);
		arrayList.add(students3);
		arrayList.add(students4);
		System.out.println("Before sorting");
		for (Students students5 : arrayList) {
			System.out.println(students5);
		}
		arrage();
		do {
				System.out.println("do you want to continue enter yes or no ");
				String string = s.next();
				if (string.equalsIgnoreCase("yes")) {
					arrage();
				}
				else if (string.equalsIgnoreCase("no")) {
					repeat=false;
				}
				else {
					System.out.println("you have enter wrong key");
					
				}
		}while(repeat);
	}
			public static void arrage() {
			System.out.println("Enter the choice");
			System.out.println("1.Sort by Name\n2.Sort by Id\n3.Sort by Mark\n4.Sort by Age\n5.Exit");
			n=s.nextInt();
			switch (n) {
			case 1:{
				Collections.sort(arrayList, new CompareByName());
				for (Students students5 : arrayList) {
					System.out.println(students5);
				
					}
			}break;
			case 2:{
				Collections.sort(arrayList, new CompareById());
				for (Students students5 : arrayList) {
					System.out.println(students5);
				
				}
			}break;
			case 3:{
				Collections.sort(arrayList, new CompareByMark());
				for (Students students5 : arrayList) {
					System.out.println(students5);
			
				}
			}break;
			case 4:{
				Collections.sort(arrayList, new CompareByAge());
				for (Students students5 : arrayList) {
					System.out.println(students5);
				
				}
			}break;
			
			default:
				System.out.println("Enter the valid input");
				break;
			}
		}

}

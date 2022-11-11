package com.te.javabasic.collections;

import java.util.Iterator;

public class MyArrrayList {

	public static void main(String[] args) {
		ArrayListDemo arraylist =new ArrayListDemo(2);
		arraylist.add(10);
		arraylist.add(20);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		arraylist.add(30);
		/* System.out.println(arraylist); */
//		System.out.println(arraylist.toString());
//		System.out.println(arraylist.size());
//		System.out.println("**********************************");
//		for(int i=0;i<arraylist.size();i++) {
//			System.out.println(arraylist.get(i));
//			}
		/*
		 * for (Object object : arraylist) { System.out.println(arraylist); }
		 */
		Iterator iterator=arraylist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

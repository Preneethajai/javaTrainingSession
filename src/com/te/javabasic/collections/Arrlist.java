package com.te.javabasic.collections;

import java.util.*;

public class Arrlist {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Object object : list) {
			System.out.println(object);
		}
		Iterator<Integer> iterator=list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}

}

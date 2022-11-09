package com.te.restaurant;

import java.util.Scanner;

public class Restaurant {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Restaurant");
		System.out.println("Select the Requied items from the list");
		Items.items();
//		System.out.println("Enter the items you want");
//		int list = s.nextInt();
//		Items.itemsPrice(list);

	}

}

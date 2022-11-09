package com.te.restaurant;

import java.util.Scanner;

public class Items {
	static Scanner s = new Scanner(System.in);
	static int tot, price, qan, bill, total;
	static boolean repeat = true;
	static int[] quantity = new int[4];
	static int[] p = { 100, 200, 300, 400 };
	static String[] items = { "1.meal", "2.rice", "3.fries", "4.juice" };

	public static void items() {
//		String[] it = { "Items Price", "meal 100", "rice 200", "fries 300", "juice 400" };
			int[] p = { 100, 200, 300, 400 };
//			int[] quantity = new int[4];
			for (int i = 0; i < items.length; i++) {
				System.out.println(items[i] + " " + p[i]);
			}
			do {
			System.out.println("enter the item");
			int food = s.nextInt();
			if (food > 0 && food <= 5) {	
				switch(food) {
				case 1:
				case 2:
				case 3:
				case 4:{
					System.out.println("enter the no of quantites of " + items[food - 1]);
					qan = s.nextInt();
					quantity[food - 1] = +qan;
					System.out.println("enter option 5 to get the overall bill");
					for (int i = 0; i < items.length; i++) {
						if (quantity[i] != 0) {
							bill+= quantity[i] * p[i];
						}
						quantity[i]=0;
						}
					break;
					}
				case 5:{
					System.out.println("Thank You");
					repeat = false;
						}
					}
				
				}
			else {
				throw new CaseException("Enter the valid case!!!!!!");
			}
			}while (repeat);
		System.out.println("the overall summary of the order");
		System.out.println("The total bill amount " + bill);
	}
}

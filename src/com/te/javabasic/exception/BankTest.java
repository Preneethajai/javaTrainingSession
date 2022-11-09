package com.te.javabasic.exception;

public class BankTest {
	public static void main(String[] args) {
		Bank b = new Bank(2000);

//		try {
			b.withdraw(3000);
//		} catch (InsufficientBalanceException e) {
//			System.out.println(e.getMessage());
//		}
	}
}


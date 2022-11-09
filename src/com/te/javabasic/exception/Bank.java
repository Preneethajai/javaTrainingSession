package com.te.javabasic.exception;

public class Bank {
	int amt;
	Bank(int amt){
		this.amt=amt;
	}
	public void withdraw(int p) {
		if(this.amt>p) {
			System.out.println("the amount for withdraw is "+p);
			this.amt-=p;
		}
		else {
			throw new InsufficientBalanceException("Insuffient Balance!!!!!!");
		}
	}


}

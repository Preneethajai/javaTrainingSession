package com.te.javabasic.abstratct;

public class User {

	public static void main(String[] args) {
		Car car=CarMain.getCar();
		Driver driver=new Driver();
		driver.details(car);
		//driver.details(CarMain.getCar());

	}

}

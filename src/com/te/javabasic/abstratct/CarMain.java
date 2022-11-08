package com.te.javabasic.abstratct;

import java.util.*;

public class CarMain {

	public static Car getCar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the car");
		String carName = scanner.next();
		if (carName.equalsIgnoreCase("audi")) {
			return new Audi();
		} else if (carName.equalsIgnoreCase("bmw")) {
			return new Bmw();
		}
		else {
			return null;
		}

	}

}

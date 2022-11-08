package com.te.javabasic.abstratct;

public interface Car {
	void accelarate();

	void brakes();

	void geer();

	default void airbag() {

	}
}

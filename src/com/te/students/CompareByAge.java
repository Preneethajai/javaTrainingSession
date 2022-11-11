package com.te.students;

import java.util.Comparator;

public class CompareByAge implements Comparator<Students> {

	@Override
	public int compare(Students o1, Students o2) {

		return o1.studentAge -  o2.studentAge;

	}
}

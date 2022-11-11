package com.te.students;

import java.util.Comparator;

public class CompareByName implements Comparator<Students> {

	@Override
	public int compare(Students o1, Students o2) {
		
		return o1.studentName.compareTo(o2.studentName);
	}

}

package com.te.students;

public class Students {
	int studentId;
	String studentName;
	int studentAge;
	int studentMark;

	public Students(int studentId, String studentName, int studentAge, int studentMark) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentMark = studentMark;
	}

	@Override
	public String toString() {
		return "Students [StudentId=" + studentId + ", StudentName=" + studentName + ", StudentAge=" + studentAge
				+ ", StudentMark=" + studentMark + "]";
	}

}

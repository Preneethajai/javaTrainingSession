package com.te.students.comparable;

public class Students implements Comparable<Students> {
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
		@Override
		public int compareTo(Students o) {
			return (this.studentAge) - o.studentAge ;
		}
}

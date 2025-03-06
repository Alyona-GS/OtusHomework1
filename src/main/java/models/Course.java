package models;

import java.util.Date;

public class Course {
	public String courseName;
	public Date startDate;

	public Course(String courseName, Date startDate) {
		this.courseName = courseName;
		this.startDate = startDate;
	}
}

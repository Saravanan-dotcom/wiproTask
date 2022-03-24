package com.data.StudentData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.data.model.Student;

public class StudentData {
	
	public List<Student> getAllStudents()
	{
		List<String> activities = new ArrayList<>();
		activities.add("read");
		activities.add("write");
		activities.add("Study");
		
		
		Student s1 = new Student("Ram", 1, 2.5, "male", activities);
		Student s2 = new Student("kavi", 2, 5.5, "Female", activities);
		Student s3 = new Student("Somu", 3, 6.5, "male", activities);
		Student s4 = new Student("Teja", 4, 7.5, "Female", activities);
		List<Student> studentList = Arrays.asList(s1,s2,s3,s4);
		
		return studentList;
		
	}

}

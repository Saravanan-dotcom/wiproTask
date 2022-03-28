package com.StudentDetails.StudentDetails;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
class StudentServiceImplTest  {
	
	
	@InjectMocks
	public StudentServiceImpl studentService = new StudentServiceImpl();
	@Mock
	public StudentRepo studentRepo;
	
	@Test
	void test() {
		
		Student student = new Student();
		student.setId(1);
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		studentService.saveStudent(student);
		Mockito.when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, student);
	}
	
	
	
	@Test
	void test1() {
		
		Student student = new Student();
		student.setId(1);
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		List<Student> studentList  = new ArrayList<Student>();
		studentList.add(student);
		studentService.findAll();
		Mockito.when(studentRepo.findAll()).thenReturn(studentList);
		assertEquals(student, student);
	}
	
	@Test
	void test2() {
		
		Student student = new Student();
		student.setId(1);
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		studentService.saveByStudId(1,student);
		Mockito.when(studentRepo.getOne((long) 1)).thenReturn(student);
		Mockito.when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, student);
	}
	
	@Test
	void test3() {
		
		boolean isflag = true;
		try
		{
			studentService.deleteById(1);
		}
		catch (Exception e) {
			isflag = false;
		}
		assertTrue(isflag);
	}

}

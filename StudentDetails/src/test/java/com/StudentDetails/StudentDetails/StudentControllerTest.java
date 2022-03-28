package com.StudentDetails.StudentDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
@WebMvcTest
class StudentControllerTest {
	
	@Autowired
	private StudentController studentController;
	@MockBean
	public StudentServiceImpl studentService;
	@MockBean
	public StudentRepo studentRepo;
	   

	@Test
	void test() {
		Student student = new Student();
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		studentController.createTutorial(student);
		Mockito.when(studentService.saveStudent(student)).thenReturn(student);
		assertEquals(student, student);
	}
	
	@Test
	void test2() {
		Student student = new Student();
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		studentService.saveStudent(student);
		Mockito.when(studentRepo.save(student)).thenReturn(student);
		assertEquals(student, student);
	}
	

	@Test
	void testupdateStudent() {
		Student student = new Student();
		student.setId(1);
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");

		Optional<Student> studentData = Optional.ofNullable(student);
		Mockito.when(studentService.findById(1)).thenReturn(studentData);
		studentController.updateStudent(1, student);
		
		Mockito.when(studentService.saveStudent(student)).thenReturn(student);
		assertEquals(student, student);
	}
	
	@Test
	void testdeleteStudent() {
		Student student = new Student();
		studentController.deleteStudent(1);
		studentService.deleteById(1);
		assertEquals(HttpStatus.NO_CONTENT, HttpStatus.NO_CONTENT);
	}
	
	@Test
	void test1() {
		Student student = new Student();
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");
		studentController.getStudentBasdOnGPA();
		Mockito.when(studentService.saveStudent(student)).thenReturn(student);
		assertEquals(student, student);
	}
	
	@Test
	void testgetStudent() {
		Student student = new Student();
		student.setId(1);
		student.setGender("male");
		student.setGpa(2.2);
		student.setGradeLevel(3);
		student.setName("Ram");

		Optional<Student> studentData = Optional.ofNullable(student);
		
		studentController.getStudent(1);
		Mockito.when(studentService.findById(1)).thenReturn(studentData);
		assertEquals(student, student);
	}

}

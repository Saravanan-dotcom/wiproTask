package org.Task.javaTask;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.data.StudentData.StudentData;
import com.data.model.Student;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		StudentData sd = new StudentData();
		//Consumer
		Consumer<List<Student>> t1 = s -> {
			System.out.println("Consumer Get list of Students");
	            for (int i = 0; i < s.size(); i++)
	                //list.set(i, 2 * list.get(i));
	            	System.out.println(s.get(i));
		};
		//Supplayer
		List<Student> studentList = sd.getAllStudents();
		
		for(Student std:studentList)
		{
			Supplier<Student> supplier =  () -> new Student(std);
			System.out.println("supplier------------------------"+supplier.get());
		}
		
		//predicate
		Predicate<Student> p = t3 ->  t3.getGradeLevel() > 3;
		//Function
		Function<Student, Student> f = s -> s;
		//predicate
		Predicate<Student> p2 = t3 ->  t3.getGpa() > 3.5;
		
		t1.accept(studentList);
		List<Student> collect = studentList.stream().filter(p).map(f).collect(Collectors.toList());
		System.out.println("Filter the student details based gradelevle-------------------"+collect);
        Map<String, Student> collect2 = studentList.stream().filter(s -> s.getGpa() > 3.5).collect(Collectors.toMap(Student::getName, Function.identity()));
		
		
		System.out.println("Filter the student details based Gpa-------------------"+collect2);
		}
}

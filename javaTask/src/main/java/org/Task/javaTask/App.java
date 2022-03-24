package org.Task.javaTask;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
		// TODO Auto-generated method stub
		
		StudentData sd = new StudentData();
		
		
		System.out.println();
		//List<Student> studentList = sd.getAllStudents();
		//Consumer
		Consumer<List<Student> > t1 = s -> {
			System.out.println("Task1-----------------");
	            for (int i = 0; i < s.size(); i++)
	                //list.set(i, 2 * list.get(i));
	            	System.out.println(s.get(i));
		};
		//Supplayer
		
		//predicate
		Predicate<Student> p = t3 ->  t3.getGradeLevel() > 3;
		//Function
		Function<Student, Student> f = s -> s;
		//predicate
		Predicate<Student> p2 = t3 ->  t3.getGpa() > 3.5;
		List<Student> studentList = sd.getAllStudents();
		t1.accept(studentList);
		List<Student> collect = studentList.stream().filter(p).map(f).collect(Collectors.toList());
		System.out.println("Task2-------------------"+collect);
        Map<String, Student> collect2 = studentList.stream().filter(s -> s.getGpa() > 3.5).collect(Collectors.toMap(Student::getName, Function.identity()));
		
		
		System.out.println("Task3-------------------"+collect2);
		}
}

package streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import streams.classes.Student;

public class Distinct {

	
	public static void main(String[] args) {
		
		name();
	}
	
	public static void name() {
		List<Student> students=new ArrayList<>();
		
		students.add(new Student(1, "mk", "mys", "kar"));
		students.add(new Student(1, "mk", "mys", "kar"));
		students.add(new Student(3, "mk", "mys", "kar"));
		students.add(new Student(4, "mk", "mys", "kar"));
		students.add(new Student(3, "mk", "mys", "kar"));
		
		
		students.stream().distinct().forEach(System.out::println);
	}

}

package streams.demo;

import java.util.ArrayList;
import java.util.List;

import streams.classes.Student;

public class Sorted {

	
	public static void main(String[] args) {
		
		name();
	}
	
	
	public static void name() {
		List<Student> students=new ArrayList<>();
		
		students.add(new Student(7, "mk", "mys", "kar"));
		students.add(new Student(1, "mk", "mys", "kar"));
		students.add(new Student(2, "mk", "mys", "kar"));
		students.add(new Student(3, "mk", "mys", "kar"));
		students.add(new Student(8, "mk", "mys", "kar"));
		students.add(new Student(5, "mk", "mys", "kar"));
		
		
//		students.stream().sorted().forEach(System.out::println);
		
		students.stream().sorted((x,x1)->x.getId()-x1.getId()).forEach(System.out::println);
	}

}

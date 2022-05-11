package streams.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("name", "slno", "address", "mobileNo");
		list.stream().forEach(System.out::println);
		System.out.println("___________________________________");
		list.parallelStream().forEach(System.out::println);
		System.out.println("___________________________________");
		Stream.of("name", "slno", "address", "mobileNo").forEach(System.out::println);
		System.out.println("___________________________________");
		Stream.of(list).forEach(System.out::println);
		
		int [] array= {45,55,88};
		Arrays.stream(array).forEach(System.out::println);
		Arrays.stream(array,1,2).forEach(System.out::println);
		
		
		
	
	}
}

package streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterDemo {

	
	public static void main(String[] args) {
//		normal();
		name1();
	}
	
	
	public static void normal() {
		List<String> list=Arrays.asList("mk","khan","viper","muteeq");
		
		Stream<String> stream = list.stream();
		Stream<String> map = stream.map(x->x.toUpperCase());
		Stream<String> filter = map.filter(x->x.startsWith("M"));
		
		filter.forEach(System.out::println);
		
	}
	
	
	public static void name() {
		String[] str = { "mk", "khan", "one" };
		String[] str1 = { "mk1", "khan1", "one1" };

		List<String[]> list = new ArrayList<>();
		list.add(str1);
		list.add(str);
		System.out.println(list);

		Stream<String[]> stream = list.stream();
		Stream<String> flatMap = stream.flatMap(x->Arrays.stream(x));
		Stream<String> map = flatMap.map(x->x.toUpperCase());
		Stream<String> filter = map.filter(x->x.startsWith("M"));
		filter.forEach(System.out::println);
		
		

//		list.stream().flatMap(x->Arrays.stream(x)).forEach(System.out::println);

	}
	
	
	public static void name1() {
		List<Integer> list=Arrays.asList(5,6,8,9,6,1);
		list.stream().map(x->x*5).filter(x->x%2==0).forEach(System.out::println);
	}

}

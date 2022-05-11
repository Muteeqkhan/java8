package streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo {

	public static void main(String[] args) {
//		normal1();
		name();
	}

	public static void normal() {
		List<String> list = Arrays.asList("name", "number");
		List<Integer> list2 = new ArrayList<>();
		Stream<String> stream = list.stream();
		System.out.println(stream);
		Stream<String[]> map = stream.map(x -> x.split("")); // this is returnning the stream of the stream
		Stream<String> flatMap2 = map.flatMap(x -> Arrays.stream(x));
		flatMap2.forEach(System.out::println);
		System.out.println(flatMap2);
	};

	public static void normal1() {
		List<List<Integer>> list = new ArrayList<>();
		;
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(4);
		arrayList.add(55);
		list.add(arrayList);

		ArrayList<Integer> arrayList1 = new ArrayList<>();
		arrayList1.add(45);
		arrayList1.add(5264);
		list.add(arrayList1);
		System.out.println(list);

		Stream<List<Integer>> stream = list.stream();
		Stream<Integer> flatMap = stream.flatMap(x -> x.stream());
		flatMap.forEach(System.out::println);

		// .Stream flatMap = stream.flatMap(x->);
		// flatMap.forEach(System.out::println);

	}

	public static void name() {
		String[] str = { "mk", "khan", "one" };
		String[] str1 = { "mk1", "khan1", "one1" };

		List<String[]> list = new ArrayList<>();
		list.add(str1);
		list.add(str);
		System.out.println(list);

		Stream<String[]> stream = list.stream();
//		here while mapping we will get the two streams so we wil use the flat map to make that as a singlw stream
		Stream<Stream<String>> map = stream.map(x->Arrays.stream(x));
		Stream<String> flatMap = stream.flatMap(x->Arrays.stream(x));
		
		map.forEach(System.out::println);

//		list.stream().flatMap(x->Arrays.stream(x)).forEach(System.out::println);

	}

}

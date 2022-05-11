package streams.demo;

import java.util.Arrays;
import java.util.List;

public class Limit {

	
	public static void main(String[] args) {
		name1();
	}
	
	public static void name1() {
		List<Integer> list=Arrays.asList(5,6,8,9,6,1,8,8,9,9,6,7,5,6,8,9,6,1,8,8,9,9,6,7);
		list.stream().limit(10)
		.map(x->x*5).filter(x->x%2==0).forEach(System.out::println);
	}

}

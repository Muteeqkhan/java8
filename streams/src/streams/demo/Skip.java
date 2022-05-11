package streams.demo;

import java.util.Arrays;
import java.util.List;

public class Skip {

	public static void main(String[] args) {
		name2();	}
	
	public static void name1() {
		List<String> list=Arrays.asList("1","2","3","4","5","6","7","8");
		list.stream().skip(5)
		.limit(2)
		.forEach(System.out::println);
	}
	
	public static void name2() {
		List<Integer> list=Arrays.asList(5,6,8,9,6,1);
		list.stream().map(x->x*5).filter(x->x%2==0).
		skip(2). 
		forEach(System.out::println);
	}


}

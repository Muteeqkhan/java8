package streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapDemo {

	public static void main(String[] args) {
		
		MapDemo mapDemo = new MapDemo();
		mapDemo.normal();
		mapDemo.advance  ();
	}
	
	public void normal() {
		List<Integer> list=Arrays.asList(4,5,6,7);
		List<Integer> list2=new ArrayList<>();
		System.out.println(list);
		
		Stream<Integer> stream = list.stream();
		Stream<Integer> map = stream.map(x->x+5);
		map.forEach(x->{
			list2.add(x);
			});
		System.out.println(list2);
	}
	
	
	public void advance() {
		List<Integer> list=Arrays.asList(4,5,6,7);
		List<Integer> list2=new ArrayList<>();
		
		list.stream().map(x->x+5).
		map(x->x+3).
		forEach(list2::add);
		System.out.println(list+"   "+ list2);
	}
	

}

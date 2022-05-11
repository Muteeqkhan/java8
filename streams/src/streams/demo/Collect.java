package streams.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streams.classes.MonCom;
import streams.classes.MonthyIncomeReduce;
import streams.classes.Student;

public class Collect {

	
	
	public static void main(String[] args) {
		name1();
	}
	
	
	public static void name() {

		
List<Student> students=Arrays.asList(new Student(1, "khan", "skc", "mys"),new Student(2, "mk", "csk", "blr")
		,new Student(3, "ak", "skc", "mys"),new Student(1, "viper", "kkr", "blr"));
		
		
//.collect(Collectors.toSet());
//collect.forEach(x->System.out.println(x.hashCode()));
students.stream().forEach(x->System.out.println(x.hashCode()));
		}
	
	
	public static void name1() {
		List<MonthyIncomeReduce> incomeReduces=new ArrayList<>();
		
		
		incomeReduces.add(new MonthyIncomeReduce("jan", 1455000));
		incomeReduces.add(new MonthyIncomeReduce("feb", 1115000));
		incomeReduces.add(new MonthyIncomeReduce("mar", 785000));
		incomeReduces.add(new MonthyIncomeReduce("apr", 88815000));
		
		
//		incomeReduces.stream().collect(Collectors.maxBy(Comparator.comparing(MonthyIncomeReduce::getSalary)));
		Optional<MonthyIncomeReduce> collect = incomeReduces.stream().collect(Collectors.maxBy((x,y)->(int)x.getSalary()-(int)y.getSalary()));
		System.out.println(collect.get());
		
	}
}

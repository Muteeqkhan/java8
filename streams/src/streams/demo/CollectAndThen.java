package streams.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.classes.MonthyIncomeReduce;

public class CollectAndThen {

	
	public static void main(String[] args) {
		name1();
	}
	
	public static void name1() {
		List<MonthyIncomeReduce> incomeReduces=new ArrayList<>();
		
		
		incomeReduces.add(new MonthyIncomeReduce("jan", 1455000));
		incomeReduces.add(new MonthyIncomeReduce("feb", 1115000));
		incomeReduces.add(new MonthyIncomeReduce("mar", 785000));
		incomeReduces.add(new MonthyIncomeReduce("apr", 88815000));
		
		
//		incomeReduces.stream().collect(Collectors.maxBy(Comparator.comparing(MonthyIncomeReduce::getSalary)));
		String collect = incomeReduces.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(MonthyIncomeReduce::getSalary)), 
				(Optional<MonthyIncomeReduce> o)->o.isPresent()? o.get().getMonthName():"none"));
		System.out.println(collect);
		 
	}
}

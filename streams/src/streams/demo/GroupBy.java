package streams.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import streams.classes.MonthyIncomeReduce;

public class GroupBy {
	public static void name1() {
		List<MonthyIncomeReduce> incomeReduces=new ArrayList<>();
		
		
		incomeReduces.add(new MonthyIncomeReduce("jan", 1455000));
		incomeReduces.add(new MonthyIncomeReduce("feb", 1115000));
		incomeReduces.add(new MonthyIncomeReduce("mar", 785000));
		incomeReduces.add(new MonthyIncomeReduce("apr", 88815000));
		incomeReduces.add(new MonthyIncomeReduce("jan", 88815000));
		incomeReduces.add(new MonthyIncomeReduce("apr", 88815000));
	
		
		Map<String, List<MonthyIncomeReduce>> collect = incomeReduces.stream().collect(Collectors.groupingBy(MonthyIncomeReduce::getMonthName));
		Set<String> keySet = collect.keySet();
		for (String string : keySet) {
			System.out.println(string+collect.get(string));
		}
	
	
	}
	
	public static void main(String[] args) {
		name1();
	}
}

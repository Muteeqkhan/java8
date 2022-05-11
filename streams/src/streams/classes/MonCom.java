package streams.classes;

import java.util.Comparator;

public class MonCom implements Comparator<MonthyIncomeReduce>{

	@Override
	public int compare(MonthyIncomeReduce o1, MonthyIncomeReduce o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getSalary()-o2.getSalary());
	}

	
}

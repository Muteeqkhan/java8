package streams.classes;

public class MonthyIncomeReduce {

	
	private String monthName;
	private int salary;
	public MonthyIncomeReduce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthyIncomeReduce(String monthName, int salary) {
		super();
		this.monthName = monthName;
		this.salary = salary;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "MonthyIncomeReduce [monthName=" + monthName + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
}

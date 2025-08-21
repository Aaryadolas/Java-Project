package erp.com;

import java.util.ArrayList;

abstract class Employee{
	
	private int id;
	private String name;
	
	public Employee(String name,int id) {
		this.name = name;
		this.id =id;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	public abstract double calculateSalary();
	
	@Override
	public String toString() {
		return "Employee[name="+name+", id="+id+",salary="+calculateSalary()+"]";
	}
	
}
class FullTimeEmployee extends Employee{
	
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id, double monthlySalary) {
		super(name,id);
		this.monthlySalary= monthlySalary;
	}
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}

class PartTimeEmployee extends Employee{
	
	private int hours_work;
	private double hourly_rate;
	
	public PartTimeEmployee(String name,int id,int hours_work,double hourly_rate) {
		super(name,id);
		this.hours_work = hours_work;
		this.hourly_rate = hourly_rate;
	}
	
	@Override
	public double calculateSalary() {
		return hours_work * hourly_rate;
	}
}


class PayrollSystem{
	private ArrayList<Employee> employeeList;
	
	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
	
	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for(Employee employee : employeeList) {
			if(employee.getId()==id) {
				employeeToRemove=employee;
				break;
			}
		}
		if(employeeToRemove !=null) {
			employeeList.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee() {
		for(Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
}
public  class Main {

	public static void main(String[] args) {
		PayrollSystem  payroll = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Raj",101,70000);
		PartTimeEmployee emp2 = new PartTimeEmployee("Ankit",102,40,100);
		
		FullTimeEmployee emp3 = new FullTimeEmployee("Priya", 103, 85000);
		 PartTimeEmployee emp4 = new PartTimeEmployee("Karan", 104, 30, 120);
			
		payroll.addEmployee(emp1);
		payroll.addEmployee(emp2);
		payroll.addEmployee(emp3);
		payroll.addEmployee(emp4);
		
		System.out.println("initial Employee values");
		payroll.displayEmployee();
		
		System.out.println("Removing Employees");
		payroll.removeEmployee(101);
		
		System.out.println("Remaining Employees Details");
		payroll.displayEmployee();
	}

}

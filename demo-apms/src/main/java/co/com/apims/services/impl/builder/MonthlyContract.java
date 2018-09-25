package co.com.apims.services.impl.builder;

import co.com.apims.model.Employee;

public class MonthlyContract extends Contract {

	private static final int _12 = 12;
	private Employee employee;
	
	public MonthlyContract(Employee employee) {
      this.employee = employee;
	}
	
	@Override
	public Employee getEmployee() {		
		return employee;
	}

	@Override
	public Double calcaulateSalary() {
		return (double) (employee.getMonthlySalary() * _12);
	}
	
}

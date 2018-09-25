package co.com.apims.services.impl.builder;

import co.com.apims.model.Employee;

public class HourlyContract extends Contract {

	private static final int _12 = 12;
	private static final int _120 = 120;
	
	private Employee employee;
		
	public HourlyContract(Employee employee) {
	 this.employee = employee;
	}
	
	@Override
	public Double calcaulateSalary() {
		return  (double) (_120 * employee.getHourlySalary() * _12);		
	}

	@Override
	public Employee getEmployee() {
		return employee;
	}
	
}

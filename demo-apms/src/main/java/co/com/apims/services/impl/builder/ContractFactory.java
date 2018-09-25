package co.com.apims.services.impl.builder;

import co.com.apims.model.Employee;

public class ContractFactory {

	private static final String MONTHLY_SALARY_EMPLOYEE = "MonthlySalaryEmployee";
	private static final String HOURLY_SALARY_EMPLOYEE = "HourlySalaryEmployee";
	
	private ContractFactory() {
		 super();
		}
	
	public static Contract getContract(Employee employee) {
		if(HOURLY_SALARY_EMPLOYEE.equals(employee.getContractTypeName())) {
			return new HourlyContract (employee);
		}else if(MONTHLY_SALARY_EMPLOYEE.equals(employee.getContractTypeName())) {
			return new MonthlyContract (employee);
		}else {
			   return null; 
		}	
	}
		
}

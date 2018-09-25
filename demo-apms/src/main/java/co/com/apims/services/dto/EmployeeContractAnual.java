package co.com.apims.services.dto;

import co.com.apims.services.impl.builder.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeContractAnual {

	private Integer id;
	
	private String name;
	
	private Integer roleId;
	
	private String roleName;
	
	private String roleDescription;
	
	private Double salary;
	
	public EmployeeContractAnual(Contract contract){
		this.id = contract.getEmployee().getId();
		this.name = contract.getEmployee().getName();
		this.roleId =contract.getEmployee().getRoleId();
		this.roleName =contract.getEmployee().getRoleName();
		this.roleDescription = contract.getEmployee().getRoleDescription();
		this.salary = contract.calcaulateSalary();
	}
}

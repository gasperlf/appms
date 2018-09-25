package co.com.apims.services;

import co.com.apims.services.dto.EmployeeContractAnual;
import reactor.core.publisher.Flux;

public interface ContractService {
	
	public Flux<EmployeeContractAnual> getAll();
	public Flux<EmployeeContractAnual> getEmployeeInformarion(Integer id);
}

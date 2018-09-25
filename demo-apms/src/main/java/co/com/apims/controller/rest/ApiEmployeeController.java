package co.com.apims.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.apims.services.ContractService;
import co.com.apims.services.dto.EmployeeContractAnual;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api/employees")
public class ApiEmployeeController {

	private final ContractService contractService;
		
	@GetMapping(path="/salary/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Flux<EmployeeContractAnual> getEmployeeSalaries(){
		return contractService.getAll();
	}
	
	@GetMapping(path="/salary/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Flux<EmployeeContractAnual> getEmployee(@PathVariable(name="id") Integer id){
		return contractService.getEmployeeInformarion(id);
	}
	
}

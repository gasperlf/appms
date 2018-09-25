package co.com.apims.services.impl;

import org.springframework.stereotype.Service;

import co.com.apims.datasource.ConsumeApiServiceEmployee;
import co.com.apims.services.ContractService;
import co.com.apims.services.dto.EmployeeContractAnual;
import co.com.apims.services.impl.builder.ContractFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class ContractServiceImpl implements ContractService {

	private final ConsumeApiServiceEmployee consumeApiServiceEmployee;

	public ContractServiceImpl(ConsumeApiServiceEmployee consumeApiServiceEmployee) {
		this.consumeApiServiceEmployee = consumeApiServiceEmployee;
	}

	@Override
	public Flux<EmployeeContractAnual> getAll() {
		return this.consumeApiServiceEmployee.getListEmployee()
				.map(ContractFactory::getContract)
				.map(EmployeeContractAnual::new)
				.subscribeOn(Schedulers.elastic());
	}

	@Override
	public Flux<EmployeeContractAnual> getEmployeeInformarion(Integer id) {

		return this.consumeApiServiceEmployee.getListEmployee()
				.filter(employee -> employee.getId().equals(id))
				.map(ContractFactory::getContract)
				.map(EmployeeContractAnual::new)
				.subscribeOn(Schedulers.elastic());
	}

}

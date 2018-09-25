package co.com.apims.datasource;

import co.com.apims.model.Employee;
import reactor.core.publisher.Flux;

public interface ConsumeApiServiceEmployee {

	public Flux<Employee> getListEmployee();
}

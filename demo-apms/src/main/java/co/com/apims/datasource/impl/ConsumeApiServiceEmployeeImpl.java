package co.com.apims.datasource.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.com.apims.datasource.ConsumeApiServiceEmployee;
import co.com.apims.model.Employee;
import reactor.core.publisher.Flux;

@Service
public class ConsumeApiServiceEmployeeImpl implements ConsumeApiServiceEmployee{

	private final String urlApiEmployee;
	private final WebClient webClient;
	
	public ConsumeApiServiceEmployeeImpl(@Value("${api.remote.datasource.url}") String url,WebClient webClient) {
		this.urlApiEmployee = url;
		this.webClient =webClient;
	}
	
	@Override
	public Flux<Employee> getListEmployee(){
		return this.webClient.get()
		.uri(urlApiEmployee)
		.retrieve()
		.bodyToFlux(Employee.class);
	}
}

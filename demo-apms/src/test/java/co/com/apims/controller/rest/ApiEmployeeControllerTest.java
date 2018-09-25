package co.com.apims.controller.rest;

import static co.com.apims.utils.TestUtil.retrieveBody;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.BodyContentSpec;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.apims.ContextTest;
import co.com.apims.datasource.impl.ConsumeApiServiceEmployeeImpl;
import co.com.apims.model.Employee;
import co.com.apims.services.dto.EmployeeContractAnual;
import co.com.apims.services.impl.builder.Contract;
import co.com.apims.services.impl.builder.ContractFactory;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ApiEmployeeControllerTest extends ContextTest{

	@Autowired
    private WebTestClient webTestClient;
	
	@MockBean
	private ConsumeApiServiceEmployeeImpl consumeApiServiceEmployeeImpl;
	
	private static ObjectMapper mapper;
	
	@BeforeClass
	public static void setUp() {
		mapper = new ObjectMapper();
	}
			
	@Test
	public void shouldAllEmployeesAnnualSalary()throws Exception{
		
		when(this.consumeApiServiceEmployeeImpl.getListEmployee()).thenReturn(createMockDataEmployees());
		
		ResponseSpec responseSpec = this.webTestClient.get()			
				.uri("/api/employees/salary/")
				.exchange();
		
		BodyContentSpec bodyContentSpec =responseSpec.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody();
		
		bodyContentSpec.consumeWith(response->Assertions.assertThat(response.getResponseBody()).isNotNull());
		bodyContentSpec.consumeWith(response-> log.info("{}",response));
	}
	
	@Test
	public void shouldEmployeeAnnualSalary()throws Exception{
		
		when(this.consumeApiServiceEmployeeImpl.getListEmployee()).thenReturn(createMockDataEmployees());
		
		ResponseSpec responseSpec = this.webTestClient.get()			
				.uri("/api/employees/salary/1")
				.exchange();
		
		BodyContentSpec bodyContentSpec =responseSpec.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody();
		
		bodyContentSpec.consumeWith(response->Assertions.assertThat(response.getResponseBody()).isNotNull());
		bodyContentSpec.consumeWith(response-> log.info("{}",response));
	}
	
	@Test
	public void shouldEmployeeAnnualSalaryX()throws Exception{
		
		when(this.consumeApiServiceEmployeeImpl.getListEmployee()).thenReturn(createMockDataEmployees());
		
		List<EmployeeContractAnual> list= this.webTestClient.get()			
				.uri("/api/employees/salary/1")
				.exchange()
				.expectBodyList(EmployeeContractAnual.class)
				.hasSize(1)
				.returnResult()
				.getResponseBody();
		
		Assertions.assertThat(list).isNotNull();
		Assertions.assertThat(list.get(0)).isNotNull();
		Assertions.assertThat(list.get(0).getSalary()).isNotNull();
		
		Assertions.assertThat(list.get(0).getSalary()).isEqualTo(86400000);
	}
	
	private Flux<Employee> createMockDataEmployees() throws JsonParseException, JsonMappingException, IOException{
		final String data = retrieveBody("data_employee_list.json");
		List<Employee> list = mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
		return Flux.fromIterable(list);
	}
	
	private List<Employee> getMockDataEmployees() throws JsonParseException, JsonMappingException, IOException{
		final String data = retrieveBody("data_employee_list.json");
		return mapper.readValue(data, mapper.getTypeFactory().constructCollectionType(List.class, Employee.class));

	}
	
	@Test
	public void createContractFactory()throws Exception{
		List<Employee> list = getMockDataEmployees();
		Employee employeeNull = list.get(0);
		employeeNull.setContractTypeName("DaysOFF");
	   
		Contract contract=ContractFactory.getContract(employeeNull);
	   Contract contractGood=ContractFactory.getContract(list.get(1));
	   
	   Assertions.assertThat(contract).isNull();
	   Assertions.assertThat(contractGood).isNotNull();   
	   
	}
}

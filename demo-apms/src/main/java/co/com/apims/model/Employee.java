package co.com.apims.model;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "contractTypeName", "roleId", "roleName", "roleDescription", "hourlySalary",
		"monthlySalary" })
public class Employee {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("contractTypeName")
	private String contractTypeName;
	@JsonProperty("roleId")
	private Integer roleId;
	@JsonProperty("roleName")
	private String roleName;
	@JsonProperty("roleDescription")
	private String roleDescription;
	@JsonProperty("hourlySalary")
	private Integer hourlySalary;
	@JsonProperty("monthlySalary")
	private Integer monthlySalary;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<>();

	public Employee() {
		super();
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("contractTypeName")
	public String getContractTypeName() {
		return contractTypeName;
	}

	@JsonProperty("contractTypeName")
	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	@JsonProperty("roleId")
	public Integer getRoleId() {
		return roleId;
	}

	@JsonProperty("roleId")
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@JsonProperty("roleName")
	public String getRoleName() {
		return roleName;
	}

	@JsonProperty("roleName")
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonProperty("roleDescription")
	public String getRoleDescription() {
		return roleDescription;
	}

	@JsonProperty("roleDescription")
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@JsonProperty("hourlySalary")
	public Integer getHourlySalary() {
		return hourlySalary;
	}

	@JsonProperty("hourlySalary")
	public void setHourlySalary(Integer hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	@JsonProperty("monthlySalary")
	public Integer getMonthlySalary() {
		return monthlySalary;
	}

	@JsonProperty("monthlySalary")
	public void setMonthlySalary(Integer monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}

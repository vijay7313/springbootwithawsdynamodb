package com.aws.service;

import java.util.List;

import com.aws.employeedto.EmployeeDTO;
import com.aws.model.EmployeeModel;

public interface EmployeeService {

	List<EmployeeModel> getAllEmployees();

	EmployeeModel createEmployee(EmployeeModel Employee);
	
	EmployeeDTO getEmployeeById(String userId);
	
	void deleteEmployeeById(String employeeId);
	
	EmployeeModel updateEmployee(String employeeId,EmployeeModel Employee);
}

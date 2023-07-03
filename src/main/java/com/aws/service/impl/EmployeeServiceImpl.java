package com.aws.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.aws.dao.EmployeeDAO;
import com.aws.employeedto.EmployeeDTO;
import com.aws.model.EmployeeModel;
import com.aws.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired(required=true)
	ModelMapper modelMapper;

	@Override
	public List<EmployeeModel> getAllEmployees() {
		return (List<EmployeeModel>) employeeDAO.findAll();
	}

	public EmployeeModel createEmployee(EmployeeModel employee) {

		return employeeDAO.save(employee);
	}

	public EmployeeDTO getEmployeeById(String employeeId) {
		
		EmployeeModel employee = employeeDAO.findById(employeeId)
				.orElseThrow(() -> new com.aws.Exception.ResourceNotFoundException("User", "id", employeeId));
		
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

	
	public void deleteEmployeeById(String employeeId) {
		
		EmployeeModel employee = employeeDAO.findById(employeeId)
				.orElseThrow(() -> new com.aws.Exception.ResourceNotFoundException("User", "id", employeeId));
		
		employeeDAO.delete(employee);
	}

	@Override
	public EmployeeModel updateEmployee(String employeeId, EmployeeModel employee) {
		EmployeeModel employeeDetail = employeeDAO.findById(employeeId)
				.orElseThrow(() -> new com.aws.Exception.ResourceNotFoundException("User", "id", employeeId));
		
		return employeeDAO.save(employee);
	}

	
}

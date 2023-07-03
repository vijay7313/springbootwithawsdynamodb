package com.aws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.employeedto.EmployeeDTO;
import com.aws.model.EmployeeModel;
import com.aws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public ResponseEntity<?> getAllEmployee() {
		List<EmployeeModel> employee = employeeService.getAllEmployees();
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String employeeId) {
		EmployeeDTO employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<?> createUser(@RequestBody EmployeeModel employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>("Employee Created successfully!", HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);

	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") String employeeId,
			@RequestBody EmployeeModel employee) {
		employeeService.updateEmployee(employeeId, employee);
		return new ResponseEntity<>("Employee successfully updated!", HttpStatus.OK);
	}

}

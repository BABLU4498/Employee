package com.cg.ems.controller;

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

import com.cg.ems.entity.Employee;
import com.cg.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	private EmployeeService employeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// list of all employees
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
	//create an employee
	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		Employee emp= employeeService.createEmployee(employee);
		
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	//getEmployeeeById
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		
		Employee emp= employeeService.getEmployeeById(id);
		
		return  emp != null ? ResponseEntity.ok(emp): ResponseEntity.notFound().build();
	}
	
	//delete Employee
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable long id){
		 employeeService.deleteEmployee(id);
	}
	
	//update Employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
		
		  Employee emp= employeeService.updateEmployee(id, employee);
		  employee.setId(id);
			  return emp !=null ? ResponseEntity.ok(emp): ResponseEntity.badRequest().body(emp);
		  
		 
	}
	
	
	
	

}

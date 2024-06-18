package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;


public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee createEmployee(Employee employee);
	Employee updateEmployee(long id, Employee employee);
	void deleteEmployee(long id);
	Employee getEmployeeById(long id);
	

}

package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entity.Employee;
import com.cg.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		Employee emp=employeeRepository.save(employee);
		return emp;
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		
		Employee emp=employeeRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException( "employee not found with ID :"+id));
		
			emp.setName(employee.getName());
			emp.setDepartment(employee.getDepartment());
			
		employeeRepository.save(emp);
		return employee;
	}
		
	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee employee = employeeRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("employee not found eith Id:"+id));
		return employee;
	}

}

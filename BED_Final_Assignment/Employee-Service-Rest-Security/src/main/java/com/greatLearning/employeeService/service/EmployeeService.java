package com.greatLearning.employeeService.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatLearning.employeeService.entity.Employee;
import com.greatLearning.employeeService.entity.Role;
import com.greatLearning.employeeService.entity.User;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	public List<Employee> searchByFirstName(String firstName);
	
	//public List<Employee> sortByFirstNameAsc();
	public List<Employee>getEmployeesCustomSortedByFirstName(Direction direction);
	
	public User saveUser(User user);
	public Role saveRole(Role role);
}

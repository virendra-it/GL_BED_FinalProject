 package com.greatLearning.employeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.greatLearning.employeeService.dao.EmployeeRepository;
import com.greatLearning.employeeService.entity.Employee;
import com.greatLearning.employeeService.service.EmployeeServiceImpl;

@SpringBootApplication
@Component
public class EmployeeService implements CommandLineRunner {
@Autowired
EmployeeRepository employeeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1=new Employee();
		e1.setFirstName("Sanjay");
		e1.setLastName("Dutt");
		e1.setEmail("sanjay@gmail.com");
		employeeRepository.save(e1);
	}
}
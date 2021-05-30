package com.gopalsoft.application.service;

import java.util.List;

import com.gopalsoft.application.model.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee e);

	List<Employee> getAllEmployees();

	Employee getOneEmployee(Integer empId);

	void updateOneEmployee();
	
	void updateEmployeeJPQL(Employee emp);

	void deleteOneEmployee(Integer empId);
}

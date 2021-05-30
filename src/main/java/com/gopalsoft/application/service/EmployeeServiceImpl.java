package com.gopalsoft.application.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopalsoft.application.customexception.EmployeeNotFoundException;
import com.gopalsoft.application.model.Employee;
import com.gopalsoft.application.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Integer saveEmployee(Employee e) {
		System.out.println(e);
		
		/*
		 * UUID uuid=UUID.randomUUID(); System.out.println(uuid);
		 */
		
		
//		Random random =new Random();
//		Integer empid=random.nextInt(1000);
//		e.setEmpId(empid);
		
		
		Integer empId=employeeRepository.save(e).getEmpId();
		return empId;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeesList=employeeRepository.findAll();
		return employeesList;
	}

	@Override
	public Employee getOneEmployee(Integer empId) {
	Optional<Employee> opt=employeeRepository.findById(empId);
	Employee emp=opt.orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found!"));
		return emp;
	}

	@Override
	public void updateOneEmployee() {
		//same as save method

	}

	@Override
	public void deleteOneEmployee(Integer empId) {
		Employee emp=getOneEmployee(empId);
		employeeRepository.delete(emp);
	}

	@Override
	public void updateEmployeeJPQL(Employee emp) {
		employeeRepository.setEmpInfoById(emp.getEmpName(), emp.getEmpLastName(), emp.getEmpEmail(), emp.getEmpMobNumber(), emp.getEmpId());
		
	}

}

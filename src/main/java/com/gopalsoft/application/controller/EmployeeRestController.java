package com.gopalsoft.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopalsoft.application.model.Employee;
import com.gopalsoft.application.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeRestController {
@Autowired
private IEmployeeService employeeService;

  @PostMapping("/")
  public ResponseEntity<String>  saveEmployee(@RequestBody Employee employee){
	  
	  
	  Integer empId=employeeService.saveEmployee(employee);
	  
	  return new ResponseEntity<String>("Employee ID '"+empId+"' is saved successfully",HttpStatus.OK);
	  
	  
  }

  
  @GetMapping("/")
  public ResponseEntity<List<Employee>>  getAllEmployees(){
	  System.out.println("get all employees");
	  
	  List<Employee> empList=employeeService.getAllEmployees();
	  System.out.println(" all employees :"+empList);
	  
	  return new  ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	  
	  
  }
  
  
  @GetMapping("/{empid}")
  public ResponseEntity<Employee>  getOneEmployee(@PathVariable Integer empid){
	  
	  
	  Employee emp=employeeService.getOneEmployee(empid);
	  
	  return new  ResponseEntity<Employee>(emp,HttpStatus.OK);
	  
	  
  }
  
  
  @DeleteMapping("/{empid}")
  public ResponseEntity<String>  deleteOneEmployee(@PathVariable Integer empid){
	  
	  
	  employeeService.deleteOneEmployee(empid);
	  System.out.println("Employee ID '"+empid+"' is deleted");
	  
	  
	  return new  ResponseEntity<String>("Employee ID '"+empid+"' is deleted",HttpStatus.OK);
	  
	  
  }
  
  
  @PutMapping("/{id}")
  public ResponseEntity<String>  updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
	  
	  Employee empdb=employeeService.getOneEmployee(id);
	  empdb.setEmpName(employee.getEmpName());
	  empdb.setEmpLastName(employee.getEmpLastName());
	  empdb.setEmpEmail(employee.getEmpEmail());
	  empdb.setEmpMobNumber(employee.getEmpMobNumber());
//	  empdb.setEmpSal(employee.getEmpSal());
//	  empdb.setEmpDept(employee.getEmpDept());
//	  
//	  
//	  Integer empId=employeeService.saveEmployee(employee);
	  
	  employeeService.updateEmployeeJPQL(empdb);
	  
	  return new ResponseEntity<String>("Employee ID '"+id+"' is updated successfully",HttpStatus.OK);
	  
	  
  }

}

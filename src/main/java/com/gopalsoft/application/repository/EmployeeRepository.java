package com.gopalsoft.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gopalsoft.application.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Modifying
	@Query("update Employee u set u.empName = ?1, u.empLastName = ?2,u.empEmail = ?3, u.empMobNumber=?4 where u.empId = ?5")
	void setEmpInfoById(String empName, String empLastName, String empEmail,Long empMobNumber,Integer empId);

}
	
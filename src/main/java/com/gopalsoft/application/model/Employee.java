package com.gopalsoft.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Employee")  // usable for JPQL query
@Table(name = "employee")
public class Employee {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)   //AUTO,IDENTITY,SEQUENCE,TABLE
	//if not using generator ,then manually need to send
	//@GeneratedValue //will use db generator if there is
	@Column(name="empid",updatable=true,nullable=false)
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;
	
	
	@Column(name = "emplastname")
	private String empLastName;
	
	@Column(name = "empemail")
	private String empEmail;
	
	@Column(name = "empmobnumber")
	private Long empMobNumber;
	
//	@Column(name = "empsal")
//	private Double empSal;
//	
//	@Column(name = "empdept")
//	private String empDept;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Long getEmpMobNumber() {
		return empMobNumber;
	}

	public void setEmpMobNumber(Long empMobNumber) {
		this.empMobNumber = empMobNumber;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empLastName=" + empLastName + ", empEmail="
				+ empEmail + ", empMobNumber=" + empMobNumber + "]";
	}


//	public Double getEmpSal() {
//		return empSal;
//	}
//
//	public void setEmpSal(Double empSal) {
//		this.empSal = empSal;
//	}
//
//	public String getEmpDept() {
//		return empDept;
//	}
//
//	public void setEmpDept(String empDept) {
//		this.empDept = empDept;
//	}

	
}

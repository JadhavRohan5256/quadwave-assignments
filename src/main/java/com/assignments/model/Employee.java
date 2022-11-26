package com.assignments.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class Employee {
	@Id
	@Column(name="employee_id")
	private int empId;
	
	@Column(name="employee_name")
	private String empName;
	
	@Column(name="employee_birth_date")
	private String empBirthDate;
	
	@Column(name="employee_experience")
	private int empExperience;
	
	@Column(name="employee_designation")
	private String empDesignation;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpBirthDate() {
		return empBirthDate;
	}
	public void setEmpBirthDate(String empBirthDate) {
		this.empBirthDate = empBirthDate;
	}
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empBirthDate=" + empBirthDate
				+ ", empExperience=" + empExperience + ", empDesignation=" + empDesignation + "]";
	}
	
	
}

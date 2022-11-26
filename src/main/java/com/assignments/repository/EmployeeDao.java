package com.assignments.repository;

import java.util.List;

import com.assignments.model.Employee;

public interface EmployeeDao {
	public boolean save(Employee employe);
	public List<Employee> search(String pattern);
	public List<Employee> list();
}

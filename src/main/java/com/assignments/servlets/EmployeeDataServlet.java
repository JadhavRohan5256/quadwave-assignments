package com.assignments.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignments.model.Employee;
import com.assignments.service.EmployeeService;
import com.assignments.utils.Helper;
import com.google.gson.Gson;

@WebServlet("/employees")
public class EmployeeDataServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		// thread sleep for spinner demo purpose 
		Helper.sleep(3000);
		EmployeeService employeeService = new EmployeeService();
		List<Employee> result = employeeService.list();
		System.out.println(result);
		out.print(gson.toJson(result));
	}
}

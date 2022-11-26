package com.assignments.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignments.model.Employee;
import com.assignments.repository.EmployeeDao;
import com.assignments.service.EmployeeService;
import com.assignments.utils.Helper;
import com.assignments.utils.Message;
import com.google.gson.Gson;

@WebServlet("/employee-data")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// thread sleep for loading spinner demo
		Helper.sleep(3000);
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		int empId = 0;
		if(!req.getParameter("empId").isEmpty()) {
			empId = Integer.parseInt(req.getParameter("empId"));
		}
		int empExperience = 0;
		if(!req.getParameter("empExperience").isEmpty()) {
			empExperience = Integer.parseInt(req.getParameter("empExperience"));			
		}
		
		String empName =  req.getParameter("empName");
		String empBirthDate = req.getParameter("empBirthDate");
		String empDesignation = req.getParameter("empDesignation");
		
		if(empId <= 0 || empName.isEmpty() || empBirthDate.isEmpty() || empExperience < 0 || empDesignation.isEmpty()) {
			Message message = new Message("error-message", "all fields are required!");
			out.print(gson.toJson(message));
			return;
		}
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpBirthDate(empBirthDate);
		employee.setEmpExperience(empExperience);
		employee.setEmpDesignation(empDesignation);

		EmployeeDao service = new EmployeeService();
		//	inserting data 
		boolean result = service.save(employee);
		if(result) {
			Message message = new Message("success-message", "successfully added employee");
			out.print(gson.toJson(message));
		}
		else {
			Message message = new Message("error-message", "something went wrong");
			out.print(gson.toJson(message));
		}
	}
}

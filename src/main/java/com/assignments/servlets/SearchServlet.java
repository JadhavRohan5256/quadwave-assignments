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

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// thread sleep for spinner demo
		Helper.sleep(3000);
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		EmployeeService employeeService = new EmployeeService();
		String search  = req.getParameter("search");
		List<Employee> result = employeeService.search(search);
		out.print(gson.toJson(result));
	}
}

package com.assignments.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.assignments.model.Employee;
import com.assignments.repository.EmployeeDao;
import com.assignments.utils.HibernateFactory;

public class EmployeeService implements EmployeeDao{
	private final SessionFactory sessionFactory = HibernateFactory.getFactory();
	
	public boolean save(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	public List<Employee> search(String pattern) {
		List<Employee> list = null;
		Session session = sessionFactory.openSession();
		String query = "from Employee where empName like :pattr or empDesignation like :pattr";
		Query createQuery = session.createQuery(query);
		createQuery.setParameter("pattr", "%" + pattern + "%");
		list = createQuery.list();
		session.close();
		return list;
	}

	public List<Employee> list() {
		List<Employee> list = null;
		Session session = sessionFactory.openSession();
		String query = "from Employee";
		Query createQuery = session.createQuery(query);
		list = createQuery.list();
		session.close();
		return list;
	}
}

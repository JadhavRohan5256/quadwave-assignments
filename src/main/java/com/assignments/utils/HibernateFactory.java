package com.assignments.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.assignments.model.Employee;


public class HibernateFactory {
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getFactory() {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Employee.class);
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void closeFactory() {
		if(sessionFactory != null) sessionFactory.close();
	}
}

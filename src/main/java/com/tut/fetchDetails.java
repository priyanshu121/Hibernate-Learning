package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class fetchDetails {
	
	public static void main(String[] args) {
		// Get or load
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// Get student details
		
		Student student = (Student)session.load(Student.class, 101);
		Address address=(Address)session.get(Address.class, 1);
		System.out.println(student);
		System.out.println(address.getStreet()+" : "+address.getCity());
		
		session.close();
		factory.close();
		
		
	}

}

package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class firstDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// by default enabled...
		
		Student student = session.get(Student.class, 4);
		System.out.println(student);
		
		
		System.out.println("Someting working...");
		
		Student student1 = session.get(Student.class, 4);
		System.out.println(student1);
		System.out.println(session.contains(student1));

		session.close();
	}

}

package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		 // Create Configuration instance and configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Load hibernate configuration file
        
        // Build SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        Student s1=new Student();
        s1.setId(4);
        s1.setName("Ankit");
        s1.setCity("abcd");
        certificate c1=new certificate();
        c1.setCourse("Dev");
        c1.setDuration("3 yrs");
        s1.setCerti(c1);
        
        
        
        Student s2=new Student();
        s2.setId(5);
        s2.setName("nkit");
        s2.setCity("abd");
        certificate c2=new certificate();
        c2.setCourse("ev");
        c2.setDuration("3 yr");
        s2.setCerti(c2);
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        // Objects save
        
        s.save(s1);
        s.save(s2);
        
		
        tx.commit();
        s.close();
        factory.close();
	}

}

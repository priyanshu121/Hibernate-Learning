package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s= factory.openSession();
		
		String query="from Student as s where s.city=:x";
		Query q=s.createQuery(query);
		q.setParameter("x", "Delhi");
		List<Student> list = q.list();
		
		for(Student st:list) {
			System.out.println(st.getName()+" : "+st.getCity());
		}
		
		System.out.println("-----------------------------------");
		
		
		// For delete...
		
//		Transaction tx=s.beginTransaction();
//		Query q2=s.createQuery("Delete from Student");
//		int r=q2.executeUpdate();
//		tx.commit();
		
		
		
		// For update...
		
//		Transaction tx=s.beginTransaction();
//		Query q2=s.createQuery("Update Student set city=:c where city=:n");
//		q2.setParameter("c", "Lucknow");
//		q2.setParameter("n", "Delhi");
//		int r=q2.executeUpdate();
//		System.out.println(r+" rows updated...");
//		tx.commit();
		
		
		// How to execute join query...
		
		Query q3=s.createQuery("Select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> list3= q3.getResultList();
		for(Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		

		
		s.close();
		factory.close(); 
	}

}

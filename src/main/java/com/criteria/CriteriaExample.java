package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mapping.xml.Person;
import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Criteria c=s.createCriteria(Student.class);
		
		
		//c.add(Restrictions.eq("certi.course", "Dev"))
		
		//c.add(Restrictions.gt("id", 4));
		
		
		//c.add(Restrictions.lt("id", 5));
		
		c.add(Restrictions.like("certi.course", "%ev"));
		
		
		List<Student> students=c.list();
		for(Student st: students) {
			System.out.println(st);
		}
		s.close();
	}

}

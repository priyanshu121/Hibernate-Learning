package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.Session;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project started...");
        
        // Create Configuration instance and configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Load hibernate configuration file
        
        // Build SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        
       // Creating student
        
        Student st=new Student();
        st.setId(101);
        st.setName("john");
        st.setCity("Delhi");
        System.out.println(st);
        
        
        
        // Creating object of Address...
        
        Address ad=new Address();
        ad.setStreet("stree1");
        ad.setCity("Delhi");
        ad.setIdOpen(true);
        ad.setAddedDate(new Date(0));
        ad.setX(1234.234);
        
        // Reading Image
        
        FileInputStream fis=new FileInputStream("src/main/java/login_img.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        
        
        org.hibernate.Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done"); 
        
    }
}

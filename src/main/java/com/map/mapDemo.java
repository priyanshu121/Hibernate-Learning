package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java?");

        // Creating answer
        Answer a1 = new Answer();
        a1.setAnswerId(353);
        a1.setAnswer("Java is a programming language...");
        a1.setQuestion(q1);
        
        
        Answer a2 = new Answer();
        a2.setAnswerId(354);
        a2.setAnswer("With the help of java we can create softwares...");
        a2.setQuestion(q1);
        
        
        Answer a3 = new Answer();
        a3.setAnswerId(355);
        a3.setAnswer("Java has diffrent types of framework...");
        a3.setQuestion(q1);
        
        List <Answer> list=new ArrayList<Answer>();
        
        list.add(a1);
        list.add(a2);
        list.add(a3);
        
        q1.setAnswers(list);



        // Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        // Save questions (answers will be saved due to cascade)
        s.save(q1);
//        s.save(q2);

        tx.commit();
        
        // Fetching...
        
//        Question q=(Question)s.get(Question.class, 1212);
//        System.out.println(q.getQuestion());
//        for(Answer a: q.getAnswers()) {
//        	System.out.println(a.getAnswer());
//        }
        
        
        
        Question q=(Question)s.get(Question.class, 1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        // Lazy loading... 
        //System.out.println(q.getAnswers().size());
//        Question newQs=(Question)s.get(Question.class, 1212);
//        System.out.println(newQs.getQuestion());
//        System.out.println(newQs.getAnswer().getAnswer());
        s.close();
        factory.close();
    }
}

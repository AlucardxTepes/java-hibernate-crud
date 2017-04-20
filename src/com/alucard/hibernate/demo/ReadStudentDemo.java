package com.alucard.hibernate.demo;

import com.alucard.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alucard on 4/20/2017.
 */
public class ReadStudentDemo {
  
  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    try {
      // use the session object to save the Java object
      // create a student object
      System.out.println("Creating new student object...");
      Student tempStudent = new Student("Solid", "Snake", "Snake@dev.com");
      
      // start a transaction
      session.beginTransaction();
      
      // save the student object
      System.out.println("Saving the student...");
      session.save(tempStudent);
      
      // commit transaction
      session.getTransaction().commit();
      System.out.println("Transaction complete.");
      
      // find out student's id: primary key
      System.out.println("Generated id: " + tempStudent.getId());
      
      // get a new session and start transaction
      session = factory.getCurrentSession();
      session.beginTransaction();
      
      // retrieve student based on the id: primary key
      System.out.println("\nGetting student with id: " + tempStudent.getId());
      Student myStudent = session.get(Student.class, tempStudent.getId());
      System.out.println("GET complete: " + myStudent);
      
      // commit the transaction
      session.getTransaction().commit();
      
    } finally {
      factory.close();
    }
  }
}

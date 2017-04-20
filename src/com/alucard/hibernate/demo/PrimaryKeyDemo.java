package com.alucard.hibernate.demo;

import com.alucard.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alucard on 4/20/2017.
 */
public class PrimaryKeyDemo {
  
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
      // create 3 student objects
      System.out.println("Creating 3 new student objects...");
      Student tempStudent1 = new Student("Cloud", "Strife", "cloud@dev.com");
      Student tempStudent2 = new Student("Alucard", "Tepes", "alucard@dev.com");
      Student tempStudent3 = new Student("Ramza", "Beoulve", "ramza@dev.com");
      
      // start a transaction
      session.beginTransaction();
      
      // save the student objects
      System.out.println("Saving the students...");
      session.save(tempStudent1);
      session.save(tempStudent2);
      session.save(tempStudent3);
      
      // commit transaction
      session.getTransaction().commit();
      System.out.println("Transaction complete.");
    }
    finally {
      factory.close();
    }
  }
}

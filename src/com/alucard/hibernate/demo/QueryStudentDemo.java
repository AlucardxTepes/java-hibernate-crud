package com.alucard.hibernate.demo;

import com.alucard.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Alucard on 4/20/2017.
 */
public class QueryStudentDemo {
  
  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    try {
      // start a transaction
      session.beginTransaction();
      
      // query students
      List<Student> studentList = session.createQuery("from Student").getResultList();
      
      // display students
      displayStudents(studentList);
      
      // query students: lastName='Strife'
      studentList = session.createQuery("from Student s where s.lastName='Strife'").getResultList();
      displayStudents(studentList);
      
      // query students: lastName='David' OR firstName='Alucard'
      studentList = session.createQuery("from Student s where "
              + "s.lastName='David' OR s.firstName='Alucard'").getResultList();
      displayStudents(studentList);
      
      // query students where email LIKE '%dev.com'
      studentList = session.createQuery("from Student s where "
              + "email LIKE '%dev.com'").getResultList();
      displayStudents(studentList);
      
      // commit transaction
      session.getTransaction().commit();
      System.out.println("Transaction complete.");
    } finally {
      factory.close();
    }
  }
  
  private static void displayStudents(List<Student> studentList) {
    System.out.println();
    for (Student s : studentList) {
      System.out.println(s);
    }
  }
}

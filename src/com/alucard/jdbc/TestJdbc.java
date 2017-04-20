package com.alucard.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Alucard on 4/19/2017.
 */
public class TestJdbc {
  
  public static void main(String[] args) {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    String user = "hbstudent";
    String pass = "hbstudent";
    
    try {
      System.out.println("Connecting to database: " + jdbcUrl);
      Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
      System.out.println("Connection Successful");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

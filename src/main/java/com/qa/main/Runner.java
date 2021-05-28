package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.utils.DBConfig;

public class Runner {

  public static void main (String[] args) {
	  
    try {
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/jdbc_example?db_name&serverTimezone=UTC"
				,"root","password");
	
        PreparedStatement ps = con.prepareStatement("INSERT INTO people (name) values (?)");
        ps.setString(1,"Emilio");
        ps.execute();
    
        ResultSet rs = ps.executeQuery("SELECT * FROM people");
        while(rs.next()) {
          System.out.println(String.format("ID: %d, Name: %s", rs.getInt("id"), rs.getString("name")));	
        }	
        con.close(); 
    
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	  
	  
	  
	  
	  
  }










}

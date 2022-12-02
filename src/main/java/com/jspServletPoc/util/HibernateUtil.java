package com.jspServletPoc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class HibernateUtil {     
	
	 public void newFunction(){
		
		try 
		 {
        String url= "jdbc:mysql://40.80.145.208:3306/painscriptdb?autoReconnect=true&cachePrepStmts=true&useServerPrepStmts=true&rewriteBatchedStatements=true&noAccessToProcedureBodies=true"; // table details
        String username = "admin"; // MySQL credentials
        String password = "pain";
        
        
        
       
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");
        Statement st = con.createStatement();
        PreparedStatement statment = con.prepareStatement("select * from plan");
        
        
        ResultSet rs = statment.executeQuery(); // Execute query
        rs.next();
        Integer id = rs.getInt("id");
        String name= rs.getString("plan_name");
        String description = rs.getString("description");
        System.out.println(id); // Print result on console
        System.out.println(name);
        System.out.println(description);
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
    }
		catch (Exception e) {
			e.printStackTrace();
		}
	 }
		
}






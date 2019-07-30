package com.bridgelabz.JDBCSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Driver2 
{
	public static void main(String[] args) 
	{
		try 
		{
			//get a connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","password");
			
			//create a statement 
			Statement st = con.createStatement();
			
			//Execute SQL query
			
			//INSERT QUERY
			/*
			 * st.executeUpdate("INSERT INTO Emp (id,first_name,last_name,branch,address) "
			 * + "VALUES(3,'Dhanashri','Chalke','Commerce','Udyamnagar Ratnagiri')");
			 * System.out.println("Query Inserted...");
			 */
			
			//UPDATE QUERY
			/*
			 * st.executeUpdate("update Emp set last_name='Arekar' " +
			 * "where first_name='Dhanashri'"); 
			 * System.out.println("Data Updated...");
			 */
			
			//DELETE QUERY
			/*
			 * st.executeUpdate("delete from Emp where last_name='Arekar'");
			 * System.out.println("Data Deleted...");
			 */
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();		
		}
	}
}

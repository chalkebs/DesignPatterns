package com.bridgelabz.JDBCSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Driver 
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
			st.executeUpdate("INSERT INTO sample.Emp (id,first_name,last_name,branch,address) "
					+ "VALUES(3,'Dhanashri','Chalke','Commerce','Udyamnagar Ratnagiri')");
			ResultSet res = st.executeQuery("Select * from Emp");
			
			//Process the Result set
			while(res.next())
			{
				System.out.println(res.getString("id")+" , "+res.getString("first_name")
				+" , "+res.getString("last_name")+" , "+res.getString("branch")+" , "+res.getString("address"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();		
		}
	}
}

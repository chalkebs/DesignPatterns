package com.bridgelabz.JDBCSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class Driver3 
{
	public static void main(String[] args) 
	{
		ResultSet res=null;
		PreparedStatement ps=null;
		
		try 
		{
			//get a connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","password");
			
			//Preparing statement
			ps = con.prepareStatement("Select * from Emp where first_name=?");
					
			//Set Parameters
			ps.setString(1,"Bhagyashri");
			
			//Execute SQL query - Using Prepared Statement...
			res = ps.executeQuery();
			
			//Display result
			display(res);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();		
		}
	}

	private static void display(ResultSet res) 
	{
		try 
		{
			while(res.next())
			{
				System.out.println(res.getString("id")+" , "+res.getString("first_name")
				+" , "+res.getString("last_name")+" , "+res.getString("branch")+" , "+res.getString("address"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}

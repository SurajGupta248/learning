package com.encrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection 
{
	//static Connection con=null;
	//static Statement stmt=null;
	//static ResultSet rs=null;
	public static Connection getJDBCConnection(String url,String user,String pass)
	{
		Connection con=null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(url+" "+user+" "+pass);
		    con=DriverManager.getConnection(url, user, pass);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Drivers are not loaded");
		} 
		catch (SQLException e) 
		{
			System.out.println("Unable to establish connection");
		} 
		return con;
	}
	
	public static Statement createJDBCStatement(Connection con)
	{
		Statement stmt=null;
		try 
		{
			stmt=con.createStatement();
		} 
		catch (SQLException e) 
		{
			System.out.println("Create Statement is not working");
		}
		return stmt;
		
	}
	
	public static ResultSet resultSet(Statement stmt, String sql)
	{
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery(sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("ResultSet is not generated");
		}
		return rs;
		
	}

}

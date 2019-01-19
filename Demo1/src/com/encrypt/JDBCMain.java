package com.encrypt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCMain {
	
	public static void main(String[] args) 
	{
		String url,username,password;
		
		PropertyFile pf=new PropertyFile();
		Properties props=pf.readPropertyFile();
		url=props.getProperty("dburl");
		username=props.getProperty("dbusername");
		password=props.getProperty("dbpassword");
		
		Connection conn=DatabaseConnection.getJDBCConnection(url, username, password);
		Statement stmt=DatabaseConnection.createJDBCStatement(conn);
		String query="Select * from EMPLOYEE";
		ResultSet rst=DatabaseConnection.resultSet(stmt, query);
		try 
		{
			while(rst.next())
				System.out.println(rst.getString(1)+" "+rst.getString(2)+" "+rst.getString(3));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally{
			rst=null;
			stmt=null;
			conn=null;
			
		}
	}

}

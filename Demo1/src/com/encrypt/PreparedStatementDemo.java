package com.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@//192.168.55.121:1521/PDBORCL", "morthdev", "morthdev");
			 ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			 ps.setString(1,"akash");
			 ps.setString(2, EncryptWithMD5(""));
			 ps.setString(3, "akash.gupta@newgen.co.in");
			 ps.setString(4, "Noida");
			 int i=ps.executeUpdate();
			 System.out.println(i+ " row inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}finally{
			ps=null;
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static String EncryptWithMD5(String pass) {
		 MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passByte= pass.getBytes();
			md.reset();
			byte[] digest=md.digest(passByte);
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<digest.length;i++)
				sb.append(Integer.toHexString(0xff & digest[i]));
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

package com.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile 
{
	
	Properties prop=null;
	InputStream input=null;
	static String path=System.getProperty("user.dir")+File.separator+"DB.properties";
	
	public Properties readPropertyFile()
	{
		prop=new Properties();	
		System.out.println(path);
		try 
		{
			input=new FileInputStream(new File(path));
			prop.load(input);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("Property file not found...");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;
	}
	
}

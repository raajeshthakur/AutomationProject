package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	//read configuration.properties file
	public static String getProperty(String property)
	{	
		String configFile = "src/test/resources/configuration.properties";
		return getProperty(configFile, property);
	}
	
	//read properties file from specified location
	public static String getProperty(String filePath, String property)
	{	
		String result = "";
		Properties prop = new Properties();
		InputStream input = null;
		
		try 
		{
			
			input =  new FileInputStream(filePath);
			// load a properties file
			prop.load(input);
			
			result = prop.getProperty(property);
		}
		
		catch (IOException e) 
		{
		e.printStackTrace();
		}
		
		finally 
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}

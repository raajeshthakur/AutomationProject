package Baseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	public String getProperty(String propertyattribute)
	{
		Properties prop = new Properties();
		InputStream input = null;

		try {
			
			input = new FileInputStream(new File("config.properties").getAbsolutePath());
			prop.load(input);
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return prop.getProperty(propertyattribute);
	}
	
	public static void main(String[] s)
	{
		ReadPropertyFile read = new ReadPropertyFile();
		System.out.println(read.getProperty("WriteLocatorFromWeb"));
	}

}

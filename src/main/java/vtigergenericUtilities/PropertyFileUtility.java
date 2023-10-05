package vtigergenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertyFile(String key)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\src\\test\\resources\\commondata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pobj=new Properties();
		try {
			pobj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=pobj.getProperty(key);
		return value;
	}
	
	
	

}

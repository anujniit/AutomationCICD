package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop;
	
	static 
	{
		try
		{
			prop = new Properties();
			FileInputStream fis =new FileInputStream("E:\\Udemy Selenium New Start 22_10_2024\\Workspace\\PurchaseAProductEnd-To-End\\UtilityData\\Config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}

package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
WebDriver driver;
Properties prop;//INiytialize the driver on teh basis of given browser name
public WebDriver init_driver(Properties prop)
{
	String browserName=prop.getProperty("browser").trim();
	System.out.println("Browser name" +browserName);
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	} 
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("safari"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new SafariDriver();
	}
	else
	{
		System.out.println("please pass the browser name"+browserName);
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url").trim());
	return driver;
	
}
public Properties init_prop() throws IOException
{
	try {
		FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
		 prop=new Properties();
		 prop.load(ip);
	} 
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}

}
 
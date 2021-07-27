package com.Lumens.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class BaseClass {
		public static WebDriver driver;
		public static Properties properties;

		public BaseClass() {

			try {
				// initializing properties file to fetch the data from Excel sheet
				properties = new Properties();
				
				FileInputStream fileInputStream = new FileInputStream(
						"D:\\New Selenium\\com.Lumens\\src\\main\\java\\com\\Lumens\\config\\Config.properties");
				properties.load(fileInputStream);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void launchBrowser() {
// setting  the driver path  using properties file  
			System.setProperty("webdriver.chrome.driver", properties.getProperty("driverPath"));
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			//navigating the browser to given URL
			driver.get(properties.getProperty("url"));
			// using implicit wait for browser to navigate if any loading issues
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}

		

	}

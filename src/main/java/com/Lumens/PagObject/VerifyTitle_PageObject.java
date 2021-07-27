package com.Lumens.PagObject;


	
	

	import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.Lumens.Util.BaseClass;

	public class VerifyTitle_PageObject extends BaseClass {
		
		@FindBy(xpath="//*[@id=\"header-wrapper\"]/header/div[2]/div[4]/ul/li[2]/div/button/i")
		WebElement Account;
		
		@FindBy(linkText="Sign In")
		WebElement signup;
		
		@FindBy(id="dwfrm_login_username")
		WebElement Email;

		@FindBy(id="dwfrm_login_password")
		WebElement Password;
		
		@FindBy(xpath="//span[contains(text(),'Log In')]")
		WebElement submit;
		
		@FindBy(xpath="//*[@id='ltkpopup-close-button']")
		WebElement closePopup;
		
		public VerifyTitle_PageObject() {
			PageFactory.initElements(driver, this);
		}
		
		public void Account() {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closePopup);
			closePopup.click();
			Account.getLocation();
			Actions action=new Actions(driver);
			action.moveToElement(Account).build().perform();
			signup.click();
	}
		public void logintoLumens(String email, String password) {
			Email.sendKeys(email);
			Password.sendKeys(password);
			submit.click();
		}
		
		public void VerifyTitle() {
			
			String Actual = driver.getTitle();
			
	        String Expected = "Modern Lighting, Ceiling Fans, Furniture &amp; Home Decor | Lumens.com";

	        if (Actual.equals(Expected)) {
	                   System.out.println("Title of the Lumens Virified Successfully");
	        } else {
	                   System.out.println("Test Failed");
	                   
	        }
	        TakesScreenshot ts=(TakesScreenshot)driver;        
		    File source=ts.getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(source, new File("./ScreenShots/VerifyTitleFailure.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("verify title Failed  screenshot is taken");
		}
		
		

	}

			

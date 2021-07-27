package com.Lumens.PagObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Lumens.Util.BaseClass;

public class Login_PageObject extends BaseClass {
	
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
	
	@FindBy(xpath="//*[@id=\"header-wrapper\"]"
			+ "/header/div[2]/div[4]/ul/li[2]/div/div/div/a")
	WebElement Logoutlink;
	
	@FindBy(xpath="//*[@id=\"header-wrapper\"]/header/div[2]/div[4]/ul/li[2]/div")
	WebElement Account2;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/a")
	WebElement Logout;
	
	public Login_PageObject() {
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
	public void Logout() throws Exception {
		Thread.sleep(20000
				);
	//(JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Account2);
		Account2.getLocation();
		Actions action=new Actions(driver);
		action.moveToElement(Account2).build().perform();
		Logoutlink.click();
		Logout.click();
	}
}

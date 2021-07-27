package com.Lumens.PagObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Lumens.Util.BaseClass;

	

	public class Register_PageObject extends BaseClass{
		
		//it=nitializing the PageFactory for Register page
		
		@FindBy(xpath="//*[@id=\"header-wrapper\"]/header/div[2]/div[4]/ul/li[2]/div/button/i")
		WebElement Account;
		
		@FindBy(id="my_account_hdr_link")
		WebElement MyAccount;
		
		@FindBy(id="dwfrm_profile_customer_firstname")
		WebElement firstName;
		
		@FindBy(id="dwfrm_profile_customer_lastname")
		WebElement lastName;
		
		@FindBy(id="dwfrm_profile_customer_email")
		WebElement email;
		
		@FindBy(id="dwfrm_profile_customer_emailconfirm")
		WebElement Confirmemail;
		
		
		@FindBy(id="dwfrm_profile_login_password")
		WebElement password;
		
		@FindBy(id="dwfrm_profile_login_passwordconfirm")
		WebElement confirmPassword;
		
		
		@FindBy(name="dwfrm_profile_confirm")
		WebElement submit;
		
		@FindBy(xpath="//*[@id='ltkpopup-close-button']")
		WebElement closePopup;
		
		
		public Register_PageObject() {
			PageFactory.initElements(driver, this);
		}
		
		public void Account() {
			
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closePopup);
			closePopup.click();
			// using Action keyword for move the mouse on Webelements
			Actions action=new Actions(driver);
			action.moveToElement(Account).build().perform();
			MyAccount.click();
			
		}
		
		public void RegisterLumens(String FirsName, String LastName, String mail, String ConfirmEmail,
				String pword,String confirmpword) {
			firstName.sendKeys(FirsName);
			lastName.sendKeys(LastName);
			email.sendKeys(mail);
			Confirmemail.sendKeys(ConfirmEmail);
			password.sendKeys(pword);
			confirmPassword.sendKeys(confirmpword);
			
			submit.click();
			
		}
		
		
		}
		
		
		

	

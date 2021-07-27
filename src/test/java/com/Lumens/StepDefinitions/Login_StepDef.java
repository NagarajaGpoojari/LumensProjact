package com.Lumens.StepDefinitions;

import java.util.ArrayList;

import com.Lumens.ExcelData.ReadExcelFile;
import com.Lumens.PagObject.Login_PageObject;
import com.Lumens.Util.BaseClass;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_StepDef extends BaseClass {
	
	Login_PageObject Login;
	ReadExcelFile excelFile;
	
	@When("^Go to Account and Select signin$")
	public void go_to_Account_and_Select_signin() throws Throwable {
		Login=new Login_PageObject();
		Login.Account();
	}

	@Then("^Enter the username and password the input field and click login button$")
	public void enter_the_username_and_password_the_input_field_and_click_login_button() throws Throwable {
		Login=new Login_PageObject();
		excelFile=new ReadExcelFile();
		ArrayList<String> testdata=excelFile.getData("user1");
		Login.logintoLumens(testdata.get(3), testdata.get(5));
		System.out.println("Login Successfully done ");
	}
	@Then("^navigate to Account and click on signout$")
	public void navigate_to_Account_and_click_on_signout() throws Throwable {
		Login=new Login_PageObject();
	   Login.Logout(); 
}
	}

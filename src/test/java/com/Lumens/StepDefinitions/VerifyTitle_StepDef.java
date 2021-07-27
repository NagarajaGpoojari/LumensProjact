package com.Lumens.StepDefinitions;

import java.util.ArrayList;


import com.Lumens.ExcelData.ReadExcelFile;
import com.Lumens.PagObject.HomePage;
import com.Lumens.Util.BaseClass;

import cucumber.api.java.en.Then;


	

	public class VerifyTitle_StepDef extends BaseClass {
		
		HomePage verify;
		ReadExcelFile excelFile;
		
		@Then("^Enter the username and password  and click login button$")
		public void enter_the_username_and_password_and_click_login_button() throws Throwable {
			verify=new HomePage();
			excelFile=new ReadExcelFile();
			ArrayList<String> testdata=excelFile.getData("user1");
			verify.logintoLumens(testdata.get(3), testdata.get(5));
			System.out.println("Login Successfully done");
		}

		@Then("^Verify the Title of Lumens website$")
		public void verify_the_Title_of_Lumens_website() throws Throwable {
			verify=new HomePage();
			verify.VerifyTitle();
			
		}
	}



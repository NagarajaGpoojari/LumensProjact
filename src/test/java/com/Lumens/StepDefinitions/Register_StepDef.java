package com.Lumens.StepDefinitions;

import java.util.ArrayList;

import com.Lumens.ExcelData.ReadExcelFile;
import com.Lumens.PagObject.Register_PageObject;
import com.Lumens.Util.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register_StepDef extends BaseClass {

	Register_PageObject Register;
	ReadExcelFile excelFile;
	@Given("^launch the Lumens website using property file$")
	public void launch_the_Lumens_website_using_property_file() throws Throwable {
		
		BaseClass.launchBrowser();
	}

	@When("^Go to Account and Select MyAccount$")
	public void go_to_Account_and_Select_MyAccount() throws Throwable {
		Register =new Register_PageObject();
		Register.Account();
		
	}

	@Then("^Enter the given details in the input field and click submit button$")
	public void enter_the_given_details_in_the_input_field_and_click_submit_button() throws Throwable {
	 // Register.RegisterLumens(FirsName, LastName, mail, ConfirmEmail, pword, cpword);
	  Register=new Register_PageObject();
		excelFile=new ReadExcelFile();
		ArrayList<String> testdata=excelFile.getData("user1");
		Register.RegisterLumens(testdata.get(1), testdata.get(2), testdata.get(3), testdata.get(4), testdata.get(5), testdata.get(6));
		System.out.println("Registered succsessfully");
	}


}

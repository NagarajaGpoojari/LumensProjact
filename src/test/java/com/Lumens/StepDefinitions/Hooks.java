package com.Lumens.StepDefinitions;



import com.Lumens.Util.BaseClass;
import cucumber.api.java.After;

	public class Hooks extends BaseClass{
		
		@After
		public void closeBrowser() {
			driver.quit();
		}

	}




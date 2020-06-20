package com.citi.mobileAutomation.framework;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.citi.mobileAutomation.reusableFunctions.CommonMethods;
import com.citi.mobiletest.objectrepository.EriBankObjects;

public class EriBankExpenseReport extends CommonMethods {

	
	 public EriBankExpenseReport(RemoteWebDriver driver){ 
		 this.driver = driver; 
	}
	 
	 public void clickExpenseReport() throws IOException {
			
			clickMethod(EriBankObjects.expenseReportButton);
			
		}
		
		public void clickAddExpenseOne() throws IOException {
			
			clickMethod(EriBankObjects.addExpenseButton);
			
		}
	   public void clickAddExpenseTwo() throws IOException {
			
			clickMethod(EriBankObjects.addExpenseButton);
			
		}
		
	   public void clickBackButton() throws IOException {
			
			clickMethod(EriBankObjects.backButton);
			
		}
	 
}

package com.citi.mobileAutomation.framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.citi.mobileAutomation.reusableFunctions.CommonMethods;
import com.citi.mobiletest.objectrepository.EriBankObjects;

public class EriBankMakePayment extends CommonMethods {

	 public EriBankMakePayment(RemoteWebDriver driver){ 
		 this.driver = driver; 
	}
	 
	
	public void inputName(String recipiantName) throws IOException {
		sendKeysTextBox(EriBankObjects.nameText, recipiantName);
	}
	
	public void inputPhoneNumber(String phoneNumber) throws IOException {
		sendKeysTextBox(EriBankObjects.phoneNumberText, phoneNumber);
	}
	
	public void inputAmount(String amount) throws IOException {
		sendKeysTextBox(EriBankObjects.amountText, amount);
	}
	
	public void moveToMakePayment() throws IOException {
		clickMethod(EriBankObjects.makePaymentButton);
	}
	
	public void selectCountry(String country) throws IOException {
		clickMethod(EriBankObjects.countrySectionButton);
		String cntry = EriBankObjects.countryButton;
		clickByXpath(cntry.replace("*@**@*", country));
	}
	
	public void clickSendPayment() throws IOException {
		clickMethod(EriBankObjects.sendPaymentButton);
	}
	
	public void clickConfirmationYes() throws IOException {
		clickMethod(EriBankObjects.yesButton);
	}
}

package com.citi.mobileAutomation.framework;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.mobileAutomation.dataprovider.ExcelDataProvider;
import com.citi.mobileAutomation.reusableFunctions.CommonMethods;
import com.citi.mobiletest.objectrepository.EriBankObjects;

public class EriBankLogin extends CommonMethods{
	
	public EriBankLogin(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	private void inputUserName(String uName) throws IOException {
		sendKeysTextBox(EriBankObjects.userNameText, uName);
	}
	
	private void inputPassword(String password) throws IOException {
		sendKeysTextBox(EriBankObjects.passwordText, password);
	}
	
	private void clickLoginButton() throws IOException {
		clickMethod(EriBankObjects.loginButton);
	}
	
	public void customerLogin() throws IOException {
		login("customer");
	}
	
	private void login(String type) throws IOException {
		HashMap<String, String> userData = new ExcelDataProvider().getUserData(type);
		inputUserName(userData.get("userName"));
		inputPassword(userData.get("password"));
		clickLoginButton();
	}
	
	public void logout() throws IOException {
		clickMethod(EriBankObjects.logoutButton);
	}
	
}

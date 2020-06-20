package com.citi.mobiletest.objectrepository;

import org.openqa.selenium.By;

public class EriBankObjects {
	
	// Common
	
	public static final By backButton = By.xpath("//*[@id='backButton']");
	public static final String countryButton="//*[@text='*@**@*']";
	
	
	
	//Login Screen
	
	public static final By userNameText=By.xpath("//*[@id='usernameTextField']");
	public static final By passwordText=By.xpath("//*[@id='passwordTextField']");
	public static final By loginButton=By.xpath("//*[@id='loginButton']");
	
	//Home Screen
	
	public static final By makePaymentButton=By.xpath("//*[@text='Make Payment']");
	public static final By mortgageRequestButton = By.xpath("//*[@text='Mortgage Request']");
	public static final By expenseReportButton =By.xpath("//*[@text='Expense Report']");
	public static final By logoutButton=By.xpath("//*[@text='Logout']");

	
	// Make Payment Screen
	
	public static final By phoneNumberText=By.xpath("//*[@id='phoneTextField']");
	public static final By nameText=By.xpath("//*[@id='nameTextField']");
	public static final By amountText=By.xpath("//*[@id='amountTextField']");
	public static final By countrySectionButton=By.xpath("//*[@text='Select']");
	public static final By sendPaymentButton=By.xpath("//*[@id='sendPaymentButton']");
	public static final By yesButton=By.xpath("//*[@text='Yes']");
	
	// MortgageRequest Screen
	
    public static final By firstNameText = By.xpath("//*[@id='nameTextField']");
    public static final By lastNameText = By.xpath("//*[@id='lastNameTextField']");
    public static final By ageText = By.xpath("//*[@id='ageTextField']");
    public static final By addressOneText = By.xpath("//*[@id='addressOneTextField']");
    public static final By addressTwoText = By.xpath("//*[@id='addressTwoTextField']");
    public static final By nextButton = By.xpath("//*[@id='nextButton']");
    public static final By cancelButton = By.xpath("//*[@id='cancelButton']");
    public static final String typeOfLoanCheck = "//*[@text='*@**@*']";
    public static final String numberOfYearsCheck = "//*[@text='*@**@*']";
    public static final String typeOfOccupationCheck = "//*[@text='*@**@*']";
    public static final String yearlyIncomeCheck = "//*[@text='*@**@*']";
    public static final By saveButton = By.xpath("//*[@text='Save']");
    
  
    
  //expense Report Screen
  public static final By addExpenseButton =By.xpath("//*[@id='addButton']");
  	
    

}

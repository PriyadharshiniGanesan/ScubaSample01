package com.citi.mobileAutomation.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.mobileAutomation.dataprovider.ExcelDataProvider;
import com.experitest.appium.SeeTestClient;

public class DriverClass{
	
	private HashMap<String, String> propertyData; 
	private HashMap<String, String> appData; 
	public  HashMap<String, String> testData;
	public  RemoteWebDriver driver = null;
	DesiredCapabilities dc = null;
	public SeeTestClient seeTest = null;
	private Properties property = new Properties();
	private String deviceProperty = null;
	private String experiTestProperty = null; 
	private String serialNumber = null;

	public RemoteWebDriver initializeDriver() throws FileNotFoundException, IOException {
		deviceProperty = propertyData.get("deviceProperty");
		serialNumber = testData.get("serialNumber");
		seeTest.deviceAction("Home");
		property.load(new FileInputStream(new File(deviceProperty)));
		if (property.getProperty(serialNumber).contains("android")) {
			System.out.println("Android");
			intializeAndroid();
		} else {
			System.out.println("IOS");
			initilizeIOS();
		}
		return driver;
	}
	
	

	public void setPropertyData(HashMap<String, String> propertyData) {
		this.propertyData = propertyData;
	}



	public void setAppData(HashMap<String, String> appData) {
		this.appData = appData;
	}



	@SuppressWarnings("unchecked")
	private void intializeAndroid() throws FileNotFoundException, IOException {
		experiTestProperty = propertyData.get("experiTestProperty");
		property.load(new FileInputStream(new File(experiTestProperty)));
		dc = new DesiredCapabilities();
		//dc.setCapability("testName", "Quick Start Android Native Demo");
		dc.setCapability("accessKey", property.getProperty("accessKey"));
		dc.setCapability("deviceQuery", "@serialnumber='" + serialNumber + "'");
		dc.setCapability(MobileCapabilityType.APP, appData.get("appAndroid"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appData.get("appPackage"));
		driver = new AndroidDriver<AndroidElement>(new URL(property.getProperty("experiTestUrl")), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		seeTest = new SeeTestClient((AndroidDriver<AndroidElement>) driver);
		seeTest.startPerformanceTransaction(testData.get("networkSpeed"));

	}

	@SuppressWarnings("unchecked")
	private void initilizeIOS() throws FileNotFoundException, IOException {
		experiTestProperty = propertyData.get("experiTestProperty");
		property.load(new FileInputStream(new File(experiTestProperty)));
		dc = new DesiredCapabilities();
		//dc.setCapability("testName", "Quick Start iOS Native Demo");
		dc.setCapability("accessKey", property.getProperty("accessKey"));
		dc.setCapability("deviceQuery", "@serialnumber='" + serialNumber + "'");
		dc.setCapability(MobileCapabilityType.APP, appData.get("appIOS"));
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, appData.get("bundelId"));
		String bundelId=appData.get("bundelId");
		seeTest.launch(bundelId, true, true);
		driver = new IOSDriver<IOSElement>(new URL(property.getProperty("experiTestUrl")), dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		seeTest = new SeeTestClient((IOSDriver<IOSElement>) driver);
		seeTest.startPerformanceTransaction(testData.get("networkSpeed"));

	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	@SuppressWarnings("resource")
	public void generateJsonFile() throws FileNotFoundException, IOException {
		String testCaseId = testData.get("testCaseId");
		String json = seeTest.endPerformanceTransaction(testCaseId);
		System.out.println(json);
		Date date = new Date(); 
	    File file = new File(System.getProperty("user.dir")+"\\JsonFiles\\"+date.getTime()+"_"+testCaseId+".json");
	    new FileOutputStream(file).write(json.getBytes());
	}

}

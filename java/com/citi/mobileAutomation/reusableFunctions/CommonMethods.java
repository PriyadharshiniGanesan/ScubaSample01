package com.citi.mobileAutomation.reusableFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.mobileAutomation.framework.DriverClass;
import com.experitest.appium.SeeTestClient;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class CommonMethods{
	
	protected static RemoteWebDriver driver=null;
	protected WebDriverWait wait;

	
	//==================New Resuable functions===================================
	/*  To send text to any field
	 * This function needs two parameters 
	 * Element locator i.e xpath and Text you want to pass
	 * If element isn't found,It will wait 10sec to find the element
	 */
	
	public  void sendKeysTextBox(By by, String text) throws IOException {
		findElement(by).sendKeys(text);
	}
	

	/*  To send text to any field which already has some text
	 * This method will first clear the field, then it will send text
	 * This function needs two parameters 
	 * Element locator i.e xpath and Text you want to pass
	 * If element isn't found,It will wait 10sec to find the element
	 */
	
	public  void clearAndSendKeys(By by, String text) throws IOException {
		WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));
		ele.clear();
		ele.sendKeys(text);
	}
	

	/* To click on any element
	 * This function needs one parameters 
	 * Element locator i.e xpath 
	 * If element isn't found,It will wait 10sec to find the element
	 */
	
	public  void clickMethod(By by){
		findElement(by).click();
	}
	
	
	private WebElement findElement(By by) {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				return driver.findElement(by);
			}
			catch (Exception e) {
				// TODO: han1dle exception
			}
		}
		return null;
	}
	
public  void draganddrop(WebElement from,int x,int y) throws IOException {
		
		Actions action = new Actions(driver);
		
		action.dragAndDropBy(from,x,y).build().perform();
		
	}
	
	public  void draganddrop(WebElement from,WebElement to) throws IOException {
		
		Actions action = new Actions(driver);
		
	
		action.dragAndDrop(from, to).build().perform();
		
	}
	
	/* To Check  whether the element is present or not
	 * This function needs one parameters 
	 * Element locator i.e xpath 
	 * If element isn't found,It will wait 10sec to find the element
	 */

	public  boolean isElementPresent(By by) throws IOException {
		try {
			WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));
			return true;
		} catch (Exception e) {
			System.out.println("element not found");
			return false;
		}
	}

	/* To tap on device's screen at any location
	 * This function needs two parameters 
	 * x and y ordinates
	 */
	
	public  void tapMethod(int x, int y) throws IOException, InterruptedException {
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		PointOption points = new PointOption();
		touchAction.tap(points.point(x, y)).perform();
		System.out.println("Tap performed");
	}
	
	/* To tap on any element 
	 * This function needs one parameter
	 * Element locator i.e xpath
	 */

	public  void tapByElement(By by) throws IOException, InterruptedException {
		try {
			WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));
			System.out.println("element located");
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			ElementOption eleOP = new ElementOption();

			// TapOptions tapOptions = new
			// TapOptions().withElement(ElementOption.element(ele));
			PointOption points = new PointOption();
			TapOptions tapOptions = new TapOptions()
					.withPosition(points.point(ele.getLocation().getX() + 5, ele.getLocation().getY() + 2));
			// TapOptions tapOptions = new TapOptions().withElement(eleOP.withElement(ele));

			touchAction.tap(tapOptions).perform();
			System.out.println("Tap performed");
		} catch (Exception e) {
			System.out.println("Unable to Tap");
		}

	}
	
	/* To LongPress on element 
	 * This function needs one parameter
	 * Element locator i.e xpath
	 */

	public  void longPressOnElement(By by) throws IOException, InterruptedException {
		try {
			WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));
			System.out.println("element located");
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			LongPressOptions longpress = new LongPressOptions();
			ElementOption eleOpt = new ElementOption();
			touchAction.longPress(longpress.withElement(eleOpt.withElement(ele))).perform();
			System.out.println("LONG PRESS performed");
		} catch (Exception e) {
			System.out.println("Unable to Tap");
		}

	}
	
	/* To LongPress on element 
	 * This function needs two parameters
	 * x and y ordinates
	 */

	public  void longPressOnElementCor(int x, int y) throws IOException, InterruptedException {
		try {

			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			LongPressOptions longpress = new LongPressOptions();
			ElementOption eleOpt = new ElementOption();
			PointOption point = new PointOption();
			touchAction.longPress(longpress.withPosition(point.withCoordinates(x, y))).perform();
			System.out.println("LONG PRESS performed");
		} catch (Exception e) {
			System.out.println("Unable to Tap");
		}

	}
	
	/* To Scroll  
	 */

	public  void scrollByJavaScriptExe() throws IOException {

		PointOption points = new PointOption();
		TouchAction action = new TouchAction((PerformsTouchActions) driver);

		action.press(points.point(501, 451)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(points.point(501, 200)).release().perform();
	}
	
	/* To take Screenshots  
	 */
	public  void screenShots() throws IOException {
		TakesScreenshot shots = (TakesScreenshot) driver;
		File src = shots.getScreenshotAs(OutputType.FILE);

		Date dt = new Date();

		File dest = new File(
				"C:\\Users\\HP\\eclipse-workspace\\BABU\\Myntra\\src\\main\\resource\\Screenshot\\babu.png");

		FileHandler.copy(src, dest);
	}

	
	/* To assert  
	 * This function needs two parameters
	 * actual and testing texts
	 */
	public  void myAssertion(String text, String text2) {
		Assert.assertTrue(text.equalsIgnoreCase(text2));
	}

	/* To Check element is present not
	 * This function needs one parameter
	 * Element locator i.e xpath 
	 */
	public  boolean elementNotExist(By by) throws InterruptedException {
		return driver.findElements(by).size() > 0;

	}
	
	
	/* To get text from some element
	 * This function needs one parameter
	 * Element locator i.e xpath 
	 */
//	==============For IOS Device====================
	public  String getTextElementBy(By by) {
		WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));
		return ele.getAttribute("name");

	}
	
	
	/* To get text from some element
	 * This function needs one parameter
	 * Element locator i.e xpath 
	 */
//	==============For Android Device====================
	public  String getTextElementByText(By by) {
		WebElement ele = (WebElement) (wait.until(ExpectedConditions.presenceOfElementLocated(by)));

		return ele.getAttribute("text");

	}
	
	/* To Switch from Native view to web view
	 
	 */
	/*
	 * public void Switch_Native_To_Hybrid() {
	 * 
	 * Set<String> contextNames = DesiredCap.driver.getContextHandles(); for (String
	 * contextName : contextNames) { System.out.println(contextName); }
	 * DesiredCap.driver.context(contextNames.toArray()[1].toString());
	 * 
	 * }
	 */

	/* To Switch from  web view to Native view 
	 
	 */
	/*
	 * public void Switch_Hybrid_To_Native() {
	 * 
	 * Set<String> contextNames = DesiredCap.driver.getContextHandles(); for (String
	 * contextName : contextNames) { System.out.println(contextName); }
	 * DesiredCap.driver.context(contextNames.toArray()[0].toString());
	 * 
	 * }
	 */

	
	/* To Scroll in all directions 
	 * This function needs four parameters
	 * x and y ordinates
	 * one integer value
	 * one character value i.e for up/down/left/right 
	 */
	public  void scrollByJavaScriptExe(int x, int y,int coordinate, char c) throws IOException {
      PointOption points = new PointOption();
      TouchAction action = new TouchAction((PerformsTouchActions) driver);
      
      switch (c) 
      {
		case '-':
			action.press(points.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(points.point(x, y+c+coordinate)).release().perform();
			break;
		case '+':
			action.press(points.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(points.point(x, y+c+coordinate)).release().perform();
			break;
		case 'L':
			action.press(points.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(points.point(coordinate, y)).release().perform();
			break;
		case 'R':
			action.press(points.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(points.point(x+coordinate, y)).release().perform();
			break;
		default:
			System.out.println("Scroll cant perform on that direction");
			break;
		}
      
      
  }//====================Old Reusable Functions================================

	public  boolean isExist(String Id) {
		try {
			driver.findElement(By.id(Id)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public  boolean isExistXpath(String Id) {
		try {
			driver.findElement(By.xpath(Id)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public  boolean isExistSend(String Id, String keysToSend) {
		try {
			driver.findElement(By.id(Id)).sendKeys(keysToSend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public  void checkForTheElementIsPresentInDOM(String className) {
		List<WebElement> inputs;
		Long startTime = System.currentTimeMillis();
		do {
			inputs = (List<WebElement>) driver.findElements(MobileBy.className(className));
			if (!inputs.isEmpty()) {
				System.out.println("FOUND!");
				break;
			} else {
				System.out.println("NoT Found..!!");
			}
		} while ((System.currentTimeMillis() - startTime) / 1000 < 100); // 100
																			// sec
																			// wait
	}

	public  void clearForWaitByID(String value) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id(value)).clear();
	}

	public  void clcikByID(String value) {
		try {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.id(value)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void clickByXpath(String value) {
		try {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath(value)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void clickForWaitByXpath(String value) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value))).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<String> findDuplicates(List<String> listContainingDuplicates) {
		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();
		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}

	public  boolean sortOrder(List<String> value) {
		String previous = "";
		value = new ArrayList<String>();
		for (final String current : value) {
			value.add(current);
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}
		return true;
	}
	

	/*
	 * public void clickByClassName(String elements, int index) throws
	 * InterruptedException { List<WebElement> elementClick =
	 * driver.findElementByClassName(elements); elementClick.get(index).click(); }
	 */

	public  void scrolliOS(String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<Object, Object> scrollObject = new HashMap();
		scrollObject.put("predicateString", "value == '" + text + "'");
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(text)).click();

	}
	
public long getTime(){
		
		Date date = new Date();  
	    Timestamp ts=new Timestamp(date.getTime()); 
		return ts.getTime();
		
	}

public Timestamp getTimeStamp(){
	
	Date date = new Date();  
    Timestamp ts=new Timestamp(date.getTime()); 
	return ts;
	
}

public void Home(){
	
}
 
public void launch(){
	
	
}




}

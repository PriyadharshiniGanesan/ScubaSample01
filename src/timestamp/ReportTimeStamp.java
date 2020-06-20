package timestamp;

import org.openqa.selenium.chrome.ChromeDriver;

public class ReportTimeStamp {

			public static void main(String[] args) {
			
		      System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		      ChromeDriver driver= new ChromeDriver();
		      driver.manage().window().maximize();
		      driver.get("file:///C:/Users/preet/AppData/Local/Temp/Rar$EXa18352.45707/index.html");
		      driver.findElementByXPath("//*[@id='report-bar-ul']/li[9]/div[1]/span[2]").click();
		     String value=driver.findElementByXPath("/html/body/div/div[2]/div[20]/div[1]/div[1]/div[2]/div").getText();
		     System.out.println(value);
		      
		     

	}

}

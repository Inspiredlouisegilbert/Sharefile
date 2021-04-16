package Iframedemo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworkclasses.SeleniumFunctions;

public class IframeDemoKeywords {
	
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com/test/guru99home/";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	
	///// Run tests /////
	
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Payment Gateway Project", "Playing with tables");
		sfSelenium.createTest("Start Test");
	}
	
	public void iframes() throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: Tables");
		navigateToURL(pURL);
		int sizes = driver.findElements(By.tagName("iframe")).size();
		System.out.println(sizes);
            
		//Commented the code for finding the index of the element
	    this.driver.switchTo().frame(1); //Switching to the frame
		System.out.println("********We are switched to the iframe*******");
		
		this.driver.findElement(By.xpath("//body/a[1]/img[1]")).click();
		
		//Clicking the element in line with Advertisement
	    System.out.println("*********We are done***************");
	    Thread.sleep(5000);

		sfSelenium.logScreenShot();	
	}
	   
	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();	
		//
	}

	
}




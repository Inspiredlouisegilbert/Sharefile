package frameworkclasses;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


// This class manages all Selenium Functions and the Driver
public class SeleniumFunctions {
	// Class Private Variables
	private  WebDriver driver;
	
	//private ReportingClass reports = new ReportingClass();
	
	
	// Constructor
	public SeleniumFunctions() {
		
		// Tell Java where the chromedriver.exe sits & Create a new instance of Chrome Driver
		SetupSelenium();
		
	}

	public void SetupSelenium() {
		
		// For Mac
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		// For Window
				System.setProperty("webdriver.chrome.driver", "c:\\chromedriver_win32\\chromedriver.exe"); 

		// Create an instance of ChromeDriver to execute our tests
		 this.driver = new ChromeDriver();	

	}

	// Get for chromedriver
	public WebDriver getDriver() {
		return this.driver;
				
	}
	
	// Set for chromedriver
	public void setDriver(WebDriver pDriver) {
		this.driver = pDriver;
	}
	
	
	// function to populate dropdown and validate the text
	public void populateDropDown (String pByName, String pValue) {
		// Creates an instance of the dropdown object
		Select sDrpDown = new Select (this.driver.findElement(By.name(pByName)));
		
		// Populates the Dropdown
		sDrpDown.selectByVisibleText(pValue);
		
		WebElement selectedoption = sDrpDown.getFirstSelectedOption();
		String sActualValue = selectedoption.getText();
		String sExpectedValue = pValue;
		//this.reports.doValidtions(sActualValue, sExpectedValue);
	}
	
	public void updateReport (String sActualValue, String sExpectedValue) {
		
		//this.reports.doValidtions(sActualValue, sExpectedValue);
	}
	
	// function to populate an input field using multiple By clauses
	public void populateInputField(By byClause, String inputValue) {
		this.driver.findElement(byClause).sendKeys(inputValue);
		
		// Reads the value that was typed into the field
		//String sActualValue = this.driver.findElement(byClause).getText();
		String sActualValue = this.driver.findElement(byClause).getAttribute("value");
		
		// set the value for ExpectedValue 
		String sExpectedValue = inputValue;
		
		//this.reports.doValidtions(sExpectedValue, sActualValue);
		
	}
	
	// function to select a radio button option
	public void selectRadioOption(String pValue) {
		driver.findElement(By.xpath("//input[@type='radio'][@value='" + pValue + "']")).click();
	}
	
	// function to click on a hyperlink
	public void clickLink(String pLinkText) {
		driver.findElement(By.linkText(pLinkText)).click();
		
		// in future we will add validations and screenshots to this method
	}
	
	
	public void logScreenShot() throws IOException {
		//this.reports.logScreenshot(this.driver);
	}
	
	
	public void CloseSelenium() {
		//this.reports.FinaliseExtentReport();
		////driver.close will close the original browser window
		//this.driver.close();
		////driver.quit will close the original and all subsequent browser tabs
		this.driver.quit();
	}
	
	// Switch between tabs
	public void switchTab(int pTagIndex) {
		//Hold all the window handles in an array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(pTagIndex));
	}
	
	// Get last Digits
	public String getLastDigits(int iLastDigits, String pStringName) {
		String sLastdigits = pStringName.substring(pStringName.length() - iLastDigits);
	    System.out.println(sLastdigits);
	    return sLastdigits;
	}
	
	// Get first Digits
	public String getFirstDigits(int iFirstDigits, String pStringName) {
		String sFirstdigits = pStringName.substring(0,2);
	    System.out.println(sFirstdigits);
	    return sFirstdigits;
	}
	
	// Maximise Browser Window
	public void maximiseBrowserWindow() {
		driver.manage().window().maximize();
	}
	

}



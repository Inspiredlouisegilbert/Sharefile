package frameworkclasses;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import frameworkclasses.ExtentReportClass;

// Mongo DB imports
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;



// This class manages all Selenium Functions and the Driver
public class SeleniumFunctions {
	// Class Private Variables
	private  WebDriver driver;
	ExtentReportClass extReports = new ExtentReportClass();
	public String gatewayurl;
	
	//private ReportingClass reports = new ReportingClass();
	
	
	// Constructor
	public SeleniumFunctions()  {
		
		// Tell Java where the chromedriver.exe sits & Create a new instance of Chrome Driver
		SetupSelenium();
		
	}

	public void SetupSelenium() {
		
		
		// Properties setup
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("dataConfig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(p.getProperty("driverdir"));
		//System.out.println(p.getProperty("gatewayurl"));

		System.setProperty("webdriver.chrome.driver", p.getProperty("driverdir")); 
		//System.setProperty("webdriver.chrome.driver", p.getProperty("driverdir"));
		// For Mac
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		// For Window
				//System.setProperty("webdriver.chrome.driver", "c:\\chromedriver_win32\\chromedriver.exe"); 

		// Create an instance of ChromeDriver to execute our tests
		 this.driver = new ChromeDriver();	
	}
	

	public void startReport(String sReportName, String sTitle) {
		extReports.startReport(sReportName, sTitle);
	}
	
	public void createTest(String sName) {
		extReports.createTest(sName);
	}
	
	// Reusable method to perform validations for us
	public void doValidation (String sActualValue, String sExpectedValue) {
		
		// Output to Console and Extent Report
		if (sActualValue.contentEquals(sExpectedValue)) {
			// If condition is true, execute this code
			// output to console
			System.out.println("Test passed. Expected Value = " + sExpectedValue + " Actual Value = " + sActualValue);
			
			// output to extent Reports
			extReports.logPass(sActualValue, sExpectedValue);
			
		}
		else {
			// If condition is false, execute this code
			System.out.println("Test failed. Expected Value = " + sExpectedValue + " Actual Value = " + sActualValue);
			
			// output to extent Reports
			extReports.logFail(sActualValue, sExpectedValue);
		}

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
		this.doValidation(sActualValue, sExpectedValue);
	}
	
	public void updateReport (String sActualValue, String sExpectedValue) {
		
		this.doValidation(sActualValue, sExpectedValue);
	}
	
	// function to populate an input field using multiple By clauses
	public void populateInputField(By byClause, String inputValue) {
		this.driver.findElement(byClause).sendKeys(inputValue);
		
		// Reads the value that was typed into the field
		//String sActualValue = this.driver.findElement(byClause).getText();
		String sActualValue = this.driver.findElement(byClause).getAttribute("value");
		
		// set the value for ExpectedValue 
		String sExpectedValue = inputValue;
		
		this.doValidation(sExpectedValue, sActualValue);
		
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
		this.extReports.logScreenshot(this.driver);
	}
	

	public void CloseSelenium() {
		//this.reports.FinaliseExtentReport();
		////driver.close will close the original browser window
		//this.driver.close();
		////driver.quit will close the original and all subsequent browser tabs
		this.driver.quit();
		// Also finalise and close the test report for us
		extReports.closeReport();
	}
	
	// Switch between tabs
	public void switchTab(int pTagIndex) {
		//Hold all the window handles in an array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		if (pTagIndex < 0) {
			
			pTagIndex = newTb.size() - 1;
		}
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
		String sFirstdigits = pStringName.substring(0,iFirstDigits);
	    System.out.println(sFirstdigits);
	    return sFirstdigits;
	}
	
	// Maximise Browser Window
	public void maximiseBrowserWindow() {
		driver.manage().window().maximize();
	}
	

}



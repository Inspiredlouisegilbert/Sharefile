package PaymentGateway;


import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.SeleniumFunctions;

public class PaymentGatewayKeywords {
	
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// Setup waits
	WebDriverWait wait;
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	

	public String getProperties(String pPropertyKey) {
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
		return p.getProperty(pPropertyKey);
	}
	

	
	// Click on Payment Gateway Link
	public void clickPaymentGateway() {
		sfSelenium.clickLink("Payment Gateway Project");
	}
	
	// select quantity
	public void selectQuantity(String pQuantity) throws IOException {
		sfSelenium.populateDropDown("quantity", pQuantity);
		
		// Capture a screenshot to extent reports
		sfSelenium.logScreenShot();
	}
	
	// click buy now
	public void clickBuyNow() {
		this.driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
	}
	
	// capture the payment details
	public void capturePaymentDetails(String pCardNumber, String pExpMonth, String pExpYear, String pCVV) throws IOException {
		// Capture Card Number
		sfSelenium.populateInputField(By.name("card_nmuber"), pCardNumber);
		
		// Capture Expiration Month
		sfSelenium.populateDropDown("month", pExpMonth);
		
		// Capture Expiration Year
		sfSelenium.populateDropDown("year", pExpYear);
		
		// Capture CVV Code
		sfSelenium.populateInputField(By.id("cvv_code"), pCVV);
		
		// Log a Screenshot to the report
		sfSelenium.logScreenShot();
		
		// Capture Payment Detail - Click Pay
		//driver.findElement(By.name("submit")).click();
	}
	
	public void clickPay( ) throws IOException {

		// Capture Payment Detail - Click Pay
		this.driver.findElement(By.name("submit")).click();
	}
	
	// Go to the card generate
	public void clickGenerateCardNumber() throws IOException {
		// click buy now
		sfSelenium.clickLink("Generate Card Number");
		// Switch focus to tab next/new tab/ browser window
		sfSelenium.switchTab(1);	
		//take a screen shot
		sfSelenium.logScreenShot();
			
		}
	
	// Get the payment details
	public void getCreditCardDetails() throws IOException {
		//// Get Card Number
		//// Switch focus to tab next/new tab/ browser winder
		sfSelenium.switchTab(1);
		
		//// Credit Card Number
		//getCreditCardDetail(3,16);
		//// CSS for the generated card number
		String cssCreditCardNumber = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(3)";
		//// Get the credit card number
		String sCreditCardNumber = this.driver.findElement(By.cssSelector(cssCreditCardNumber)).getText();
		//// Print the sCreditCardNumber to view it
	    System.out.println(sCreditCardNumber);
	    //// Get the last 16 digits
	    String sStrippedCardNumber = sfSelenium.getLastDigits(16, sCreditCardNumber);
	    //// CVV number
	    //// CSS for the generated cvv number
	    String cssCvv = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(4)";
	    //// Get the CVV number
	    String sCvv = this.driver.findElement(By.cssSelector(cssCvv)).getText();
	    //// Print the CVV to view it
	    System.out.println(sCvv);
	    //// Get the last 3 digits
	    String sStrippedCvv = sfSelenium.getLastDigits(3, sCvv);
	    
	    //// Year
	    String cssYear = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(5)";
	    //// Get the YEAR
	    String sYear = this.driver.findElement(By.cssSelector(cssYear)).getText();
	    //// Print the YEAR to view it
	    System.out.println(sYear);
	    //// Get the last xx digits
	    String sStrippedYear = sfSelenium.getLastDigits(4, sYear);
	    
	    //// Month
	    String cssMonth = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(5)";
	    //// Get the Month
	    String sMonth = this.driver.findElement(By.cssSelector(cssMonth)).getText();
	    //// Print the Month to view it
	    System.out.println(sMonth);
	    //// Get the last xx digits
	    String sStrippedYearMonth = sfSelenium.getLastDigits(7, sYear);
	    String sStrippedMonth = sfSelenium.getFirstDigits(2, sStrippedYearMonth);
	    
		//// Switch back to the originating tab
	    sfSelenium.switchTab(0);
	    //// Populate the Input Field
	    sfSelenium.populateInputField(By.name("card_nmuber"), sStrippedCardNumber);
	    //// Populate cvv input filed
	    sfSelenium.populateInputField(By.name("cvv_code"), sStrippedCvv);
	    //// Populate Expiration Year
	 	sfSelenium.populateDropDown("year", sStrippedYear);
	 	//// Populate Expiration Month
	 	sfSelenium.populateDropDown("month", sStrippedMonth);
	    
	    //// Log a Screenshot to the report
	 	sfSelenium.logScreenShot();
	 		
	 	//// Capture Payment Detail - Click Pay
	 	this.driver.findElement(By.name("submit")).click();
		
		this.driver.findElement(By.xpath("//h2[contains(text(),'Payment successfull!')]"));
		
		
		
	}
	
	public String getCreditCardDetail(int iChildField,int igetLastDigits) throws IOException {
		//// CSS for the field
		String cssOfField = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(" + iChildField + ")";
		//// Get the field value
		String sFieldValue = this.driver.findElement(By.cssSelector(cssOfField)).getText();
	    //// Get the last digits
		String sStrippedFieldValue = sfSelenium.getLastDigits(igetLastDigits, sFieldValue);
	    return sStrippedFieldValue;
	}
	   
	
	
	///// Run tests /////
	
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Payment Gateway Project", "Buy a Teddy");
		sfSelenium.createTest("Start Test");
		
		
	}
	
	public void runTestAutoGeneratedData () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test with autoGenerated data");
		// Input test Data
		String pQuantity = "2";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "";
		String pCVV = "";
		String pExpMonthYear = "";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		clickGenerateCardNumber();
		//Get Credit Card Details
		// Switch to tab 1
		sfSelenium.switchTab(1);
		// Get Credit Card number
		pCardNumber = getCreditCardDetail(3,16);
		// Get Cvv number
		pCVV = getCreditCardDetail(4,3);
		// Get Month/Year 
		pExpMonthYear = getCreditCardDetail(5,7);
		// Get Year
		pExpYear = getCreditCardDetail(5,4);
		// Get Year
		pExpMonth = sfSelenium.getFirstDigits(2, pExpMonthYear);
		
		// Switch back to the original tab
		sfSelenium.switchTab(0);
	
		//CreditCardDetails();
		
		capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
		clickPay();
			
		Thread.sleep(5000);
		String tablexpath = "//table/tbody";
		
		
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));

		System.out.println("Total Number of cells/columns in the table are: "+TotalColsList.size());
		
		String firstCell = "//tbody/tr[1]/td[1]";
		System.out.println(driver.findElement(By.xpath(firstCell)).getText());
		

	}
	
	public void clickCheckCreditCardLimit() {
		sfSelenium.clickLink("Check Credit Card Limit");
	}
	
	public void captureDetails( String pCredNo) throws IOException {
		// Capture Card Number
		sfSelenium.populateInputField(By.name("card_nmuber"), pCredNo);
	}
	
	public void clickSubmit() {
		this.driver.findElement(By.xpath("//input[@value='submit']")).click();
	}
	
	public void runNewTestAlert() throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: demo alerts");

		// Enter an invalid card number
		String pCardNumber = "5154";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		clickCheckCreditCardLimit();
		
		captureDetails(pCardNumber);
		
		clickSubmit();
		
		// explicit wait for the alert to appear
		this.wait.until(ExpectedConditions.alertIsPresent());
		
		// create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		Thread.sleep(500);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(500);
	}
	
	public void runTestAlert () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: demo alerts");
		// Input test Data
		String pQuantity = "9";
		// Enter an invalid card number
		String pCardNumber = "134665";
		String pExpMonth = "06";
		String pExpYear = "2024";
		String pCVV = "333";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		//clickGenerateCardNumber();
		
		capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
		clickPay();

		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		Thread.sleep(500);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(500);
		
		//sfSelenium.CloseSelenium();
	}
	
//	public void runMyTestAlert () throws IOException, InterruptedException {
//
//		sfSelenium.createTest("Run Test: My Test alert");
//		// Input test Data
//		// Enter an invalid card number
//		String pCardNumber = "5454";
//		String pBogusMessage = "sfdgsdfsdgf";
//		String pExpectedMessage = "Check card number is 16 digits!";
//		// End of - Input Test Data
//		
//		// Keywords
//		navigateToURL(pURL);
//		
//		clickPaymentGateway();
//		
//		this.driver.findElement(By.linkText("Check Credit Card Limit")).click();		
//		
//		sfSelenium.switchTab(-1);
//		
//		sfSelenium.populateInputField(By.id("card_nmuber"), pCardNumber);
//		
//		this.driver.findElement(By.name("submit")).click();
//
//		//Create an object of the alert
//		Alert alert = this.driver.switchTo().alert();
//		
//		String sAlertMessage = alert.getText();
//		System.out.println(sAlertMessage);
//		Thread.sleep(500);
//		alert.accept();
//		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
//		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
//		
//		Thread.sleep(500);
//		
//		//sfSelenium.CloseSelenium();
//	}
//	
	
	public void creditlimt() throws InterruptedException {
	
	String pBogusMessage = "sfdgsdfsdgf";
	String pExpectedMessage = "Check card number is 16 digits!";
	String pCardNumber="1234";
	navigateToURL(pURL);
	
	clickPaymentGateway();
	
  this.driver.findElement(By.linkText("Check Credit Card Limit")).click();	
  
  sfSelenium.populateInputField(By.id("card_nmuber"), pCardNumber);
  
 this.driver.findElement(By.name("submit")).click();
 
	Alert alert = this.driver.switchTo().alert();
	
	String sAlertMessage = alert.getText();
	System.out.println(sAlertMessage);
	
	Thread.sleep(500);
	alert.accept();
	sfSelenium.updateReport(sAlertMessage,pBogusMessage);
	sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
	
	Thread.sleep(500);
}
	
	
	public void runTestToolTip () throws IOException, InterruptedException {
		
		sfSelenium.createTest("Run Test: Tool tips");
		// Input test Data
		String pQuantity = "9";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "2024";
		String pCVV = "333";
		String pExpMonthYear = "";
		String pBogusMessage = "sfdgsdfsdgf";
		String pExpectedMessage = "Check card number is 16 digits!";
		// End of - Input Test Data
		
		// Keywords
		navigateToURL(pURL);
		
		clickPaymentGateway();
		
		selectQuantity(pQuantity);
		
		clickBuyNow();
		
		clickGenerateCardNumber();
		
		
		clickPay();

		//Create an object of the alert
		Alert alert = this.driver.switchTo().alert();
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		//Thread.sleep(5000);
	}
	
	public void runTestReadFromFile () throws IOException, InterruptedException {

		sfSelenium.createTest("Run Test: Read From File");
		// Input test Data
		String pQuantity = "3";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "";
		String pCVV = "";
		String csvdir = getProperties("csvdir"); 
				
		BufferedReader br = new BufferedReader(new FileReader(csvdir)); 
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
		    // use xx as separator.
			    String[] cols = line.split(";"); 
			    System.out.println(cols[0]); 
			    pCardNumber = cols[0];
			    pCVV = cols[1];
			    pExpMonth = cols[2];
			    pExpYear = cols[3];
				navigateToURL(pURL);
				
				clickPaymentGateway();
				
				selectQuantity(pQuantity);
				
				clickBuyNow();
				
			    capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
			    
			    clickPay();   
			}
		    
		} 
		
	}
	
	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();
		
		
	}

	
}




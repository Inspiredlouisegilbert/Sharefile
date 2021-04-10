package PaymentGateway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkclasses.SeleniumFunctions;

public class PaymentGatewayKeywords {
	
// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	// driver variable
	WebDriver driver;
	// Set URL
	String pURL = "http://demo.guru99.com";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
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
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
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
		driver.findElement(By.name("submit")).click();
	}
	
	// Go to the card generate
	public void clickGenerateCardNumber() throws IOException {
		// click buy now
		sfSelenium.clickLink("Generate Card Number");
			
		//take a screen shot
		sfSelenium.logScreenShot();
			
		}
	
	// Get the payment details
	public void getCreditCardDetails() throws IOException {
		//// Get Card Number
		//// Switch focus to tab next/new tab/ browser winder
		sfSelenium.switchTab(1);
		
		//// Credit Card Number
		getCreditCardDetail(3,16);
		//// CSS for the generated card number
		String cssCreditCardNumber = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(3)";
		//// Get the credit card number
		String sCreditCardNumber = driver.findElement(By.cssSelector(cssCreditCardNumber)).getText();
		//// Print the sCreditCardNumber to view it
	    System.out.println(sCreditCardNumber);
	    //// Get the last 16 digits
	    String sStrippedCardNumber = sfSelenium.getLastDigits(16, sCreditCardNumber);
	    //// CVV number
	    //// CSS for the generated cvv number
	    String cssCvv = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(4)";
	    //// Get the CVV number
	    String sCvv = driver.findElement(By.cssSelector(cssCvv)).getText();
	    //// Print the CVV to view it
	    System.out.println(sCvv);
	    //// Get the last 3 digits
	    String sStrippedCvv = sfSelenium.getLastDigits(3, sCvv);
	    
	    //// Year
	    String cssYear = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(5)";
	    //// Get the YEAR
	    String sYear = driver.findElement(By.cssSelector(cssYear)).getText();
	    //// Print the YEAR to view it
	    System.out.println(sYear);
	    //// Get the last xx digits
	    String sStrippedYear = sfSelenium.getLastDigits(4, sYear);
	    
	    //// Month
	    String cssMonth = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(5)";
	    //// Get the Month
	    String sMonth = driver.findElement(By.cssSelector(cssMonth)).getText();
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
	 	//driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//h2[contains(text(),'Payment successfull!')]"));
		
	}
	
	public String getCreditCardDetail(int iChildField,int igetLastDigits) throws IOException {
		//// CSS for the field
		String cssOfField = "body.subpage:nth-child(2) section.wrapper:nth-child(3) div.inner > h4:nth-child(" + iChildField + ")";
		//// Get the field value
		String sFieldValue = driver.findElement(By.cssSelector(cssOfField)).getText();
	    //// Get the last digits
		String sStrippedFieldValue = sfSelenium.getLastDigits(igetLastDigits, sFieldValue);
	    return sStrippedFieldValue;
	}
	   
	
	
	///// Run tests /////
	
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
	}
	
	
	public void runTestAutoGeneratedData () throws IOException, InterruptedException {

		
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
		
		//sfSelenium.CloseSelenium();
	}
	
	public void runTestAlert () throws IOException, InterruptedException {

		
		// Input test Data
		String pQuantity = "9";
		// Enter an invalid card number
		String pCardNumber = "111";
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
		
		clickGenerateCardNumber();
		
		capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
		clickPay();

		//Create an object of the alert
		Alert alert = driver.switchTo().alert();
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		Thread.sleep(5000);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		Thread.sleep(5000);
		
		//sfSelenium.CloseSelenium();
	}
	
	public void runTestToolTip () throws IOException, InterruptedException {
		
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
		Alert alert = driver.switchTo().alert();
		String sAlertMessage = alert.getText();
		System.out.println(sAlertMessage);
		//Thread.sleep(5000);
		alert.accept();
		sfSelenium.updateReport(sAlertMessage,pBogusMessage);
		sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
		
		//Thread.sleep(5000);
	}
	
	public void runTestReadFromFile () throws IOException, InterruptedException {

		// Input test Data
		String pURL = "http://demo.guru99.com";
		String pQuantity = "3";
		String pCardNumber = "";
		String pExpMonth = "";
		String pExpYear = "";
		String pCVV = "";
		

		BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\creditCard.csv")); 
		String line;
		while ((line = br.readLine()) != null) { 
		    // use xx as separator 
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
	
	public void cleanup () throws IOException, InterruptedException {
		// set the value for driver
		this.driver = sfSelenium.getDriver();

		
		sfSelenium.CloseSelenium();
	}

	
}



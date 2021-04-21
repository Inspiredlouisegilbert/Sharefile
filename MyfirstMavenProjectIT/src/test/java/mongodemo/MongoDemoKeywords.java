package mongodemo;

import java.io.IOException;
import java.rmi.UnknownHostException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworkclasses.SeleniumFunctions;

import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;

public class MongoDemoKeywords {
	
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com/test/table.html";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	// setup db
	public void getCollection(String dbname, String collectionName) throws UnknownHostException {
		
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost",27017);
			
		System.out.println("MongoDB: Connection established");
		
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB(dbname);
		DBCollection coll = db.getCollection(collectionName);
		DBCursor cursor = coll.find();
		String line = null;
		while(cursor.hasNext())
		{
			int i=1;
			line = cursor.next().toString();
			//System.out.println(line);
			String[] cols = line.split("\""); 
			
		    String firstColumn = cols[9];
		    System.out.println("firstColumn " + firstColumn); 
		    String secondColumn = cols[13];
		    System.out.println("secondColumn " + secondColumn); 

			i++;
		}
			
		System.out.println("MongoDB: Connection closed");
		
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
	
	public void setupMongodb() throws IOException  {
		sfSelenium.createTest("Run Test: Setting up MongoDB");
		getCollection("myfirst","myfirstcollection");
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




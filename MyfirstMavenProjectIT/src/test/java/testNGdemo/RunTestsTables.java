package testNGdemo;

import java.io.IOException;


import org.testng.annotations.*;

import PaymentGateway.PaymentGatewayKeywords;
import Tablesdemo.TablesDemoKeywords;



public class RunTestsTables {
	

	// Create an instance of the TablesDemoKeywords class
	TablesDemoKeywords tbKeywords = new TablesDemoKeywords();


		
		@Test
		public void Test6() throws IOException, InterruptedException {
		
			System.out.println("test: tabless");
			tbKeywords.tabless();
		}
		
		@BeforeClass
		public void BeforeClass() throws IOException, InterruptedException {
			System.out.println("----Before Class: Tables---");
			tbKeywords.runTestStart();
		}
		
		@AfterClass
		public void AfterClass() throws IOException, InterruptedException {
			System.out.println("----After Class: Tables----");
			tbKeywords.cleanup();
		}
		
		@BeforeMethod
		public void BeforeEachTest() throws IOException, InterruptedException {
			System.out.println("Before Each Tables Test");
		}
		
		@AfterMethod
		public void AfterEachTest() throws IOException, InterruptedException {
			System.out.println("After Each Tables Test");
		}
			

		
}

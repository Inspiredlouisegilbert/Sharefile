package testNGdemo;

import java.io.IOException;


import org.testng.annotations.*;

import PaymentGateway.PaymentGatewayKeywords;
import Tablesdemo.TablesDemoKeywords;



public class RunTestsPaymentGateway {
	
	// Create an instance of the PaymentGatewayKeywords class
	PaymentGatewayKeywords pgKeywords = new PaymentGatewayKeywords();


		@Test
		public void Test1() throws IOException, InterruptedException {
			System.out.println("test: runTestReadFromFile");
			pgKeywords.runTestReadFromFile();
		}
		
		@Test
		public void Test2() throws IOException, InterruptedException {
			System.out.println("test: runTestAlert");
			pgKeywords.runTestAlert();
		}
		
		
		@BeforeMethod
		public void BeforeEachTest() throws IOException, InterruptedException {
			System.out.println("Before Each PG Test");
		}
		
		@AfterMethod
		public void AfterEachTest() throws IOException, InterruptedException {
			System.out.println("After Each PG Test");
		}
		

		
		@BeforeClass
		public void BeforeClass() throws IOException, InterruptedException {
			System.out.println("----Before Class Payment Gateway----");
			pgKeywords.runTestStart();
		}
		
		@AfterClass
		public void AfterClass() throws IOException, InterruptedException {
			System.out.println("----After Class Payment Gateway----");
			pgKeywords.cleanup();
		}
		
}

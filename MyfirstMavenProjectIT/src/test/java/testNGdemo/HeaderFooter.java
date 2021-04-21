package testNGdemo;

import java.io.IOException;


import org.testng.annotations.*;

import PaymentGateway.PaymentGatewayKeywords;
import Tablesdemo.TablesDemoKeywords;



public class HeaderFooter {
		
		@BeforeSuite
		public void SetUpTest() throws IOException, InterruptedException {
			System.out.println("starting: Regression for Release 101");
		}
		
		@BeforeTest
		public void BeforeAllTest() throws IOException, InterruptedException {
			System.out.println("Before All Tests");
		}
		
		@AfterTest
		public void AfterAllTest() throws IOException, InterruptedException {
			System.out.println("After All PG Tests");
		}
		
		@AfterSuite
		public void TearDownTest() throws IOException, InterruptedException {
			System.out.println("ending: starting: Regression for Release 101");
		}
}

package PaymentGateway;

import java.io.IOException;


import org.testng.annotations.*;



public class TestNGdemo {

		
		
		@BeforeSuite
		public void SetUpTest() {
			//pgKeywords.runTestStart();
			System.out.println("starting");
			
		}
		
		@Test
		public void Test1() throws IOException, InterruptedException {
			System.out.println("test1");
		}
		
		@Test
		public void Test2() throws IOException, InterruptedException {
		
			System.out.println("test2");
		}
		
		@AfterSuite
		public void TearDownTest() throws IOException, InterruptedException {
			System.out.println("ending");
			//pgKeywords.cleanup();
		}
		
	

}

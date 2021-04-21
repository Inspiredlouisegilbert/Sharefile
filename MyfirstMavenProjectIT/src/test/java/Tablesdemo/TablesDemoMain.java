package Tablesdemo;

import java.io.IOException;


public class TablesDemoMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		TablesDemoKeywords tbKeywords = new TablesDemoKeywords();
		
		// call runTest
		tbKeywords.runTestStart();
		tbKeywords.tabless();
		tbKeywords.cleanup();
		//
		
	}

}

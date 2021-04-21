package Tablesdemo;

import java.io.IOException;


public class TablesDemoMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		TablesDemoKeywords pgKeywords = new TablesDemoKeywords();
		
		// call runTest
		pgKeywords.runTestStart();
		pgKeywords.tabless();
		pgKeywords.cleanup();
		//
		
	}

}

package Iframedemo;

import java.io.IOException;


public class IframeDemoMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		IframeDemoKeywords pgKeywords = new IframeDemoKeywords();
		
		// call runTest
		pgKeywords.runTestStart();
		pgKeywords.iframes();
		pgKeywords.cleanup();
		//
		
	}

}

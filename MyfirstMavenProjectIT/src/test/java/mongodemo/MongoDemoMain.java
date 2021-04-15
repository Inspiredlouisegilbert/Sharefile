package mongodemo;

import java.io.IOException;


public class MongoDemoMain {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		// Create an instance of the PaymentGatewayKeywords class
		
		MongoDemoKeywords pgKeywords = new MongoDemoKeywords();
		
		// call runTest
		pgKeywords.runTestStart();
		pgKeywords.setupMongodb();
		pgKeywords.cleanup();
		//
		
	}

}

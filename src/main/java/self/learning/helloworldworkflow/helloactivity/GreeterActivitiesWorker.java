/**
 * Copyright (©) 2017. All rights reserved.
 *
 * @author Raj Kumar Dubey
 */
package self.learning.helloworldworkflow.helloactivity;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;

/**
 * <p>
 * GreeterActivitiesWorker
 * </p>
 * 
 * This class is the activity worker class of "GreeterActivity".
 */
public class GreeterActivitiesWorker {

	/** main function */
	public static void main(String[] args) throws Exception {

		/* create client configuration */
		final ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1400);

		/* create simple workflow object */
		AmazonSimpleWorkflow simpleWorkflow = null;
		try {
			simpleWorkflow = new AmazonSimpleWorkflowClient(config);

			/* we specify the endpoint of AWS SWF which is used while the SWF API */
			simpleWorkflow.setEndpoint("https://swf.us-east-1.amazonaws.com");
			
			final ActivityWorker greeterActivitiesWorker = new ActivityWorker(simpleWorkflow, "ao-test-domain",
					"GreeterActivitiesTaskList");
			greeterActivitiesWorker.addActivitiesImplementation(new GreeterActivityImpl());
			greeterActivitiesWorker.start();
		} catch (final AmazonServiceException ase) {
			/* Print appropriate message for AmazonServiceException */
			System.err.println("Caught an AmazonServiceException while getStackBuilder().");
			System.err.println("Error Message:    " + ase.getMessage());
			System.err.println("HTTP Status Code: " + ase.getStatusCode());
			System.err.println("AWS Error Code:   " + ase.getErrorCode());
			System.err.println("Error Type:       " + ase.getErrorType());
			System.err.println("Request ID:       " + ase.getRequestId());
		} catch (final AmazonClientException ace) {
			/* Print appropriate message for AmazonClientException */
			System.err.println("Caught an AmazonClientException while getStackBuilder().");
			System.err.println("Error Message: " + ace.getMessage());
		}
	}
}

/**
 * Copyright (©) 2017. All rights reserved.
 *
 * @author Raj Kumar Dubey
 */
package self.learning.helloworldworkflow.helloworkflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

import self.learning.helloworldworkflow.helloactivity.GreeterActivityClient;
import self.learning.helloworldworkflow.helloactivity.GreeterActivityClientImpl;

/**
 * <p>
 * GreeterWorkflowImpl
 * </p>
 * 
 * This class is the implement workflow interface
 */
public class GreeterWorkflowImpl implements GreeterWorkflow {
	private GreeterActivityClient operations = new GreeterActivityClientImpl();

	/**
	 * <p>
	 * greet
	 * </p>
	 * 
	 * This function will greet the workflow using the activities
	 */
	public void greet() {
		/* get the name */
		final Promise<String> name = operations.getName();

		/* get the greeting */
		final Promise<String> greeting = operations.getGreeting(name);

		/* greet the user */
		operations.say(greeting);
	}
}

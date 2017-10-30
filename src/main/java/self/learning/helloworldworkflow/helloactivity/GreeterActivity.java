/**
 * Copyright (©) 2017. All rights reserved.
 *
 * @author Raj Kumar Dubey
 */
package self.learning.helloworldworkflow.helloactivity;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/**
 * <p>
 * GreeterActivity
 * </p>
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300, defaultTaskStartToCloseTimeoutSeconds = 10)
@Activities(version = "1.0")
public interface GreeterActivity {

	/**
	 * <p>
	 * getName
	 * </p>
	 * This function will get the name
	 */
	String getName();

	/**
	 * <p>
	 * getGreeting
	 * </p>
	 * This function will get the greeting
	 */
	String getGreeting(final String name);

	/**
	 * <p>
	 * say
	 * </p>
	 * This function will say the greeting
	 */
	void say(final String what);
}

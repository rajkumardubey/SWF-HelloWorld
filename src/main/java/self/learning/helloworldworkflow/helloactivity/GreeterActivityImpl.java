/**
 * Copyright (©) 2017. All rights reserved.
 *
 * @author Raj Kumar Dubey
 */
package self.learning.helloworldworkflow.helloactivity;

/**
 * <p>
 * GreeterActivityImpl
 * </p>
 */
public class GreeterActivityImpl implements GreeterActivity {
	
	/**
	 * <p>
	 * getName
	 * </p>
	 * This function will get the name
	 */
	@Override
	public String getName() {
		return "World";
	}

	/**
	 * <p>
	 * getGreeting
	 * </p>
	 * This function will get the greeting
	 */
	@Override
	public String getGreeting(final String name) {
		return "Hello " + name;
	}

	/**
	 * <p>
	 * say
	 * </p>
	 * This function will say the greeting
	 */
	@Override
	public void say(final String what) {
		System.out.println(what);
	}

}

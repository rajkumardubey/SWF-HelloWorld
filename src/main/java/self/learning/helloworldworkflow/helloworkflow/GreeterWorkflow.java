/**
 * Copyright (©) 2017. All rights reserved.
 *
 * @author Raj Kumar Dubey
 */
package self.learning.helloworldworkflow.helloworkflow;

/**
 * <p>
 * GreeterWorkflow
 * </p>
 */
import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface GreeterWorkflow {
	
	/**
	 * <p>
	 * greet
	 * </p>
	 * 
	 * This function will greet the workflow using the activities
	 */
	@Execute(version = "1.0")
	public void greet();
}

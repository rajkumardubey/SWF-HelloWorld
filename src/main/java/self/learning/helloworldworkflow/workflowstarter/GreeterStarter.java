package self.learning.helloworldworkflow.workflowstarter;

import java.util.UUID;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;

import self.learning.helloworldworkflow.helloworkflow.GreeterWorkflowClientExternal;
import self.learning.helloworldworkflow.helloworkflow.GreeterWorkflowClientExternalFactory;
import self.learning.helloworldworkflow.helloworkflow.GreeterWorkflowClientExternalFactoryImpl;

public class GreeterStarter {

	/** main function */
	public static void main(String[] args) throws Exception {

		final String idOne = UUID.randomUUID().toString();

		/* create client configuration */
		final ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1000);

		/* create simple workflow object */
		final AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
		service.setEndpoint("https://swf.us-east-1.amazonaws.com");

		final StartWorkflowOptions workflowOption = new StartWorkflowOptions();

		/* Set workflow id */
		workflowOption.setTaskList(idOne);

		final GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(service,
				"ao-test-domain");
		final GreeterWorkflowClientExternal starter = factory.getClient("GreeterStarterTaskListLocal" + idOne);

		/* start workflow */
		starter.greet();
	}
}

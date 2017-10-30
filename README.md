# HelloWorldWorkflow

This is a simple java project which utilizes Java SDK of Amazon Webservice to create a greeting simple workflow.

## About the Workflow

This workflow will have 3 activities :

    1. get the name 
    2. get the greeting
    3. say the greeting

These activities run synchronously.

## prerequisites

- Java 1.8
- Maven 3.3.3
- AspectJ Weaver 1.8.6
- AWS SDK 1.11.59
- SWF build tools 1.0

## How to Build & Run

	1. Clone the project from the git ()
	2. Import as a maven project
	3. To enable annotation processing, perform following steps:
		a. In Project Explorer, right-click your project and select Properties.
		b. In the Properties dialog box, navigate to Java Compiler > Annotation Processing.
		c. Check Enable project specific settings (which should also Enable annotation processing, but if it doesn't make sure that this option is also checked). Then choose OK.

![Step to enable annotation processing](http://docs.aws.amazon.com/amazonswf/latest/awsflowguide/images/eclipse-enable-annotation-processing.png)
		
		Note: You will need to rebuild your project after enabling annotation processing.
		
	4. Enabling and Configuring AspectJ
		Next, you should enable and configure AspectJ.
		Certain AWS Flow Framework for Java annotations such as @Asynchronous require AspectJ.
		You don't need to use AspectJ directly, but you must enable it with either load-time weaving or compile-time weaving. (The recommended approach is to use load-time weaving.)
	5. Run GreeterActivitiesWorker.java (Right Click on the file -> Run As -> Java Application )
	6. Run GreeterWorkflowWorker.java (Right Click on the file -> Run As -> Java Application )
	7. Run GreeterStarter.java (Right Click on the file -> Run As -> Java Application )


## How to Enable and Configure AspectJ

### Prerequisites

Before configuring AspectJ, you need the AspectJ version that matches your Java version:

	If you are using Java 8, download the latest AspectJ 1.8.X release.
	If you are using Java 7, download the latest AspectJ 1.7.X release.
	If you are using Java 6, download the latest AspectJ 1.6.X release.

You can download either of these versions of AspectJ from the Eclipse download page.

After you have finished downloading AspectJ, execute the downloaded .jar file to install AspectJ. The AspectJ installation will ask you where you would like to install the binaries, and on the final screen, will provide recommended steps for completing the installation. Remember the location of the aspectjweaver.jar file; you'll need it to configure AspectJ in Eclipse.

### Configuring AspectJ Load-Time Weaving

To configure AspectJ load-time weaving for your AWS Flow Framework for Java project, first designate the AspectJ JAR file as a Java agent, and then configure it by adding an aop.xml file to your project. To add AspectJ as a Java agent:

	1. To open the Preferences dialog box, choose Window, Preferences.
	2. Navigate to Java > Installed JREs.
	3. Select the appropriate JRE and choose Edit.
	4. In the Default VM arguments box, enter the path to the installed AspectJ binary. This will be a path such as /home/user/aspectj1.7/lib/aspectjweaver.jar, depending on your operating system and on the version of AspectJ you downloaded.

		On Linux, macOS, or Unix use:
			-javaagent:/your_path/aspectj/lib/aspectjweaver.jar
		On Windows, use a standard Windows-style path instead:
			-javaagent:C:\your_path\aspectj\lib\aspectjweaver.jar	
![Step for Configuring AspectJ Load-Time Weaving](http://docs.aws.amazon.com/amazonswf/latest/awsflowguide/images/eclipse-aspectj-load-time-weaving.png)
		
		To configure AspectJ for AWS Flow Framework for Java, add an aop.xml file to the project.

#### To add an aop.xml file

	1. In your project's src directory, add a directory named META-INF.
	2. Add a file named aop.xml to META-INF with the following contents.

```xml
	<aspectj>
	   <aspects>
	      <aspect name="com.amazonaws.services.simpleworkflow.flow.aspectj.AsynchronousAspect"/>
	      <aspect name="com.amazonaws.services.simpleworkflow.flow.aspectj.ExponentialRetryAspect"/>
	   </aspects>
	   <weaver options="-verbose">
	     <include within="MySimpleWorkflow.*"/>
	   </weaver>
	</aspectj>
```
	The value of <include within=""/> depends on how you name your project's packages. The above example assumes that the project's packages followed the pattern MySimpleWorkflow.*. Use a value appropriate for your own project's packages.

### AspectJ Compile-Time Weaving

To enable and configure AspectJ compile-time weaving, you must first install the AspectJ developer tools for Eclipse, which are available from [http://www.eclipse.org/aspectj/downloads.php](http://www.eclipse.org/aspectj/downloads.php).

#### To install the AspectJ Developer Tools in Eclipse
	
	1. On the Help menu, choose Install New Software.
	2. In the Available Software dialog box, enter http://download.eclipse.org/tools/ajdt/version/dev/update, where version represents your Eclipse version number. For example, if you are using Eclipse 4.6, you would enter: http://download.eclipse.org/tools/ajdt/46/dev/update.

	Important: Be sure that the AspectJ version matches your Eclipse version, or installation of AspectJ will fail.
	3. Choose Add to add the location. Once the location is added, the AspectJ developer tools will be listed.

![AspectJ developer tools ](http://docs.aws.amazon.com/amazonswf/latest/awsflowguide/images/eclipse-install-ajdt.png)
	
	4. Choose Select All to select all of the AspectJ developer tools, then choose Next to install them.
	
	Note: You will need to restart Eclipse to complete the installation. 

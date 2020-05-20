package com.myOrganization.testCases;

import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
import com.myOrganization.core.TestBase;



public class SoapRequestTest extends TestBase {
	

	
	@Test
	public void soapRequestTest() throws XmlException, IOException, SoapUIException {
		
		WsdlProject projectToRun= new WsdlProject(System.getProperty("user.dir")+"\\src\\test\\resources\\projectXMLs\\EmployeeWebService-SoapProject-soapui-project.xml");
		List<TestSuite> testSuites = projectToRun.getTestSuiteList();
		
	    for( TestSuite suite : testSuites ) {
	    	
	    	if(!suite.isDisabled()) {
	    		
	        List<TestCase> testCases = suite.getTestCaseList();    	
	        
	        for( TestCase testCase : testCases ) {
	            log.debug("Running SoapUI test [" + testCase.getName() + "]");
		
	           if(!testCase.isDisabled()) {
			TestRunner runner=testCase.run(new PropertiesMap(), false);
			log.debug(runner.getStatus());
			log.debug(runner.getReason());
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
			
			log.debug("Test case---"+testCase+ "---successfully executed");
			Reporter.log("Test case---"+testCase+ "---successfully executed");
			
	           }  else {
	        	   log.debug("The test case--- "+testCase+"  Has been SKIPPED ");
	        	   throw new SkipException("Skipping the test step as  the test step is Disabled in setup");
	        	   
	           }
	        }
	} else {
		log.debug("The test suite--- "+suite+"  Has been SKIPPED ");
 	   throw new SkipException("Skipping the test step as  the test step is Disabled in setup");
 	   

}

	}
}
}
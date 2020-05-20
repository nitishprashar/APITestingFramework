package com.myOrganization.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.myOrganization.core.TestBase;
import com.myOrganization.utilities.MonitoringMail;
import com.myOrganization.utilities.TestConfig;

import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {
	
public String messageBody;
	

	public void onTestStart(ITestResult argO) {  

		test= rep.startTest(argO.getName().toUpperCase());
		
		
	}  
	  
	public void onTestSuccess(ITestResult argO) {  

		test.log(LogStatus.PASS, argO.getName().toUpperCase()+"----PASS");
		rep.endTest(test);
		rep.flush();
	}  
	  
	public void onTestFailure(ITestResult argO) {  
	
	
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	
	test.log(LogStatus.FAIL, argO.getName().toUpperCase()+"----Failed with Exception : "+argO.getThrowable());

	
	rep.endTest(test);
	rep.flush();
	
	}  
	  
	public void onTestSkipped(ITestResult argO) {  
	// TODO Auto-generated method stub  
	test.log(LogStatus.SKIP, "Skip of test cases and its details are : "+argO.getName());  
	rep.endTest(test);
	rep.flush();
	
	}  
	  

	public void onTestFailedButWithinSuccessPercentage(ITestResult argO) {  
	// TODO Auto-generated method stub  
	test.log(LogStatus.FAIL, "Failure of test cases and its details are : "+argO.getName());  
	rep.endTest(test);
	rep.flush();
	
	}  
	
	public void onFinish(ISuite arg0) {  
	
	MonitoringMail mail = new MonitoringMail();
	 
	try {
		messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
				+ ":8080/job/DataDrivenFrameworkProject/Extent_20Reports_20for_20DataDriverFramework_20Project/";
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		log.debug("Reports have been emailed");
	
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	rep.endTest(test);
	rep.flush();

	
}
	
}

package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementaion implements ITestListener {
    
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println("================Execution of Test Script Started============ "+ methodName );
		test = report.createTest(methodName+" ================Execution of Test Script Started============ "); //This is for returning extent Test
	}

	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		//System.out.println("=============Execution of Test Script Success============ "+ methodName );
	    test.log(Status.PASS, methodName+ "=============Execution of Test Script Success============ ");
	}

	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		//System.out.println("==============Execution of Test Script Failed ===================="+ methodName );
		System.out.println(result.getThrowable()); //Print the Exception
	    
		//I have to take scrrenshot
		String screenShotName =methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		WebDriverUtility wUtil= new WebDriverUtility();
		try {
			String path = wUtil.takesScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path); //Go to the ScreenShot Folder and attach to report 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, methodName+"==============Execution of Test Script Failed ====================");
	}

	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		//System.out.println("==================Execution of Test Script Failed================== "+ methodName );
		//System.out.println(result.getThrowable()); //Print the Exception
		test.log(Status.SKIP, methodName+"==================Execution of Test Script Failed================== ");
	    test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	System.out.println("=======================Execution Started============================");
	//Extent Report Configuration step
	ExtentSparkReporter htmlReporter= new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
	   htmlReporter.config().setDocumentTitle("vTiger Execution Report");
	   htmlReporter.config().setTheme(Theme.DARK);
	   htmlReporter.config().setReportName("Automation Execution Report");
	
	report= new ExtentReports();
	report.attachReporter(htmlReporter);
	report.setSystemInfo("Base URL", "http://localhost:8888/");
	report.setSystemInfo("BaseBrowser", "FireFox");
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush(); // Actually Genreate the report by packing like AssetAll Method i.e its the end now 
		
		System.out.println("========================Execution Finished=============================");
	}	
}

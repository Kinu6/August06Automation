package GenericUtilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ObjectRepositiories.HomePage;
import ObjectRepositiories.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
    public WebDriver driver= null;
	public WebDriverUtility wUtil= new WebDriverUtility();
	public JavaUtility jUtil= new JavaUtility();
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public DataBaseUtility dUtil= new DataBaseUtility();
	
    public static WebDriver sDriver; //For Listeners
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteMethod() {
		System.out.println("DB connection Sucessful");
	}
	
	@BeforeClass(groups = "SmokeSuite,RegressionSuite")
	public void beforeclassMethod() throws IOException {
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER=pUtil.readDataFromPropertyFile("browser"); 
		
		if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		sDriver= driver; //Once browser is launched we will initialize it
		wUtil.maximizeWindow(driver);
		wUtil.implicitWaits(driver);
		driver.get(URL);	
	}
	
	@BeforeMethod(groups = "SmokeSuite,RegressionSuite")
	public void beforeMethod() throws IOException{
		String PWD = pUtil.readDataFromPropertyFile("password");
		String UN = pUtil.readDataFromPropertyFile("username");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(UN, PWD);
		System.out.println("Login to app Sucessful");
		
	}
	@AfterMethod(groups = "SmokeSuite,RegressionSuite")
	public void afterMethod() {
		HomePage hp= new HomePage(driver);
		hp.signOutMethod(driver);
		System.out.println("Sign Out Sucessful");
	}
	
	@AfterClass(groups = "SmokeSuite,RegressionSuite")
	public void afterClassMethod() {
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterSuite(groups = "SmokeSuite,RegressionSuite")
	public void afterSuiteMethod() {
		System.out.println("DB Connection Closed");
	}
	
}

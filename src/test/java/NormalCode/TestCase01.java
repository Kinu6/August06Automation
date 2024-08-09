package NormalCode;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.IConstantUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepositiories.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase01{

@Test	
	public void methodTC01() throws EncryptedDocumentException, IOException {
		
		WebDriverUtility wUtil= new WebDriverUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		JavaUtility jUtil= new JavaUtility();
		
		//For Browser Action
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		wUtil.maximizeWindow(driver);
		
		//Step 1: Launching browser
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2: Home Page to Create Contact
		HomePage hp= new HomePage(driver);
		 WebElement createContact = hp.getContactTab();
		 System.out.println(createContact.getText());
		wUtil.waitForElementToBeClickable(driver, createContact);
		createContact.click();
		
		//Step 2a: Create Contact to new Contact icon
		
		WebElement newContacticon=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		wUtil.waitForElementToBeVisisble(driver, newContacticon);
		newContacticon.click();
		
		// Step 3: new  contact Icon to Create New contact Page
		wUtil.implicitWaits(driver);
		WebElement newContact =driver.findElement(By.name("lastname"));
		wUtil.waitForElementToBeVisisble(driver, newContact);
		String lastName= eUtil.readDataFromExcelFile("contacts", 1, 2)+jUtil.getRandomNumber();
		newContact.sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 4: SignOut Operation
		
		WebElement adminIcon= hp.getAdminIcon();
		hp.signOutMethod(driver);
		
		/*Actions actOn= new Actions(driver);
		actOn.moveToElement(adminIcon).perform();
		adminIcon.click();*/
		System.out.println("BYE BYE");
		driver.close();
		
	}

}

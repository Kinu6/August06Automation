    package NormalCode;
    
	import java.io.IOException;
	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
    import org.testng.annotations.Listeners;
    import org.testng.annotations.Test;
	import GenericUtilities.BaseClass;
	import GenericUtilities.ExcelFileUtility;
	import GenericUtilities.JavaUtility;
	import GenericUtilities.PropertyFileUtility;
	import GenericUtilities.WebDriverUtility;
	import ObjectRepositiories.HomePage;
	import io.github.bonigarcia.wdm.WebDriverManager;

	@Listeners(GenericUtilities.ListenersImplementaion.class)

	public class TC01BaseClass extends BaseClass{
	@Test	(groups = "RegressionSuite")
		public void methodTC01() throws EncryptedDocumentException, IOException {
		   
			//Step 2: Home Page to Create Contact
			HomePage hp= new HomePage(driver);
			wUtil.waitForElementToBeClickable(driver, hp.getContactTab());
			hp.getContactTab().click();
			
			//Step 2a: Create Contact to new Contact icon
			WebElement newContacticon=driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
			wUtil.waitForElementToBeClickable(driver, newContacticon);
			newContacticon.click();
			
			// Step 3: new  contact Icon to Create New contact Page
			wUtil.implicitWaits(driver);
			WebElement newContact =driver.findElement(By.name("lastname"));
			String lastName= eUtil.readDataFromExcelFile("contacts", 1, 2)+jUtil.getRandomNumber();
			newContact.sendKeys(lastName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		}
}


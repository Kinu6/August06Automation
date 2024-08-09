package ObjectRepositiories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   @FindBy (name="user_name") private WebElement UserNameEdt;	
   @FindBy (name="user_password") private WebElement PasswordEdt;
   @FindAll ({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']") }) private WebElement SubmitBtn;
   
   // Create Constructor and initialize it
   public LoginPage(WebDriver driver) {
	   PageFactory.initElements(driver,this);
   }

   // Create getters for same
   public WebElement getUSERNAME() {
   	return UserNameEdt;
   }
   public WebElement getPASSWORD() {
   	return PasswordEdt;
   }
   public WebElement getSUBMIT() {
   	return SubmitBtn;
   }

   //Create Business Library

   /**
    * This Method is for Logging In
    * @param userName
    * @param password
    */
   public void loginToApp(String USERNAME, String PASSWORD) {
   	UserNameEdt.sendKeys(USERNAME);
   	PasswordEdt.sendKeys(PASSWORD);
   	SubmitBtn.click();
   }  

}

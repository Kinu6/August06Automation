package ObjectRepositiories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(linkText = "Organizations") private WebElement orgTab;
	@FindBy(linkText = "Contacts") private WebElement contactTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement adminIcon;
	@FindBy(linkText = "Sign Out") private WebElement signOut;
	
	// Create a constructor
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	public WebElement getOrgTab() {
		return orgTab;
	}
	public WebElement getContactTab() {
		return contactTab;
	}
	public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getsignOut() {
		return signOut;
	}
	
	/**
	 * This Method is for LoggingOut
	 * @param driver
	 */
	public void signOutMethod(WebDriver driver) {
		mouseHoverAction(driver, adminIcon);
	    adminIcon.click();
	    signOut.click();
	}
	
}

package ObjectRepositiories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy (linkText="Contacts") WebElement contactsBtn;
	@FindBy (name="search_text") WebElement searchforTxt;
	@FindBy (name="submit") WebElement submitBtn;
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") WebElement createNewIcon;
	
	public ContactsPage(WebDriver refDriver) {
		PageFactory.initElements(refDriver,this);
	}

	public WebElement getCreateNewIcon() {
		return createNewIcon;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public WebElement getSearchforTxt() {
		return searchforTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	/**
	 * This Method searches for already created Organizations
	 * @param orgName
	 */
    public void searchContacts(WebDriver driver, String CONTACTS, String ORGNAME) {
	 searchforTxt.sendKeys(CONTACTS);
	 submitBtn.click();
	 driver.findElement(By.linkText("+ORGNAME+")).click();
	
    }
    
    /**
     * This Method Clicks on Contacts Icon
     */
    public void clickOnContactsIcon() {
    	createNewIcon.click();
    }

}

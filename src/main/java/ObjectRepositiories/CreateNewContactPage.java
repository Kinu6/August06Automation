package ObjectRepositiories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;


public class CreateNewContactPage extends WebDriverUtility{

	@FindBy(name="lastname") private WebElement LastNameTxt;
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")private WebElement OrgLookupIcon;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement SaveBtn;
	@FindBys({@FindBy(id="search_txt"),@FindBy(name="search_text")}) private WebElement OrgSearchTxt;
	@FindBy(name="search")private WebElement OrgSearchBtn;
	@FindBy(xpath = "//select[@name='leadsource']") private WebElement LeadSource;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public WebElement getLastNameTxt() {
		return LastNameTxt;
	}

	public WebElement getOrgLookupIcon() {
		return OrgLookupIcon;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getOrgSearchTxt() {
		return OrgSearchTxt;
	}
	
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	public WebElement getLeadSource() {
		return LeadSource;
	}


/**
 * This Method creates new contact with mandatory Field
 * @param CONTACT_NAME
 */
	public void createNewContact(String CONTACT_NAME) {
		LastNameTxt.sendKeys(CONTACT_NAME);
		SaveBtn.click();
	}

	/**
	 *  This Method create new contact by selecting created organisation  
	 * @param LASTNAME
	 * @param driver
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver, String LASTNAME, String ORGNAME) {
		LastNameTxt.sendKeys(LASTNAME);
		OrgLookupIcon .click();
		switchToWindow(driver,"Accounts");
		
		OrgSearchTxt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
}

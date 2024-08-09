package ObjectRepositiories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']") WebElement CreateOrganizationsIcon;
	@FindBy (name="search_text") WebElement SearchTxt;
	@FindBy (name="submit") WebElement SubmitBtn;
	
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganizationsIcon() {
		return CreateOrganizationsIcon;
	}

	public WebElement getSearchTxt() {
		return SearchTxt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	// Business Library
	/**
	 * This Method searches for already created Organisation
	 * @param orgName
	 */
	public void searchOrganisation(WebDriver driver,String ORGNAME) {
	SearchTxt.sendKeys(ORGNAME);
	SubmitBtn.click();
	driver.findElement(By.linkText("+ORGNAME+")).click();
	}
	
	/**
	 * This Method will click on organizations Look up Image
	 */
	public void clickonCreateOrganisationLookupImage() {
	CreateOrganizationsIcon.click();
	}
	
}
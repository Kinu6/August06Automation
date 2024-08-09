package ObjectRepositiories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import GenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility{

	@FindBy (name="accountname") private WebElement OrgNameTxt;
	@FindBy (name="industry") private WebElement IndustryDD;
	@FindBy (name="accounttype")private WebElement TypeDD;
	@FindBy (xpath="//input[@title='Save [Alt+S]']") private WebElement SaveBtn;
	
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameTxt(){
		return OrgNameTxt;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * This Method will create an Organisation with Mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganisation(String ORGNAME) {
		OrgNameTxt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
 /**
  * This Method Create organisation with industry DD
  * @param ORGNAME
  * @param INDUSTRY_NAME
  */
	public void createNewOrganisation(String ORGNAME,String INDUSTRY_NAME ) {
		OrgNameTxt.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY_NAME,IndustryDD );
		SaveBtn.click();
	}
	
	/**
	 * This Method creates Organisation with Industry and Type DD
	 * @param ORGNAME
	 * @param INDUSTRY_NAME
	 * @param TYPE_NAME
	 */
	
	public void createNewOrganisation(String ORGNAME,String INDUSTRY_NAME, String TYPE_NAME ) {
		OrgNameTxt.sendKeys(ORGNAME);
		handleDropDown(TYPE_NAME, TypeDD);
		handleDropDown(INDUSTRY_NAME, IndustryDD);
		SaveBtn.click();
	}	
	
}

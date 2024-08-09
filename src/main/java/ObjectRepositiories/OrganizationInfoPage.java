package ObjectRepositiories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy (name="Edit") private WebElement EditBtn;
	@FindBy (name="Duplicate") private WebElement DuplicateBtn;
	@FindBy (name="Delete")private WebElement DeleteBtn;
	
	@FindBy (xpath ="//span[@class='dvHeaderText']")private WebElement OrgHeaderTxt;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getDuplicateBtn() {
		return DuplicateBtn;
	}

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
	
	/**
	 * This Method will get the header text and return it to caller
	 * @return
	 */
	public String getOrgHeader() {
		return OrgHeaderTxt.getText();
	}
	
}

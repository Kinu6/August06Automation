package NormalCode;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import ObjectRepositiories.ContactsInfoPage;
import ObjectRepositiories.ContactsPage;
import ObjectRepositiories.CreateNewContactPage;
import ObjectRepositiories.HomePage;

@Listeners(GenericUtilities.ListenersImplementaion.class)
public class TC03BaseClass extends BaseClass
{
	@Test(groups = "SmokeSuite,RegressionSuite"/*retryAnalyzer =  GenericUtilities.RetryAnalyserImplementation.class*/)
	public void methodForTC03() throws EncryptedDocumentException, IOException {
		     
	         HomePage hp= new HomePage(driver);	
	         hp.getContactTab().click();
	
	         ContactsPage cp= new ContactsPage(driver);
		     wUtil.waitForElementToBeClickable(driver, cp.getCreateNewIcon());
	         cp.getCreateNewIcon().click();
	         
		     CreateNewContactPage cncp= new CreateNewContactPage(driver);
		     String LASTNAME= eUtil.readDataFromExcelFile("contacts", 7, 2)+jUtil.getRandomNumber();
		     String LEADSOURCE= eUtil.readDataFromExcelFile("contacts",7, 3);
		     wUtil.handleDropDown(LEADSOURCE, cncp.getLeadSource());
		     cncp.createNewContact(LASTNAME);
		     
		    
		     ContactsInfoPage cip= new ContactsInfoPage(driver);
		     String verifyheader= cip.getContactHeader();
		     System.out.println(verifyheader);
		     
		     assertEquals(verifyheader.contains(LASTNAME), true);	     
	}
	
	@Test
	public void demoOrg() {
		System.out.println("This is Demo");
	}
	
}

package NormalCode;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import ObjectRepositiories.ContactsInfoPage;
import ObjectRepositiories.ContactsPage;
import ObjectRepositiories.CreateNewContactPage;
import ObjectRepositiories.HomePage;

@Listeners(GenericUtilities.ListenersImplementaion.class)

public class TC02BaseClass extends BaseClass {

@Test(retryAnalyzer =  GenericUtilities.RetryAnalyserImplementation.class)
public void methodForTC02() throws EncryptedDocumentException, IOException {
	
         HomePage hp= new HomePage(driver);	
         hp.getContactTab().click();
	
	     ContactsPage cp= new ContactsPage(driver);
	     cp.getCreateNewIcon().click();
	     
	     CreateNewContactPage cncp= new CreateNewContactPage(driver);
	     String LASTNAME= eUtil.readDataFromExcelFile("contacts", 4, 3);
	     String ORGNAME= eUtil.readDataFromExcelFile("contacts", 4 , 2);
	     cncp.createNewContact(driver, LASTNAME, ORGNAME); // I have to create Organisation first
	     
	     ContactsInfoPage cip= new ContactsInfoPage(driver);
	     String verifyheader= cip.getContactHeader();
	     assertEquals(verifyheader.contains(ORGNAME), true);
	     
}
	
}

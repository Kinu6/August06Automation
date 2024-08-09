package GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
//Window
/**
 * This method is for Maximizing Window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
/**
 * This is for minimising Window    
 * @param driver
 */
	public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
    }
//SYNC
	
/**
 * This Method will wait for element to be clickable WebDriverWait
 * @param driver
 * @param ele
 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
/**
 * This Method will wait for 20ms for visibilty of this element
 * @param driver
 * @param ele
 */
	public void waitForElementToBeVisisble(WebDriver driver, WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
/**
 * This method is for implicit waits	
 * @param driver
 */
public void implicitWaits(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

//Alert
/**
 * Accepting the Alert
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * Dismissing the alert
 * @param driver
 */
public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * This Method is for reading Text of Alert
 * @param driver
 */
public void readAlert(WebDriver driver) {
	driver.switchTo().alert().getText();
}
	
//Actions Class
/**
 * This Method double clicks at current Mouse Location
 @param driver
 */
public void doubleClickAction(WebDriver driver) {
	Actions acton= new Actions(driver);
	acton.doubleClick().perform();
}
/**
 * This Method double Clicks at element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement ele) {
	Actions acton= new Actions(driver);
	acton.doubleClick(ele).perform();
}
/**
 * This method is for dragandDrop
 * @param driver
 * @param source
 * @param target
 */
public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	Actions acton= new Actions(driver);
	acton.doubleClick(source).perform();
	acton.moveToElement(target).perform();
	acton.release(target);
	//acton.dragAndDrop(source, target).perform();
	
}
/**
 * This Method is for mouseHovering
 * @param driver
 * @param ele
 */
public void mouseHoverAction(WebDriver driver, WebElement ele) {
	Actions actOn= new Actions(driver);
	actOn.moveToElement(ele).perform();
	
}

//Robot Class 
/**
 * This Method is for pressing Enter Key of KeyBoard
 * @param driver
 * @throws AWTException
 */
public void pressEnterKey(WebDriver driver) throws AWTException {
	Robot rBot= new Robot();
	rBot.keyPress(KeyEvent.VK_ENTER);
	
}
/**
 * This Method is for releasing Enter Key of KeyBoard
 * @param driver
 * @throws AWTException
 */
public void releaseEnterKey(WebDriver driver) throws AWTException {
	Robot rBot= new Robot();
	rBot.keyRelease(KeyEvent.VK_ENTER);
	
}
//	FRAMES
/**
 * This Method is for Handling Frame by Index
 * @param driver
 * @param index
 */
public void handleFrameByIndex(WebDriver driver, int index) {
	driver.switchTo().frame(index);
}

/**
 * This Method is for Handling Frames using 
 * @param driver
 * @param NameorId
 */
public void handleFrameByNameorId(WebDriver driver, String NameorId) {
	driver.switchTo().frame(NameorId);
}
/**
 * This Method is for Handling Frame By Index
 * @param driver
 * @param ele
 */
public void handleFrameByIndex(WebDriver driver, WebElement ele) {
	driver.switchTo().frame(ele);
}
/**
 * This Method is for switching to Parent Frame
 * @param driver
 */
public void handleFrameByIndex(WebDriver driver) {
	driver.switchTo().parentFrame();
}

// Select Class
/**
 * This method will handle drop down by Index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element, int index) {
	Select sel= new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will handle drop down by value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element, String value) {
   Select sel= new Select(element);
   sel.selectByValue(value);

}
/**
 * This method will handle drop down by Text
 * @param Text
 * @param element
 */

public void handleDropDown(String Text,WebElement element ) {
	   Select sel= new Select(element);
	   sel.selectByValue(Text);
	}
/**
 * This Method De-selects the Selection
 * @param Text
 * @param element
 */
public void deSelectDropDown(String Text, WebElement element) {
	Select sel= new Select(element);
	sel.deselectByVisibleText(Text);
}
//******************************************************************************//

/**
 * This Method scroll upto a webElement
 * @param driver
 * @param element
 */

public void scrollAction(WebDriver driver,WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int y= element.getLocation().getY();
	js.executeScript("window.scrollby(0,"+y+")",element);
}
/**
 * This Method will take screenshot and save it in screenshot Folder
 * @param driver
 * @param screenshotName
 * @return
 * @throws IOException
 */
public String takesScreenShot(WebDriver driver, String screenshotName ) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File((".\\Screenshots\\")+screenshotName+".png");
	FileUtils.copyFile(src, dest); // Commons IO Dependency
	
	return dest.getAbsolutePath(); // Used for Extent Reports
}

/**
* This Method will perform switching Windows
* @param driver
* @param partialWindowTitle
*/
 public void switchToWindow(WebDriver driver, String partialWindowTitle) {
	//Switch 1: Capture all the window IDs
	 Set<String> winIDs = driver.getWindowHandles();
	 //Switch 2: Navigate to each window
	 for(String win: winIDs) {
	 	//Step3: Switch to window and capture the title
	 	String winTitle = driver.switchTo().window(win).getTitle();
	 	//Step 4: Compare the title with required partial title
	 	if(winTitle.contains(partialWindowTitle)) {
	 		break;
		 }
	 } 
	 }   


	
	
	
	
	
	
	
	
}

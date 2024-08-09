package MethodPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop extends WebDriverUtility{

	public static void main(String[] args) {
		WebElement source = null, target= null;
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverUtility wUtil= new WebDriverUtility();
		
		/*
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		source= driver.findElement(By.id("box2"));
		target= driver.findElement(By.id("box104"));
		wUtil.dragAndDrop(driver, source, target); */
		
		driver.get("https://en.wikipedia.org/wiki/Sheikh_Hasina");
		WebElement ele= driver.findElement(By.partialLinkText("Eden Mohila College"));
		wUtil.scrollAction(driver,ele);
		
	}

}

package MethodPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelRead {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		/*ExcelFileUtility eUtil= new ExcelFileUtility();
		String e= eUtil.readDataFromExcelFile("contacts", 1, 0);
		System.out.println(e);*/
		
		JavaUtility jUtil= new JavaUtility();
		String e=jUtil.getSystemDateInFormat();
		System.out.println(e);
		
	}

}

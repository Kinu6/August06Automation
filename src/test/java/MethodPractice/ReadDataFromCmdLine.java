package MethodPractice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	
	@Test
	public void readData() {
	String e=System.getProperty("browser");
		System.out.println(e);
	}

}

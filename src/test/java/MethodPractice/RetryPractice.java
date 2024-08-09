package MethodPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryPractice {

		@Test(retryAnalyzer =GenericUtilities.RetryAnalyserImplementation.class )
		public void sample()
		{
			Assert.fail();
			System.out.println("Hi");
		}
	
}	
	

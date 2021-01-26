package tests.companies;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import threadLocal.Commonmethods;
import threadLocal.Configuration;

public class SampleTestCases extends Configuration {

	@Parameters({ "browser", "url" })

	@Test
	public void testmethod(String browser, String url) {

		Commonmethods.get().Launching_Application(browser, url);
		Commonmethods.get().Login("nadasele69@gmail.com", "Test@1234");
	}

}

package framework;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Configurattion {
	public ReportUtil reports = new ReportUtil();

	@BeforeSuite
	public void beforeSuite() {
		String appconfigpath = System.getProperty("user.dir") + "\\src\\test\\resources\\Data\\Envinfo.properties";

		Data.appconfiginfo = UtilityMethods.getPropertiesData(appconfigpath);

	}

	@BeforeTest
	public void beforeTest(ITestContext testcontext) {
		reports.initializeReports(testcontext.getCurrentXmlTest().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		// UtilityMethods.closeBrowser();
		reports.creatNodeForTestCase(method.getName());
	}

	@AfterTest
	public void aftertest() {
		reports.finalizeReports();
	}

}

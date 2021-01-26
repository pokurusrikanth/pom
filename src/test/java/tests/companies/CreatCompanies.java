package tests.companies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Configurattion;
import framework.Driver;
import pages.CompaniesPage;
import pages.HomePage;
import pages.LogInPage;
import pages.NewCompanyPage;

public class CreatCompanies extends Configurattion {

	@Test
	public void testmethod(@Optional String browser) throws InterruptedException, IOException {

		Driver driver = new Driver((browser != null ? browser : "chrome"), 20);
		CommonMethods commons = new CommonMethods(driver.getdriver());
		LogInPage login = new LogInPage(driver.getdriver());
		HomePage homepage = new HomePage(driver.getdriver());
		CompaniesPage companypage = new CompaniesPage(driver.getdriver());
		NewCompanyPage newcompany = new NewCompanyPage(driver.getdriver());
		commons.navigate_to_url("http://ui.cogmento.com");
		login.login("nandasele69@gmail.com", "Test@1234");

		if (homepage.homePageDisplayed()) {
			reports.writeReport(Status.PASS, "application  navigated to home page");
		} else {
			reports.writeReport(Status.FAIL, "application not navigated to home page");
			Assert.assertTrue(false, "application not navigated to home page");

		}
		homepage.click_on_companies();
		if (companypage.comaniespagedisplayed()) {
			reports.writeReport(Status.PASS, "application is  navigated companies page", driver.getdriver(),
					"companypage");
		} else {

			reports.writeReport(Status.FAIL, "application is not navigated companies page");
			Assert.assertTrue(false, "application is not navigated companies page");

		}
		companypage.click_on_newcompanybutton();
		if (newcompany.creatNewCompanyElementDisplayed()) {
			reports.writeReport(Status.PASS, "application is  navigated to creat new companypage");

		} else {
			reports.writeReport(Status.FAIL, "application is not navigated to creat new companypage");
			Assert.assertEquals(false, "application is not navigated to creat new companypage");

		}
		Thread.sleep(5000);
		newcompany.click_on_companylogo("companylogo");

	}

	@Test
	public void test2() {
		reports.writeReport(Status.PASS, "appication is navigated to home page");

	}
}

package framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ReportUtil {
	private ExtentReports reports;
	private ExtentTest reportnode;

	public void initializeReports(String testname) {
		UtilityMethods.creat_Folder(Data.Reportfolderpath);
		String resultsFilePath = Data.Reportfolderpath + "\\" + testname + "_" + UtilityMethods.gettimestamp()
				+ ".html";
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(resultsFilePath);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setReportName("execution results for test" + testname);
		htmlreporter.config().enableTimeline(true);

		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);

	}

	public void creatNodeForTestCase(String testcasename) {
		reportnode = reports.createTest(testcasename);
	}

	public void writeReport(Status status, String message) {
		switch (status) {
		case PASS:
			reportnode.log(status.PASS, message);
			break;
		case FAIL:
			reportnode.log(status.FAIL, message);
			break;
		case SKIP:
			reportnode.log(status.SKIP, message);
			break;
		case WARNING:
			reportnode.log(status.WARNING, message);
		default:
			reportnode.log(status.INFO, message);
			break;
		}
	}

	public void writeReport(Status status, String message, WebDriver driver, String imagename) throws IOException {
		switch (status) {
		case PASS:
			reportnode.log(Status.PASS, message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureImage(driver, imagename)).build());
			break;
		case FAIL:
			reportnode.log(Status.FAIL, message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureImage(driver, imagename)).build());
			break;
		case SKIP:
			reportnode.log(Status.SKIP, message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureImage(driver, imagename)).build());
			break;
		case WARNING:
			reportnode.log(Status.WARNING, message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureImage(driver, imagename)).build());
		default:
			reportnode.log(Status.INFO, message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureImage(driver, imagename)).build());
			break;
		}
	}

	public void finalizeReports() {
		reports.flush();
	}

	public String captureImage(WebDriver driver, String imagename) {
		UtilityMethods.creat_Folder(System.getProperty("user.dir") + "\\screenshots");
		imagename = imagename + UtilityMethods.gettimestamp() + "\\.png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String base64string = ts.getScreenshotAs(OutputType.BASE64);
		try {
			Files.move(file, new File(System.getProperty("user.dir") + "\\screenshots\\" + imagename));
		} catch (IOException e) {

		}
		return base64string;
	}

}

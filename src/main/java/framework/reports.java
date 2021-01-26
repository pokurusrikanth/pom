package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reports {

	ExtentReports reports;

	public void intialize_reports(String testname) {
		UtilityMethods.creat_Folder(Data.Reportfolderpath);
		String results_file_path = Data.Datafolderpath + "\\" + testname + "_" + UtilityMethods.gettimestamp()
				+ ".html";

		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(results_file_path);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setReportName("execution results for:" + testname);
		htmlreporter.config().enableTimeline(true);

		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);

	}

}

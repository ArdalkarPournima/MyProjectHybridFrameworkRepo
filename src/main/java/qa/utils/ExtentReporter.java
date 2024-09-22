package qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Test Automation Result Report");
		spark.config().setDocumentTitle("TN Automation Result Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(spark);
		
		
		Properties ConfigProp = new Properties();
		File ConfigPopFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\Config.properties");
		
		try {
		FileInputStream fisConfigPopFile = new FileInputStream(ConfigPopFile);
		ConfigProp.load(fisConfigPopFile);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL",ConfigProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", ConfigProp.getProperty("browsernm"));
		extentReport.setSystemInfo("Email", ConfigProp.getProperty("ValidEmailAddress"));
		extentReport.setSystemInfo("Password", ConfigProp.getProperty("ValidPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	
		
	}
}

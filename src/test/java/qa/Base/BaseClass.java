package qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import qa.utils.Utilities;

public class BaseClass {

	
	WebDriver driver;
	
	public Properties prop;
	public Properties TestDataprop;
	
	public BaseClass ()
	{
		prop= new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\Config.properties");
		
		TestDataprop= new Properties();
		File DatapropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\Testdata\\testdata.properties");
		
		try {
			FileInputStream Datafis= new FileInputStream(DatapropFile);
			TestDataprop.load(Datafis);
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
		
		try {
		FileInputStream fis= new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver initializeBrowserAndOpenAppUrl(String browserName)
	{

		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		
		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.WAIT_TIME));//page has to load within 10sec
		driver.get(prop.getProperty("url"));
		
		return driver;

	}
}

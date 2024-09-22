package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.AccountPage;
import qa.PageObject.HomePage;
import qa.PageObject.LoginPage;
import qa.utils.Utilities;

//updated comment by priya wagh
public class LoginTest extends BaseClass{
	
	LoginPage loginpage;
	AccountPage accountpage;
	//constructor
	public LoginTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{	
		driver =initializeBrowserAndOpenAppUrl(prop.getProperty("browsernm"));
		//passed driver as a parameter because in homepage constructor is parametrized i.e public HomePage(WebDriver driver)		
		HomePage homepage=new HomePage(driver); //above driver is passed here as parameter & constructor from Homepage gets called
		homepage.ClickOnMyAccount();            //driver.findElement(By.xpath("//span[text()='My Account']")).click();
		loginpage = homepage.SelectLoginOption();			//driver.findElement(By.linkText("Login")).click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test (priority=1,dataProvider="ValidCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		
		loginpage.enterEmailAddress(email);//driver.findElement(By.id("input-email")).sendKeys
		loginpage.enterPassword(password); //driver.findElement(By.id("input-password")).sendKeys(password);
		accountpage= loginpage.ClickLoginButton();		//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		//AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.getDisplayStatusOfEditAccountPage(),"View your order history  is not displayed");
		
	}	
	@DataProvider (name="ValidCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		Object [][] data = Utilities.GetDataFromExcel("Login"); //Login is name of excel(below excel)
				return data;
	
	}	 		
		@Test (priority=2)
		public void verifyLoginWithInvalidCredentials()
		{
			//LoginPage loginpage= new LoginPage(driver);
			loginpage.enterEmailAddress(Utilities.generateEmailTimeStamp());		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
			loginpage.enterPassword(TestDataprop.getProperty("invalidPassword"));	//driver.findElement(By.id("input-password")).sendKeys(TestDataprop.getProperty("invalidPassword"));
			loginpage.ClickLoginButton();											//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
			
			String actualWarningmsg = loginpage.retrieveEmailPasswordNotMatchingWarning();
			String expectedwarningmsg = TestDataprop.getProperty("NoMatchEmailAndPassword");
			Assert.assertTrue (actualWarningmsg.contains(expectedwarningmsg), "Expected warning message is not displayed");
		
		}
	/*	
		@Test (priority=3)
		public void verifyLoginWithInvalidEmailAndValidPassword()
		{
			
			LoginPage loginpage= new LoginPage(driver);
			//loginpage.enterEmailAddress(TestDataprop.getProperty("invalidemail"));
			loginpage.enterEmailAddress(Utilities.generateEmailTimeStamp());		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimeStamp());
			loginpage.enterPassword(TestDataprop.getProperty("ValidPassword"));	//driver.findElement(By.id("input-password")).sendKeys(TestDataprop.getProperty("invalidPassword"));
			loginpage.ClickLoginButton();											//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
			String actualWarningmsg = loginpage.retrieveEmailPasswordNotMatchingWarning();
			String expectedwarningmsg = TestDataprop.getProperty("Invalidemailwarning");
			Assert.assertTrue (actualWarningmsg.contains(expectedwarningmsg), "Expected warning message is not displayed");
		
		}*/
		
		@Test (priority=4)
		public void verifyLoginWithvalidEmailAndInvalidPassword()
		{
			
			//LoginPage loginpage= new LoginPage(driver);
			loginpage.enterEmailAddress(prop.getProperty("ValidEmailAddress"));
			loginpage.enterPassword(TestDataprop.getProperty("invalidPassword"));
			loginpage.ClickLoginButton();											//driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
			String actualWarningmsg = loginpage.retrieveEmailPasswordNotMatchingWarning();
			String expectedwarningmsg = TestDataprop.getProperty("NoMatchEmailAndPassword");
			Assert.assertTrue (actualWarningmsg.contains(expectedwarningmsg), "Expected warning message is not displayed");
		
		}
		
		@Test (priority=5)
		public void verifyLoginWithoutCredentials()
		{
		//	LoginPage loginpage= new LoginPage(driver);
			loginpage.ClickLoginButton();
			String actualWarningmsg = loginpage.retrieveEmailPasswordNotMatchingWarning();
			String expectedwarningmsg = TestDataprop.getProperty("NoMatchEmailAndPassword");
			Assert.assertTrue (actualWarningmsg.contains(expectedwarningmsg), "Expected warning message is not displayed");
		
		}
		
}


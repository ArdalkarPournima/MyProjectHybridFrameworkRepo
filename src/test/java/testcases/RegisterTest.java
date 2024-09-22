 package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.AccountSuccessPage;
import qa.PageObject.HomePage;
import qa.PageObject.RegisterPage;
import qa.utils.Utilities;

public class RegisterTest extends BaseClass
{
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver; 
	
	@BeforeMethod 
	public void setup() 
	{
		
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browsernm"));
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnMyAccount();
		
	    registerpage = homepage.ClickOnRegister();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test (priority=1)
	public void VerifyRegisterWithMandates()
	{
		
		registerpage.enterFirstName(TestDataprop.getProperty("FirstName"));
		registerpage.enterLastName(TestDataprop.getProperty("LastName"));
		registerpage.enteremailAddressField(Utilities.generateEmailTimeStamp());
		registerpage.enterTelephoneField(TestDataprop.getProperty("telephone"));
		registerpage.enterpasswordField(prop.getProperty("ValidPassword"));
		registerpage.enterpasswordConfirmField(prop.getProperty("ValidPassword"));
		registerpage.ClickOnprivacyPolicy();
	    accountsuccesspage = registerpage.ClickOncontinueButton();
		
		String ActualSuccessHeading = accountsuccesspage.CheckAccountSuccessText();
		Assert.assertEquals(ActualSuccessHeading,TestDataprop.getProperty("AccountSuccessMessage"),"Failed to load Account success..");
		
	}
	
	@Test (priority=2)
	public void verifyRegisterAccountByProvidingAllFields()
	{
		
		registerpage.enterFirstName(TestDataprop.getProperty("FirstName"));
		registerpage.enterLastName(TestDataprop.getProperty("LastName"));
		registerpage.enteremailAddressField(Utilities.generateEmailTimeStamp());
		registerpage.enterTelephoneField(TestDataprop.getProperty("telephone"));
		registerpage.enterpasswordField(prop.getProperty("ValidPassword"));
		registerpage.enterpasswordConfirmField(prop.getProperty("ValidPassword"));
		registerpage.SelectyesNewsLetterOption();
		registerpage.ClickOnprivacyPolicy();
		accountsuccesspage = registerpage.ClickOncontinueButton();		
		String ActualSuccessHeading = accountsuccesspage.CheckAccountSuccessText();
		Assert.assertEquals(ActualSuccessHeading,TestDataprop.getProperty("AccountSuccessMessage"),"Failed to load Account success... ");
		
	}
	
	@Test (priority=3 )
	public void verifyRegisterwithExistingAccount()
	{
		
		registerpage.enterFirstName(TestDataprop.getProperty("FirstName"));
		registerpage.enterLastName(TestDataprop.getProperty("LastName"));
		registerpage.enteremailAddressField(prop.getProperty("ValidEmailAddress"));
		//driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(prop.getProperty("ValidEmailAddress"));
		registerpage.enterTelephoneField(TestDataprop.getProperty("telephone"));
		registerpage.enterpasswordField(prop.getProperty("ValidPassword"));
		registerpage.enterpasswordConfirmField(prop.getProperty("ValidPassword"));
		registerpage.SelectyesNewsLetterOption();
		registerpage.ClickOnprivacyPolicy();
		registerpage.ClickOncontinueButton();
	
		String ActualWarning = registerpage.retrieveDuplicateEmailWarning();
		Assert.assertTrue(ActualWarning.contains(TestDataprop.getProperty("EmailAlreadyExists")),"Warning message regarding duplicate email is not displayed");
		
		
	
	}
	@Test (priority=4)
	public void verifyRegisterwithoutEnetringDetails()
	{
		
		registerpage.ClickOncontinueButton();	
		
		String ActualPrivacypolicy = registerpage.retrievePrivacyPolicyWarning();
		Assert.assertTrue(ActualPrivacypolicy.contains(TestDataprop.getProperty("PrivacyPolicy")),"Warning message regarding policy is not displayed");
		
		String ActualFirstName = registerpage.retrieveFirstNameWarning();
		Assert.assertTrue(ActualFirstName.contains(TestDataprop.getProperty("FnameWarning")),"Warning message regarding firstName is not displayed");
		
		String ActualLastName = registerpage.retrieveLastNameWarning();
		Assert.assertTrue(ActualLastName.contains(TestDataprop.getProperty("LnameWarning")),"Warning message regarding Lastname is not displayed");
		
		String ActualEmail = registerpage.retrieveEmailWarning();
		Assert.assertTrue(ActualEmail.contains(TestDataprop.getProperty("Invalidemailwarning")),"Warning message E-Mail Address does not appear to be valid!");
		
		String ActualTel = registerpage.TelephoneWarning();
		Assert.assertTrue(ActualTel.contains(TestDataprop.getProperty("TelephoneWarning")),"Warning message regarding Telephone is not displayed");

		String Actualpass = registerpage.PasswordWarning();
		Assert.assertTrue(Actualpass.contains(TestDataprop.getProperty("PasswordWarning")),"Warning message regarding password is not displayed");

	
		
	
	}
	
}

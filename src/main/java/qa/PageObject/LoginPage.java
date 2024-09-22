package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id="input-email")	
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatching;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		//PageFactory provides below line to overcome stale element reference exception
		PageFactory.initElements(driver, this);
	}
	
	//Action Method
	public void enterEmailAddress(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText)
	{
		PasswordField.sendKeys(passwordText);
	}
	public AccountPage ClickLoginButton()
	{
		loginButton.click();
		return new AccountPage(driver);
	}
	public String retrieveEmailPasswordNotMatchingWarning()
	{				
		
		String WarningText=emailPasswordNotMatching.getText();
		return WarningText;
	}
}

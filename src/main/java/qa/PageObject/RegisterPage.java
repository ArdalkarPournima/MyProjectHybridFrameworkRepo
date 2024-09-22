package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement LastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement TelephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicy;

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
//*********************Warning locators*********************************************
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement DuplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement FirstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarning;

	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement PasswordWarning;
	
	
//********************************************Action method************************************
	
	public void enterFirstName(String firstNameText)
	{
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText)
	{
		LastNameField.sendKeys(lastNameText);
	}
	public void enteremailAddressField(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	public void enterTelephoneField(String telephoneText)
	{
		TelephoneField.sendKeys(telephoneText);
	}
	public void enterpasswordField(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	public void enterpasswordConfirmField(String passwordText)
	{
		passwordConfirmField.sendKeys(passwordText);
	}
	
	public void ClickOnprivacyPolicy()
	{
		privacyPolicy.click();
	}
	public AccountSuccessPage ClickOncontinueButton()
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	public void SelectyesNewsLetterOption()
	{
		yesNewsLetterOption.click();
	}
	
	//**********************************warning action methods***************************************
	public String retrieveDuplicateEmailWarning()
	{
		String DuplicateEmailWarningText = DuplicateEmailAddressWarning.getText();
		return DuplicateEmailWarningText;
	}
	public String retrievePrivacyPolicyWarning()
	{
		String PrivacypolicyWarningText = privacyPolicyWarning.getText();
		return PrivacypolicyWarningText;
	}
	
	public String retrieveFirstNameWarning()
	{
		String FirstNameWarningText = FirstNameWarning.getText();
		return FirstNameWarningText;
	} 
	public String retrieveLastNameWarning()
	{
		String LastNameWarningText = LastNameWarning.getText();
		return LastNameWarningText;
	}
	public String retrieveEmailWarning()
	{
		String EmailWarningText = emailWarning.getText();
		return EmailWarningText;
	}
	public String TelephoneWarning()
	{
		String TelWarningText = TelephoneWarning.getText();
		return TelWarningText;
	}
	public String PasswordWarning()
	{
		String PasswordWarningText = PasswordWarning.getText();
		return PasswordWarningText;
	}
	
}

package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
//Objects
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	
	//constructor is created to remove locator's hardcoding from Login.java
	//control came here after declare
	public HomePage(WebDriver driver) //driver from Login is passed here & that driver is assigned to the HomePage Class
	{
		this.driver=driver;
		//PageFactory provides below line to overcome stale element reference exception
		PageFactory.initElements(driver, this); //you can write this like PageFactory.initElements(driver, this);
	}
	
	
//Actions
	
	public void ClickOnMyAccount()
	{
		MyAccountDropMenu.click();
	}
	
	public LoginPage SelectLoginOption()
	{
		LoginDropMenu.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage ClickOnRegister()
	{
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBoxFeild(String productText)
	{
		searchBoxField.sendKeys(productText);
	}
	public SearchPage ClickOnSearchButton()
	{
		searchButton.click();
		return new SearchPage(driver);
	}
	
	
}

package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	//objects
	
	@FindBy (linkText="View your order history")
	private WebElement editYourAccountInformation;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//action methods
	
	public boolean getDisplayStatusOfEditAccountPage()
	{
		boolean displayStatus = editYourAccountInformation.isDisplayed();
		return displayStatus;
	}
}

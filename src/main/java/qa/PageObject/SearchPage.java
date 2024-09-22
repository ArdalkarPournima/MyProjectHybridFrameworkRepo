package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement ValidProductsText;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement NoProductsMessage;
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public boolean displayStatusOfValidProducts()
	{
		boolean displayStatus = ValidProductsText.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductsMessageText()
	{
		String noProductsMessageText = NoProductsMessage.getText();
		return noProductsMessageText;
	}
}

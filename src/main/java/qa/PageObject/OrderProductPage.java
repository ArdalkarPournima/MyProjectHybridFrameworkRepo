package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProductPage {

//*****	
	WebDriver driver;
	
	public OrderProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//webelements
	@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43']/descendant::img")
	private WebElement productimg;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddtoCartbtn;
	
	@FindBy(xpath="//div[text()='Success: You have added ']")
	private WebElement Successtocartmsg;
	
	@FindBy(linkText="shopping cart")
	private WebElement shoppingcartlink;
	//**********************action methods****************************************
	public WebElement ClickOnProduct()
	{
		productimg.click();
		return AddtoCartbtn;
	}
	
	public void ClickOnAddToCartbtn()
	{
		AddtoCartbtn.click();
	}
	public String retrieveSuccessToCartWarning()
	{
		String Shoppingcartmsg = Successtocartmsg.getText();
		return Shoppingcartmsg;
	}
	public void ClickOnShoppingCart()
	{
		shoppingcartlink.click();
	}
}

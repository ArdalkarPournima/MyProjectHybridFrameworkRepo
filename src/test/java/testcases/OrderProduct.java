package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.OrderProductPage;

public class OrderProduct extends BaseClass {
	
	public WebDriver driver;
	//OrderProductPage orderproductpage;
	public OrderProduct()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browsernm"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	 @Test(priority=1)
	public void VerifyOrderProduct() throws InterruptedException 
	{
		/*
		WebElement element = driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43']/descendant::img"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		element.click();
		Thread.sleep(500); 
		orderproductpage.ClickOnAddToCartbtn(); //driver.findElement(By.xpath("//button[@id='button-cart']"));
		*/
		 OrderProductPage orderproductpage = new OrderProductPage(driver);
		 
		 
		 
		 
		 WebElement element = orderproductpage.ClickOnProduct();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView()", element);
		 Thread.sleep(500); 
		 orderproductpage.ClickOnAddToCartbtn();
		 
		 
		 //check if product added to cart
		 String ActualSuccesstoCartmsg = orderproductpage.retrieveSuccessToCartWarning();
		 String expectedSuccesstoCartmsg = TestDataprop.getProperty("ProductAddedToCart");
		 Assert.assertTrue (ActualSuccesstoCartmsg.contains(expectedSuccesstoCartmsg), "shopping cart");
		 Thread.sleep(500); 
		 //click on shopping cart
		 orderproductpage.ClickOnShoppingCart();
		 		 
	}
	
		
	
	
	
	
	
	
}

package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.ProductPage;
import qa.PageObject.SoftAssert;

public class ProductTest extends BaseClass{

	
	 ProductPage productPage;

	 public ProductTest()
		{
			super();
		}
		
		public WebDriver driver;
		

	    @Test
	    public void testProductList() 
	    {
	        productPage = new ProductPage(driver);
	        List<WebElement> products = productPage.getProductList();

	        SoftAssert softAssert = new SoftAssert();
	        for (WebElement product : products) {
	            softAssert.assertTrue(product.isDisplayed());
	        }
	        softAssert.assertAll();
	    }
	    
	    
	    @Test
	    public void testGetRandomProduct() {
	        productPage = new ProductPage(driver);
	        String productName = productPage.getProductNameAtRandomIndex();
	        double productPrice = productPage.getProductPriceAtRandomIndex();

	        System.out.println("Randomly selected product: " + productName + " - $" + productPrice);
	    }
	
}

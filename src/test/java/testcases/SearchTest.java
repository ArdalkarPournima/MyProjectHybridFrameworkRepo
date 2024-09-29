package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.HomePage;
import qa.PageObject.SearchPage;

public class SearchTest extends BaseClass{
	SearchPage searchpage;
	public WebDriver driver;
	public SearchTest()
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
	
	@Test (priority=1)
	public void verifySearchWithValidProduct()
	{
		HomePage homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBoxFeild(TestDataprop.getProperty("ValidProduct"));
		
		searchpage = homepage.ClickOnSearchButton(); 
		Assert.assertTrue(searchpage.displayStatusOfValidProducts(),"Valid products not found");
		
	}
	
	@Test (priority=2)
	public void verifySearchWithInValidProduct()
	{
		HomePage homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBoxFeild(TestDataprop.getProperty("InvalidProduct"));
		searchpage=homepage.ClickOnSearchButton();
		
	   // searchpage = new SearchPage(driver);
		String searchMessage=searchpage.retrieveNoProductsMessageText();
		//changes done here
		Assert.assertEquals(searchMessage,TestDataprop.getProperty("ProductMismatchWarning"),"No valid product displayed");
	
		
	}

	@Test (priority=3,dependsOnMethods= {"verifySearchWithInValidProduct"})
	public void verifySearchWithoutAnyProduct()
	{
		HomePage homepage = new HomePage(driver);
		searchpage = homepage.ClickOnSearchButton();				//driver.findElement(By.xpath("//div[@id=\"search\"]/descendant::button")).click();
		String searchMessage=searchpage.retrieveNoProductsMessageText();
		Assert.assertEquals(searchMessage,TestDataprop.getProperty("ProductMismatchWarning"),"No valid product displayed");
	
	}
	
}

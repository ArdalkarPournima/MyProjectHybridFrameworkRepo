package qa.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductPage {

	WebDriver driver;
	WebDriverWait wait;
	

	By productList = By.xpath("//div[@class='product-list']");
    By productItems = By.xpath("//div[@class='product-list']//div[@class='product-item']");
	
	public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
    return driver.findElements(productItems);
}

public WebElement getProductAtRandomIndex() {
    List<WebElement> products = getProductList();
    int randomIndex = (int) (Math.random() * products.size());
    return products.get(randomIndex);
}

public String getProductNameAtRandomIndex() {
    WebElement randomProduct = getProductAtRandomIndex();
    return randomProduct.findElement(By.xpath(".//h2")).getText();
}

public double getProductPriceAtRandomIndex() {
    WebElement randomProduct = getProductAtRandomIndex();
    return Double.parseDouble(randomProduct.findElement(By.xpath(".//span[@class='price']")).getText().replace("$", ""));
}
    
}

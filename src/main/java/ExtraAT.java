import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import qa.utils.Utilities;

public class ExtraAT {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.WAIT_TIME));//page has to load within 10sec
		driver.get("https://demo.opencart.com/en-gb/catalog/desktops");
	//	driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
	//	driver.get("https://testautomationpractice.blogspot.com/");
		/*		
	//mouseover actions	
	//MouseOver action =MoveToElement
					WebElement desktop=driver.findElement(By.xpath("//a[@class=\"nav-link dropdown-toggle\"][@data-bs-toggle=\"dropdown\"]"));
				
					WebElement mac = driver.findElement(By.xpath(" //a[@class=\"nav-link\"][@href=\"https://demo.opencart.com/en-gb/catalog/desktops/mac\"]"));	
					
					Actions act = new Actions(driver);
					act.moveToElement(desktop).moveToElement(mac).click().build().perform();//build will create an action & perform will complete that action
					
	//RightClick = ContextClick()
						
					WebElement rcbutton = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
					
					Actions act = new Actions(driver);
					//rightclick 
					act.contextClick(rcbutton).perform();
					
					//Click on copy button
					driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//close alert box
					driver.switchTo().alert().accept();
	
	
	//doubleClick--NA
		driver.switchTo().frame("iframeResult");
		
		WebElement db = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));	
		
		Actions act = new Actions(driver);
		act.doubleClick(db).perform();
		

		
		//Drag & Drop--1)Source Element 2)Target Element
		
		
		Actions act = new Actions(driver);
		
		WebElement Drag = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement Drop = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		
		act.dragAndDrop(Drag, Drop).perform();
		
		
		
		//JavascriptExecuter = without using sendkeys(), click() action methods
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.WAIT_TIME));//page has to load within 10sec
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement nm = driver.findElement(By.xpath("//input[@id=\"name\"]"));
		WebElement rd = driver.findElement(By.xpath("//input[@value=\"male\"]"));
		JavascriptExecutor js = driver;
		
		js.executeScript("arguments[0].setAttribute('value','pournima')", nm); //input into textbox name
		js.executeScript("arguments[0].click()", rd); //click on radio button
		
	//Scrolling ways
	  	
		//1) Scrolling bar = which is not part of the webpage but a browser
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].window.scrollby(0,2500)", "");
			System.out.println(js.executeScript("return window.pageYoffset;"));
	  
	
		//2) scrollpage  till element gets visible
			WebElement we = driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-end\"]"));
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", we);
		
		//3) scrollpage  till end of the page
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollby(0,document.body.scrollHeight)");
			System.out.println(js.executeScript("return window.pageYoffset;"));
		
		
		//3) scrollpage  till initial position of page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollby(0,-document.body.scrollHeight)");
		
		
//ZoomIn ZoomOut webpage
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom=''50%");
		js.executeScript("document.body.style.zoom=''90%");
		
		
//Upload Files
		//give file location in sendkeys("location-filename")
	 
	 	
//Headless browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver=new ChromeDriver(options);		
	
		
//Run tests in incognito mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				
				WebDriver driver=new ChromeDriver(options);		
			*/	
					
		
		
	}

}

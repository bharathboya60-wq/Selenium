package test;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.List;
import java.util.stream.Collectors;

import junit.framework.Assert;


public class Ecommerece {
	
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver = new EdgeDriver();
	
	EdgeOptions ep = new EdgeOptions();
	driver.manage().window().maximize();
	
	System.out.println("Browser Name "+ ep.getBrowserName());
	
	String LoginMail = "Thalaivar@shivaji.com";
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
	
	driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	
	driver.findElement(By.id("userEmail")).sendKeys(LoginMail);
	driver.findElement(By.cssSelector("[placeholder='enter your passsword']")).sendKeys("Thalaivar@27");
	
	driver.findElement(By.name("login")).click();
	
	
	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	String SucceesfulLoginMessage = ele.getText();
	String ExpectedSuccessfulLoginMessage = "Login Successfully";
	Assert.assertEquals(ExpectedSuccessfulLoginMessage, SucceesfulLoginMessage);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
	
	List<WebElement> Items = driver.findElements(By.className("card-body"));
	List<WebElement> Buttons = driver.findElements(By.xpath("//*[text()=' Add To Cart']"));
	
	for(int i=0;i<Items.size();i++) {
		String ItemName = Items.get(i).findElement(By.tagName("h5")).getText();
		if(ItemName.equals("ZARA COAT 3")) {
			WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Add To Cart']")));
			Buttons.get(i).click();
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
			break;
		}	
	}
	
	driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
	wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/client/#/dashboard/cart"));
	Assert.assertEquals("https://rahulshettyacademy.com/client/#/dashboard/cart", driver.getCurrentUrl());
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/button[text()='Checkout']")));
	
	List<WebElement> CartItems = driver.findElements(By.xpath("//*[@class ='cartSection']/h3"));
	
	List<WebElement> CartI = CartItems.stream().filter(s->(s.getText().equals("ZARA COAT 3"))).collect(Collectors.toList());
	System.out.println("Items in the cart are " + CartI.get(0).getText());
	
	driver.findElement(By.xpath("//li/button[text()='Checkout']")).click();
	
	String Email = driver.findElement(By.xpath("//*[contains(@class, 'user__name')]/label")).getText();
	Assert.assertEquals(LoginMail, Email);
	
	driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("pa");
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class ,'ta-results')]")));
	
	List<WebElement> Options = driver.findElements(By.xpath("//*[contains(@class ,'ta-results')]"));
	
	System.out.println(Options.size());
	System.out.println("Options are filled");
	for(WebElement opt: Options) {
		if(opt.getText().equals("Nepal"));
		{
			opt.click();
			break;
		}
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
	
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	WebElement eleen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	System.out.println(eleen.getText());
	
	
	
		
}
}

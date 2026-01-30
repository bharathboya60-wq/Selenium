
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.Wait;

import junit.framework.Assert;
public class WaitsAssignment {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("Learning@830$3mK2");
		driver.findElement(By.cssSelector("[value='user']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
//		driver.switchTo().alert().accept();
		
		Select s = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("[name='terms']")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("https://rahulshettyacademy.com/angularpractice/shop", driver.getCurrentUrl());
		
		List<WebElement> products = driver.findElements(By.xpath("//app-card"));
//		System.out.println(products.size());
		for(WebElement product : products) {
			product.findElement(By.xpath(".//*/button")).click();
		}
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
//		System.out.println(driver.getPageSource());
		
		Assert.assertTrue(driver.getPageSource().contains("Checkout"));
		Assert.assertTrue(driver.getPageSource().contains("Quantity"));
		
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.ignoring(Exception.class)
				.pollingEvery(Duration.ofMillis(250));
//		
		

	}

}

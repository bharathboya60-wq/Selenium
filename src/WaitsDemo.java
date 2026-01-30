import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitsDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("div[class = 'product']"));
//		System.out.println(products.size());
		List<String> Addedproducts = new ArrayList<>(Arrays.asList("Cucumber","Brocolli","Beetroot"));
//		String[] itemsNeeded = {"Apple","Banana","Mango","Pineapple"};
		for(WebElement product : products) {
			String Po = product.findElement(By.cssSelector(".product-name")).getText();
			if(Addedproducts.contains(Po.split(" ")[0])) {
				product.findElement(By.className("product-action")).click();
//				break;
			}
		}		
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//*[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/seleniumPractise/#/cart"));
//		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']"));
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals("https://rahulshettyacademy.com/seleniumPractise/#/cart", driver.getCurrentUrl());
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		
//		wait.until(ExpectedConditions.)
		

	}

}

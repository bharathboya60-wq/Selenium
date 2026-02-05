package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(5000);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(By.linkText("Discount Coupons"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		
		WebElement Grid = driver.findElement(By.className("tableFixHead"));
		js.executeScript("arguments[0].scrollIntoView(true)", Grid);
		
		
		List<WebElement> Tables = driver.findElements(By.xpath("//div[@class='tableFixHead']//*/tbody/tr"));
		System.out.println(Tables.size());
		int Sum = 0;
		for(WebElement Web: Tables ) {
//			System.out.println("Hello");
			Sum = Sum + Integer.parseInt(Web.findElement(By.xpath("./td[4]")).getText());
		}
		System.out.println("Sum Of Columns "+ Sum);
		
		
		int TotalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);
		
//		Assert.assertEquals(Sum, TotalAmount+1);
		
		Assert.assertEquals(Sum, TotalAmount);
		
		

		
		
		
		

	}

}

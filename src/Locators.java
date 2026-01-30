import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.time.Duration;
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Bharath");
//		driver.findElement(By.pla("Password")).sendKeys("Bhar");
		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.className("error")).getText());
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Thalaiver");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Kabali@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Shivaji@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).clear();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String Password = GetPassword(driver.findElement(By.cssSelector(".infoMsg")).getText());
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Rajinikanth");
		driver.findElement(By.cssSelector("input[placeholder*='Passw']")).sendKeys(Password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'signInBtn')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

	}
	
	public static String GetPassword(String msg) {
		System.out.println("Function to get Password called");
		String[] password = msg.split("'");
		for(String str : password) {
			System.out.println("Inthe Array "+ str);
		}
		System.out.println("Password is: " + password[1]);
		return password[1];
		
	}

}

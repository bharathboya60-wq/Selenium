package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class MultipleWindows {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> It = Windows.iterator();
		It.next();
		driver.switchTo().window(It.next());
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getCurrentUrl());

		String Name = driver.findElements(By.xpath("//h3[contains(@class, 'font-bold')]")).get(0).getText();

		driver.close();

		driver.switchTo().window(parentWindow);

		WebElement NameField = driver.findElement(By.cssSelector("[name='name']"));

		NameField.sendKeys(Name);

		File file = NameField.getScreenshotAs(OutputType.FILE);
		
//		File PageScreenShot = driver.getFullPageScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("ElementScreenShot.png"));

		
		System.out.println("Height of Filed "+ NameField.getRect().getDimension().getHeight());
		
		System.out.println("Height of Filed "+ NameField.getRect().getDimension().getWidth());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		

	}

}

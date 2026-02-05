package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class HttpsCertifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		driver.manage().deleteAllCookies();
		
		driver.manage().deleteCookieNamed("SessionKey");
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("Screenshot.png"));
//		FileUtils.
		
		
		
		
				
		
		

		
		
		
		

	}

}

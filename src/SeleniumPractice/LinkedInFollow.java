package SeleniumPractice;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.asserts.SoftAssert;

public class LinkedInFollow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.linkedin.com/search/results/people/?keywords=talent%20acquisition%20&network=%5B%22O%22%5D&origin=FACETED_SEARCH&sid=7P4");
		Thread.sleep(40000);
		for(int i =0; i< 100; i++) {
			List<WebElement> Elements = driver.findElements(By.xpath("//div[@data-view-name='search-entity-result-universal-template']//span[text()='Follow']"));
			if(Elements.size() == 0) {
				for(WebElement El:Elements) {
					El.click();
				}
			}
			driver.findElement(By.cssSelector("button[aria-label='Next']")).click();
		}
	}

}

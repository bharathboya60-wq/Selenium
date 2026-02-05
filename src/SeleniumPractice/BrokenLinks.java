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


public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException, URISyntaxException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		SoftAssert AS = new SoftAssert();
		for(WebElement Link: Links) {
			String url = Link.getAttribute("href");
			
			if(url== null || url.isEmpty()) {
				continue;
			}
			HttpURLConnection Connect = (HttpURLConnection) new URI(url).toURL().openConnection();
			Connect.setRequestMethod("HEAD");
			Connect.connect();
			int Code = Connect.getResponseCode();
			if(Code>=400) {
				System.out.println(Link.getText());
				System.out.println("Broken Links is: "+ url + " And Response Code is "+ Code);
				AS.assertTrue(false);
//				Assert.assertTrue(false);
			}
		}
		AS.assertAll();
		
		
//		HttpURLConnection Connect = (HttpURLConnection) new URI("https://rahulshettyacademy.com/AutomationPractice/").toURL().openConnection();
//		Connect.setRequestMethod("HEAD");
//		Connect.connect();
//		System.out.println("ResponseCode:"+ Connect.getResponseCode());
		

		
		
		
		

	}

}

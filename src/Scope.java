import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links in the FooterSection " + footerdriver.findElements(By.tagName("a")).size());
		
		WebElement DiscountCoupons = driver.findElement(By.xpath("//*[@id='gf-BIG']//*//tr/td[1]"));
		System.out.println("Links in the First Column of FooterSection " + DiscountCoupons.findElements(By.tagName("a")).size());
		List<WebElement> LinksOne = DiscountCoupons.findElements(By.tagName("a"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		
		for(int j=1; j<LinksOne.size(); j++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			LinksOne.get(j).sendKeys(clickOnLinkTab);
		}
		
		System.out.println("No of Windows Opened " + driver.getWindowHandles().size());
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
		}
		
//		for(WebElement link : Links) {
//			System.out.println(link.getText());
//			link.click();
//			System.out.println(driver.getCurrentUrl());
//			driver.navigate().back();	
//		}
		
//		for(int i=1; i<LinksOne.size(); i++) {
//			WebElement DiscountCoupons2 = driver.findElement(By.xpath("//*[@id='gf-BIG']//*//tr/td[1]"));
//			List<WebElement> Links = DiscountCoupons2.findElements(By.tagName("a"));
//			DiscountCoupons2.findElements(By.tagName("a")).get(i).click();
//			System.out.println(driver.getCurrentUrl());
//			driver.navigate().back();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gf-BIG")));
//		}
//		
		
		
	}

}

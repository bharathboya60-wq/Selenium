import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class AutoSuggestiveDropDownAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String Country = "United Kingdom (UK)";
		driver.findElement(By.cssSelector("[placeholder = 'Type to Select Countries']")).sendKeys("Uni");
		Thread.sleep(3000);
		
		List<WebElement> Options = driver.findElements(By.xpath("//li[@class = 'ui-menu-item']/div"));
		System.out.println(Options.size());
		for(WebElement Opt: Options) {
			System.out.println("Into the loop");
			System.out.println(Opt.getText());
			if(Opt.getText().equals(Country))
			{
				Opt.click();
				break;
			}
		}
		
		
		
				
		
		

		
		
		
		

	}

}

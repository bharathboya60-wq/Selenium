
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.Keys.*;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		Actions Ac = new Actions(driver);
		
		Ac.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList a")))
		.contextClick()
		.build().perform();
		Thread.sleep(5000);
		
		Ac.click(driver.findElement(By.cssSelector("[placeholder = 'Search Amazon']")))
		.keyDown(SHIFT)
		.sendKeys("mobi")
		.keyUp(SHIFT)
		.sendKeys("les")
		.doubleClick()
		.build()
		.perform();
		
		

	}

}

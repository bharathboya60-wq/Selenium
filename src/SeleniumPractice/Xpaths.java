package SeleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class Xpaths {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/a[2]")).getText());
		
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		
	}	

}

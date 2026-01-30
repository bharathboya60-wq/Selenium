import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AngularPractice {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Kaala");
		driver.findElement(By.name("email")).sendKeys("Thalaivar@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Kaala");
		driver.findElement(By.id("exampleCheck1")).click();
		Select s = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		s.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("01-01-1970");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		
		
		
	}

}

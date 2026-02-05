package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.testng.Assert;
public class QaAcdemyAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String OptionText = driver.findElement(By.xpath("//*[@for='benz']")).getText();
		System.out.println(OptionText);
		
		Select Dropdown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		Dropdown.selectByVisibleText(OptionText);
		
		driver.findElement(By.name("enter-name")).sendKeys(OptionText);
		
		driver.findElement(By.cssSelector("[value='Alert']")).click();
		
		driver.switchTo().alert().getText();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		Assert.assertTrue(alert.getText().contains(OptionText));
		alert.accept();
		
        


}
}

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input[placeholder = 'Type to Select']")).sendKeys("in");
		Thread.sleep(2000);
		List<WebElement> options1 = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		System.out.println("Number of options in the Auto-suggestions Dropdown: " + options1.size());
		for (WebElement option : options1) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		Thread.sleep(2000);
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a"));
		System.out.println("Number of options in the Destination Dropdown: " + options.size());
		System.out.println(options.get(0).getText());
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		driver.findElement(By.className("ui-state-active")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));	
		Select dropdown = new Select(staticdropdown);	
		dropdown.selectByIndex(3);	
		System.out.println(dropdown.getFirstSelectedOption().getText());	
		Thread.sleep(2000);
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		Thread.sleep(2000);
		System.out.println("Is the checkbox selected? " + driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
		

		

		
		
		

	}

}

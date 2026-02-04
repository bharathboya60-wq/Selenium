import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class WebTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement Table = driver.findElement(By.xpath("//table[@name='courses']"));
		
		int Columns = Table.findElements(By.xpath(".//*/tr[1]/th")).size();
		int Rows = Table.findElements(By.xpath(".//*/tr")).size();
		System.out.println("No of Columns "+ Columns);
		System.out.println("No of Rows "+ Rows);
		
		
				
		
		

		
		
		
		

	}

}

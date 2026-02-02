
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.Keys.*;

import java.util.Iterator;
import java.util.Set;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		System.out.println(driver.getCurrentUrl());
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Windows Handles");
		for(String handle: windows) {
			System.out.println(handle);
		}
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getCurrentUrl());
		String Mail = driver.findElement(By.cssSelector("strong a")).getText();
		driver.close();
		driver.switchTo().window(parentId);
		
		
		
		

	}

}

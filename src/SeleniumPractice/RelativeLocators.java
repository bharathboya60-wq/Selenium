package SeleniumPractice;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String Text = driver.findElement(with(By.tagName("label")).above(driver.findElement(By.cssSelector("[name='name']")))).getText();
		System.out.println(Text);	
		
		String Text1 = driver.findElement(with(By.cssSelector("[for='exampleFormControlRadio1']")).below(driver.findElement(By.cssSelector("[name='name']")))).getText();
		System.out.println(Text1);
		
		List<WebElement> Labels = driver.findElements(with(By.tagName("label")).below(driver.findElement(By.cssSelector("[name='name']"))));
		System.out.println("Elements found below the selector");
		for(WebElement Label : Labels ) {
			System.out.println(Label.getText());
		}
		
		
		driver.findElement(with(By.tagName("input")).below(driver.findElement(By.cssSelector("[for='dateofBirth']")))).click();
		
		driver.findElement(with(By.tagName("input")).toLeftOf(driver.findElement(By.cssSelector("[for='exampleCheck1']")))).click();
		
		
		System.out.println("Right Of");
		System.out.println(driver.findElement(with(By.cssSelector("[class='form-check-label']")).toRightOf(driver.findElement(By.id("inlineRadio1")))).getText());
		
		

	}

}

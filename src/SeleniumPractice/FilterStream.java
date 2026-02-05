package SeleniumPractice;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;
import org.openqa.selenium.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FilterStream {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		List<WebElement> Items = driver.findElements(By.xpath("//table[contains(@class , 'table-bordered')]/tbody/tr/td[1]"));
		String Product = "Rice";
		int Count = (int) Items.stream().filter(s->s.getText().contains(Product)).count();
		System.out.println(Count);

	}
}

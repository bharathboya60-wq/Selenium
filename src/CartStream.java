import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;
import org.openqa.selenium.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class CartStream {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		driver.findElement(By.linkText("Top Deals"));
		
		driver.findElement(By.cssSelector(".sort-descending")).click();
		List<WebElement> Items = driver.findElements(By.xpath("//table[contains(@class , 'table-bordered')]/tbody/tr/td[1]"));
		
		List<String> Itemss = Items.stream().filter(s->{
			System.out.println(s.getText());
			return true;
		}).map(s-> s.getText()).sorted().collect(Collectors.toList());
		
		
		
//		List<WebElement> ItemsAfterSorted = driver.findElements(By.xpath("//table[contains(@class , 'table-bordered')]/tbody/tr/td[1]"));
		
		System.out.println("Items after sorted");
		
		List<String> SortedItems = Items.stream().filter(s->{
			System.out.println(s.getText());
			return true;
		}).map(s-> s.getText()).collect(Collectors.toList());
		
		boolean comparedValue = Itemss.equals(SortedItems);
		
		System.out.println(comparedValue);
		Assert.assertTrue(comparedValue);
		
		
		
		
			
	}
}

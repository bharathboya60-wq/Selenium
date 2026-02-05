package SeleniumPractice;
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
//		WebDriver driver = new EdgeDriver();
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
////		driver.findElement(By.linkText("Top Deals"));
//		
//		driver.findElement(By.cssSelector(".sort-descending")).click();
//		List<WebElement> Items = driver.findElements(By.xpath("//table[contains(@class , 'table-bordered')]/tbody/tr/td[1]"));
//		
//		List<String> Itemss = Items.stream().filter(s->{
//			System.out.println(s.getText());
//			return true;
//		}).map(s-> s.getText()).sorted().collect(Collectors.toList());
//		
//		
//		
////		List<WebElement> ItemsAfterSorted = driver.findElements(By.xpath("//table[contains(@class , 'table-bordered')]/tbody/tr/td[1]"));
//		
//		System.out.println("Items after sorted");
//		
//		List<String> SortedItems = Items.stream().filter(s->{
//			System.out.println(s.getText());
//			return true;
//		}).map(s-> s.getText()).collect(Collectors.toList());
//		
//		boolean comparedValue = Itemss.equals(SortedItems);
//		
//		System.out.println(comparedValue);
//		Assert.assertTrue(comparedValue);
//		
//		
//		System.out.println("Price of the Apple");
//		Items.stream().filter(s->s.getText().contains("Apple")).map(s-> s.findElement(By.xpath("following-sibling::td[1]"))).forEach(s->System.out.println(s.getText()));
		
		
		

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

		// click on column

		driver.findElement(By.xpath("//tr/th[1]")).click();



		// capture all webelements into list

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));



		// capture text of all webelements into new(original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());



		// sort on the original list of step 3 -> sorted list



		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list

		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;

		// scan the name column with getText ->Beans->print the price of the Rice

		do

		{

		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

		price = rows.stream().filter(s -> s.getText().contains("Rice"))

		.map(s -> getPriceVeggie(s)).collect(Collectors.toList());


		price.forEach(a -> System.out.println(a));

		if(price.size()<1)

		{

		driver.findElement(By.cssSelector("[aria-label='Next']")).click();

		}

		}while(price.size()<1);



		}



		private static String getPriceVeggie(WebElement s) {

		// TODO Auto-generated method stub

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();



		return pricevalue;

		}

	}

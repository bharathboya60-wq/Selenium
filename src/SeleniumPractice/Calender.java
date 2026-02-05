package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;

public class Calender {

	public static void main(String[] args) {
		String Year = "2025";
		String Month = "5";
		String Date = "29";
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__calendar-button")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		
		String DecadeYears = driver.findElement(By.className("react-calendar__navigation__label__labelText")).getText();
		System.out.println("Decaded Year" + DecadeYears);
		String[] years = DecadeYears.split(" – ");
		System.out.println("One "+years[0]);
		System.out.println("Two "+ years[1]);
		
		int Givenyear = Integer.valueOf(Year);
		int GivenMonth = Integer.valueOf(Month);
		int Date1 = Integer.valueOf(years[0]);
		int Date2 = Integer.valueOf(years[1]);
		boolean YearSelected = true;
		if(Givenyear<Date1) {
			while(YearSelected)
			{
				driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
				List<WebElement> YearsOnPage = driver.findElements(By.xpath("//div[@class ='react-calendar__decade-view__years']/button"));
				for(WebElement Y:YearsOnPage) {
					System.out.println(Y.getText());
					if(Y.getText().equals(Year)) {
						Y.click();
						YearSelected = false;
						break;
					}
				}
				
		}	

	}
		else if(Givenyear>Date2)
		{
			while(YearSelected)
			{
				driver.findElement(By.cssSelector(".react-calendar__navigation__next-button")).click();
				List<WebElement> YearsOnPage = driver.findElements(By.xpath("//div[@class ='react-calendar__decade-view__years']/button"));
				for(WebElement Y:YearsOnPage) {
					System.out.println(Y.getText());
					if(Y.getText().equals(Year)) {
						Y.click();
						YearSelected = false;
						break;
					}
	
				}
				
		}	
		}
		else {
			driver.findElement(By.xpath("//button[text() = "+Year+"]")).click();
		}
		
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(GivenMonth-1).click();
		
		List<WebElement> DatesOfMonth = driver.findElements(By.xpath("//button/abbr"));
		String[] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(WebElement WE: DatesOfMonth) {
			System.out.println(WE.getAttribute("aria-label"));
			if(WE.getText().equals(Date)) {
				if(WE.getAttribute("aria-label").contains(Months[GivenMonth-1])) {
					WE.click();
				}
				
			}
			
		}
		
		

}
}

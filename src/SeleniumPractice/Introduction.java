package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BB2712\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new FirefoxDriver();
		String URL = "https://rahulshettyacademy.com/client/#/dashboard/dash";
		driver.get(URL);
		System.out.println(driver.getTitle());
		
		String CurrentPageURL = driver.getCurrentUrl();
		if(URL==CurrentPageURL) {
			System.out.println("URL is correct");
		}
		else {
			System.out.println("URL is incorrect");
		}
		
	}

}

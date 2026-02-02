import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import java.util.Iterator;
import java.util.Set;

public class WindowsAssig {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String text = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(text);
		driver.switchTo().window(parentId);
		String parenttext = driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(parenttext);
		
		
		
		
		
		
		

	}

}

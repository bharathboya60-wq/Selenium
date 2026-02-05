package SeleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
//		driver.findElement(By.id("draggable")).click();
		
		Actions ac = new Actions(driver);
		
//		driver.switchTo().frame(0); // by index
		driver.switchTo().frame(driver.findElement(org.openqa.selenium.By.cssSelector(".demo-frame"))); // by web element
		driver.findElement(By.id("draggable")).click();
		System.out.println(driver.findElement(By.id("droppable")).getText());
		System.out.println("Clicked on draggable");
		ac.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		System.out.println("Drag and Drop Performed");
		System.out.println(driver.findElement(By.id("droppable")).getText());
		
		driver.switchTo().defaultContent();
		
		
		

	}

}

package TestNGPractice;
import org.testng.annotations.*;

public class ParentClass {
	
	@BeforeTest
	public void PntCls() {
		System.out.println("From Parent class");
	}
	
	
	public void Method() {
		System.out.println("Methodsss");
	}
	
	
	

}

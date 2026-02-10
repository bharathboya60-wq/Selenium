package TestNGPractice;
import org.testng.annotations.*;

public class MultipleTestCases {
	
	@BeforeClass
	public void BeforeClassDemo() {
		System.out.println("This is executed before the class from MultipleTEsts");
	}
	
	@AfterClass
	public void AfterClassDemo() {
		System.out.println("This is executed After the class from MultipleTests");
	}
	
//	@BeforeMethod(groups = { "Home"})
	public void BeforeMethodDemo() {
		System.out.println("This the Before MEthod annotation");
	}
	
	
	@AfterTest
	public void AfterTestMethodinDemo() {
		System.out.println("Executed at the last from Multiple Test cases class");
	}
	
	@Parameters({"URL", "NameOfPerson"})
	@Test(groups = "Home", enabled=true)
	public void HomeLoan(String urlName, String NofP) {
		System.out.println("HomeLoan Is available");
		System.out.println("URl is "+urlName );
		System.out.println("Name is "+NofP);
	}
	
	@Test
	public void CarLoan() {
		System.out.println("CarLoan Is available");
	}
	
	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("This is printed the before method");
	}
	
	@Test(groups = "Home", dependsOnMethods = "HomeLoan", enabled=false)
	public void CheckDependOnannotation() {
		System.out.println("This is to check the DependsONAnnotation");
	}

	
}

package TestNGPractice;
import org.testng.annotations.*;
public class Demo1 {
	
	@BeforeClass
	public void BeforeClassDemo() {
		System.out.println("This is executed before the class from Demo");
	}
	
	@AfterClass
	public void AfterClassDemo() {
		System.out.println("This is executed After the class from Demo");
	}
	
//	@AfterTest(groups = "Home")
	public void AfterTestMethodinDemo() {
		System.out.println("Executed at the last");
	}
	
	@Test(groups = "Home",  timeOut = 10000)
	public void Print() {	
		System.out.println("hello From testNg");
	}
	
	@Test
	public void Print1() {
		System.out.println("Demo 2");
	}
	
	@Parameters("NameOfPerson")
	@Test(groups = "Home", dependsOnMethods = {"Print"})
	public void Abcd(String Nof) {
		
		System.out.println("Name of the person form Demo "+Nof);
		System.out.println("Demo 3 Abec");
	}
	
	@BeforeTest
	public void BeforeTestMethodinDemo() {
		System.out.println("This is printed the before method in DEmo class");
	}
	
	@BeforeMethod
	public void BeforeMethodDemo() {
		System.out.println("This the Before MEthod annotation in demo class");
	}
	
	@Test(groups = "Home", dataProvider="DateProvider")
	public void DemoOnDataProvider(String Username, String Password) {
		System.out.println("UserName is "+ Username + "Password is "+ Password);
	}
	
	
	@DataProvider
	public Object[][] DateProvider() {
		Object[][] Data = new Object[3][2];
		Data[0][0] = "FirstUser";
		Data[0][1] = "FirstPassword";
		
		Data[1][0] = "SecondUser";
		Data[1][1] = "SecondPassword";
		
		Data[2][0] = "ThirdUser";
		Data[2][1] = "ThirdPassword";
		
		return Data;
		
		
		
	}
	
	
	

}

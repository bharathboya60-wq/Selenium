package TestNGPractice;

public class ConstructorTest {
	int a; 
	
	
	
	public ConstructorTest() {
		System.out.println("This is called to test the constructros");
	}

	public int Increment() {
		System.out.println("Hello from increment Method");
		System.out.println("Value of a is "+ a);
		a = a+1;
		return a;
		
	}
	
	public int decrement() {
		a = a-3;
		return a;
	}

}

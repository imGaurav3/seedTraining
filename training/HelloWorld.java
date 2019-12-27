package training;
import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeting g = new Greeting();
		g.greet();

	}

}
class Greeting{
	public void greet() {
		System.out.println("Hello world....");
	}
	
}
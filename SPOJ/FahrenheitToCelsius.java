import java.util.Scanner;
	public class FahrenheitToCelsius{
		public static void main(String[] args){
			Scanner input = new Scanner (System.in);
			System.out.print("Enter the degrees in Celsius:");
			double celsius = input.nextDouble();
			double fahrenheit = celsius * 9/5 + 32;
			System.out.println(+ celsius + " degrees Celsius in degrees Fahrenheit is " + fahrenheit);
	}
}
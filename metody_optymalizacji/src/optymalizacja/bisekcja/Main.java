package optymalizacja.bisekcja;

public class Main {
	private static double left = 0;
	private static double right = 10;
	private static double tolerance = 0.0001;

	public static void main(String[] args) {
		Function function = new Function();
		
		Bisection.RecursiveBisection(function, left, right, tolerance);

	}

}

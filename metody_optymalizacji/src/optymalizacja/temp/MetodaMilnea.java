package optymalizacja.temp;

/**
 * ITERACYJNE ROZWIAZYWANIE ROWNAN ROZNICZKOWYCH
 */
public class MetodaMilnea {
	static double a = 0;
	static double b = Math.PI / 2;

	public static void main(String[] args) {

		 System.out.println("Metoda Milne/'a: " + calkujMilneMethod(a, b));
		
	}
	
	/**
	 * calkowanie metoda Milne'a	//// nieskonczona
	 * [7/90 32/90 12/90 32/90 7/90] wspolczynniki
	 */
	public static double calkujMilneMethod(double a, double b) {
		double score = ((b-a)/4) * (14*(f(a)/45) + ((4.0/3.0) * f((b+a)/2)) + (f(b)/3));
		return score;
	}
	
	/**
	 * return cos()
	 */
	public static double f(double x) {
		return Math.cos(x);
	}
}

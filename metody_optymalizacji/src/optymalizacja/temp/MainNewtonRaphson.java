package optymalizacja.temp;

public class MainNewtonRaphson {

	/**
	 * METODA NEWTONA-RAPHSONA
	 * METODA STYCZNYCH
	 * DO ROZWIAZANIA ROWNANIA
	 */
	public static void main(String[] args) {

		double x = 1.75;
		double x1;
		System.out.println(x);
		
		do {
			x1=x;
			x = fi1(x);
			System.out.println(x);
		} while(x1 - x > Math.pow(10, -7));

	}
	
	public static double funct(double x) {
		double wynik = Math.pow(x, 3) + 4*Math.pow(x, 2) - 10;
		return wynik;
	}
	
	public static double fi1(double x) {
		double wynik = x - (funct(x)/pochodna(x));
		return wynik;
	}
	
	//public static double fi2(double x) {
	//	
	//}
	
	public static double pochodna(double x) {
		double wynik = 3*Math.pow(x, 2) + 8*x;
		return wynik;
	}
	
	public static double pochodna2(double x) {
		double wynik = 6*x + 8;
		return wynik;
	}

}

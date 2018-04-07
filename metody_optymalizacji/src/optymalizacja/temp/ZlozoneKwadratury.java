package optymalizacja.temp;

/**
 * Calki oznaczone (Riemanna)
 */
public class ZlozoneKwadratury {
	static double a = 0;
	static double b = Math.PI / 2;
	static double c = 4 * Math.PI;

	public static void main(String[] args) {
//		System.out.println("Zlozona kwadratura Newtona-Cotesa: " + zlKwNewCot(a, c, 20.0));
		System.out.println("Zlozona metoda Simpsona: " + zlKwSimpsona(a, c, 8));
		
	}
	
	/**
	 * calkowanie metoda trapezow
	 */
	public static double calkuj(double a, double b) {
		double score = (b-a) * ((f(a) / 2) + (f(b) / 2));
		return score;
	}
	
	
	
	/**
	 * zlozone kwadratury Newtona-Cotesa
	 */
	public static double zlKwNewCot(double a, double c, double n) {
		double h = (c-a)/n;
		
		double sum = 0;
		for(double i=a+h; i<c; i+=h) {
			sum+= ff(i);
		}
		double score = h* (ff(a) + ff(c) + sum);
		return score;		
	}
	
	public static double zlKwSimpsona(double a, double c, double n) {
		double h = (c-a)/n;		// dzielimy przedzial na n czesci
		
		double sum = 0;
		double mnoznik = 4;
		for(double i=a+h; i<c; i+=h) {
			sum+= mnoznik * ff(i);
			if(mnoznik == 4) mnoznik = 2;
			else if(mnoznik == 2) mnoznik = 4;
		}
		
		double score = h/3 * (ff(a) + ff(b) + sum);
		return score;
	}
	
	/**
	 * return cos()
	 */
	public static double f(double x) {
		return Math.cos(x);
	}
	
	public static double ff(double x) {
		return Math.pow(Math.cos(x), 2);
	}

}

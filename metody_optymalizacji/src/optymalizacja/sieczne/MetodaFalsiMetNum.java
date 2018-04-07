package optymalizacja.sieczne;

/**
 * algorytm rozwi�zywania r�wna� nieliniowych jednej zmiennej.
 * dzielimy sieczne na pol
 */
public class MetodaFalsiMetNum {

	public static void main(String[] args) {
		double[] x = new double[2];
		x[0] = 0;
		x[1] = 2;
		System.out.println(x[0] + " - " + x[1]);
		
		do {
			x = doFalsi(x);
			System.out.println(x[0] + " - " + x[1]);
		} while(x[1] - x[0] > Math.pow(10, -7));

	}
	
	public static double funct(double x) {
		double wynik = Math.pow(x, 3) + 4*Math.pow(x, 2) - 10;
		return wynik;
	}

	
	public static double[] doFalsi(double[] values) {
		double middle = (values[0] + values[1]) / 2;
		
		if(funct(middle)*funct(values[0]) < 0) {
			return new double[]{values[0], middle};
		} else {
			return new double[]{middle, values[1]};
		}
		
	}
	
	public static double[] divide(double[] values) {
		double middle = (values[0] + values[1]) / 2;
		
		if(funct(middle)*funct(values[0]) < 0) {
			return new double[]{values[0], middle};
		} else {
			return new double[]{middle, values[1]};
		}
		
	}

}

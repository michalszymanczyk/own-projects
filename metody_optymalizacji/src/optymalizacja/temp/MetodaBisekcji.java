package optymalizacja.temp;

/**
 * METODA ROWNEGO PODZIALU
 * ROZWIAZYWANIE ROWNAN NIELINIOWYCH
 * dzielisz na pol, sprawdzasz ktora polowka
 */
public class MetodaBisekcji {

	public static void main(String[] args) {
		
		double a = 0.001, b = 2, c = (a + b) / 2;
		double fc = Math.pow(c, 3) + 4 * Math.pow(c, 2) - 10;
		
		do {
			if (fc < 0) {
				a = c;
				c = (a + b) / 2;
				fc = Math.pow(c, 3) + 4 * Math.pow(c, 2) - 10;
			} else {
				b = c;
				c = (b + a) / 2;
				fc = Math.pow(c, 3) + 4 * Math.pow(c, 2) - 10;
			}
			System.out.println("b-a =" + (b - a) + "\t\t x = " + c + "\t\t f(x) =" + fc);
		} while (fc != 0);
	}
}

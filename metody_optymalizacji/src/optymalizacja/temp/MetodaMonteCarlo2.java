package optymalizacja.temp;

/**
 * Ca�kowanie numeryczne metod� Monte Carlo
 */
public class MetodaMonteCarlo2 {

	public static void main(String[] args) {
		double xb = 0; // pocz�tek zakresu
		double xe = Math.PI / 2; // koniec zakresu
		int prob = 1000;
		
		double calka = liczCalkeMC2(xb, xe, prob);
		System.out.println(calka);

	}

	/**
	 * Licz calke wg dokladnosci
	 */
	private static double liczCalkeMC2(double xPocz, double xKon, int ilProb) {
		double calka = 0;

		for (int i = 0; i < ilProb; i++) {
			calka += func(randomPoint(xPocz, xKon));
		}

		calka = (calka / (double) ilProb) * (xKon - xPocz);
		return calka;
	}

	/**
	 * Funkcja dla kt�rej obliczamy ca�k�
	 */
	private static double func(double x) {
		return Math.cos(x);
	}

	private static double randomPoint(double a, double b) {
		return a + Math.random() * (b - a);
	}

}

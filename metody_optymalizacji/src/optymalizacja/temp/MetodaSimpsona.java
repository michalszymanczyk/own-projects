package optymalizacja.temp;

public class MetodaSimpsona {

	/**
	 * Calkowanie metoda simpsona
	 * @param args
	 */
	public static void main(String[] args) {
		// Dok�adniejszy wynik METODA SIMPSONA b-a/3
		double a = 0;
		double b = Math.PI / 2;
		double fa = Math.cos(a);
		double fb = Math.cos(b);
		double score = (Math.PI / 2) * (fa / 2 + fb / 2);
		double fx = Math.cos((b + a) / 2.00);
		score = ((b - a) / 2.00) * ((fa / 3.00) + ((4.00 / 3.00) * fx) + (fb / 3.00));
		System.out.println(score);

		System.out.println("----------------------------------");

	}

}

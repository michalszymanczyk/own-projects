package optymalizacja.temp;

/**
 * 
 * metoda ca�kowania numerycznego
 *
 */
public class KwadraturyGaussa {
	public static void main(String[] args) {
		// KWADRATURY GAUSSA
		System.out.println("KWADRATURA GAUSA");

		// granice ca�kowania
		double a = 0;
		double b = Math.PI * 4;
		double score = 0.0;
		Double[] tabX = { -0.8611363116, -0.3399810436, 0.8611363116, 0.3399810436 };
		Double[] tabT = new Double[4];
		Double[] tabW = { 0.3478548151, 0.6521451549, 0.3478548151, 0.6521451549 };

		for (int i = 0; i < tabX.length; i++) {
			tabT[i] = ((b + a) / 2) + (((b - a) / 2) * tabX[i]);
		}

		for (int i = 0; i < tabT.length; i++) {
			score = score + (tabW[i] * Math.pow(Math.cos(tabT[i]), 2));
		}

		score = score * ((b - a) / 2);

		System.out.println(score);
	}
}

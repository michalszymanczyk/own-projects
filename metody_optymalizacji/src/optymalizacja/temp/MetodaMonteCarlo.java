package optymalizacja.temp;

/**
 * Ca�kowanie numeryczne metod� Monte Carlo
 */
public class MetodaMonteCarlo {

	public static void main(String[] args) {
		double xb = 0;						// pocz�tek zakresu
		double xe = Math.PI / 2;			// koniec zakresu
		int prob = 10000;					// ilosc prob
		
		double calka = liczCalkeWgIlosciProb(xb, xe, prob);
		System.out.println("Wartosc calki: " + calka);
		
		double calka2 = liczCalkeWgDokladnosci(xb, xe, 0.00001);
		System.out.println("Wart calki: " + calka2);		
	}
	
	/**
	 * Licz calke wg dokladnosci
	 */
	private static double liczCalkeWgDokladnosci(double xPocz, double xKon, double dokl) {
		double yPocz = 0;
		double yKon = Math.ceil(Math.max(func(xPocz), func(xKon)));
		int traf = 0;
		double ilProb = 0;
		double calka = 0;
		double calkPoprz;
		double roznica;
		
		do {
			ilProb++;
			traf += funcIn(randomPoint(xPocz, xKon), randomPoint(yPocz, yKon));
			calkPoprz = calka;
			calka = (traf / (double)ilProb) * ((xKon-xPocz) * (yKon-yPocz));
			roznica = Math.abs(calka - calkPoprz);
			System.out.println("calkPoprz - calka = " + (calka - calkPoprz));
		} while(roznica > dokl || calkPoprz == 0);
		
		// ilosc trafionych / ilosc prob * pole prostokata
		return calka;
	}
	
	/**
	 * Licz ca�ke wg ilo�ci pr�b
	 */
	private static double liczCalkeWgIlosciProb(double xPocz, double xKon, double ilProb) {
		double yPocz = 0;
		double yKon = Math.ceil(Math.max(func(xPocz), func(xKon)));
		int traf = 0;
		double calka;
		
		for(int i=0; i<ilProb; i++) {
			traf += funcIn(randomPoint(xPocz, xKon), randomPoint(yPocz, yKon));
		}
		// ilosc trafionych / ilosc prob * pole prostokata
		calka = (traf / (double)ilProb) * ((xKon-xPocz) * (yKon-yPocz));
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

	/**
	 * 1 je�eli punkt le�y nas osi� OY i pod wykresem funkcji ca�kowanej
	 * -1 je�eli punkt le�y po osi� OY i nad wykresem funkcji ca�kowanej
	 * 0 w przeciwnym przypadku
	 */
	private static double funcIn(double x, double y) {
		if ((y > 0) && (y <= func(x)))
			return 1;
		else if ((y > 0) && (y <= func(x)))
			return -1;
		return 0;
	}

}

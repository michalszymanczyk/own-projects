package optymalizacja.styczne;

/**
 * Metoda Newtona (metoda stycznych) - obliczanie zer funkcji nie liniowych na przykladzie wielomianow
 */
public class MainStyczne {
	// stopien wielomianu <==
	private static int n = 4;

	private static int p, q;
	private static double a[];

	public static void main(String[] args) {
		// poczatek przedzialu <==
		double y = -100;
		// koniec przedzialu <==
		double z = 100;
		// liczba iteracji <==
		int l = 100;
		
		int k;
		double c;

		a = new double[n + 1];

		if (n < 2) {
			System.out.println("Za maly stopien wielomianu");
			return;
		}

		// Podaj teraz kolejne wspolczynniki wielomianu. Zaczynij od tego z najwieksza potega
//		for (k = n; k >= 0; k--) {
////			a[k] = Console.readDouble("a" + k);
//		}
		a[1] = 1;
		a[2] = 0;
		a[3] = -1;
		a[4] = 0;

		if (z < y) {
			System.out.println("Koniec przedzialu jest mniejszy od poczatku");
			return;
		}

		p = 1;
		q = n + 1;

		if (pochodna(2, y) * w(0, y) > 0) {
			c = y;
		} else {
			c = z;
		}
		for (k = 1; k <= l; k++) {
			c = c - (w(0, c) / pochodna(1, c));
			if (w(0, c) == 0) {
				break;
			}
		}

		if (w(0, c) == 0) {
			System.out.println("Dokladny pierwiastek wynosi " + c);
		} else {
			System.out.println("Przyblizony pierwiastek wynosi " + c);
		}

		return;
	}

	// algorytm Hornera - obliczanie wartosci wielomianu
	private static double w(int k, double x) {
		if (k == n)
			return a[n];
		else
			return w(k + 1, x) * x + a[k];
	}

	// Algorytm Show-Trauba funkcja pomocnicza s(j)
	private static double s(int j) {
		return (n - j) % q;
	}

	// Algorytm Show-Trauba funkcja pomocnicza r(j)
	private static double r(int j) {
		if (j % q == 0)
			return q;
		else
			return 0;
	}

	// Algorytm Show-Trauba - glowna funkcja
	private static double T(int i, int j, double x) {
		if (x == 0) // by mozna bylo obliczyc pochodna w punkcie x=0
			return a[j];
		else if (j == -1)
			return a[n - i - 1] * Math.pow(x, s(i + 1));
		else if (i == j)
			return a[n] * Math.pow(x, s(0));
		else
			return T(i - 1, j - 1, x) + T(i - 1, j, x) * Math.pow(x, r(i - j));
	}

	private static double pochodna(int stopien, double punkt) {
		if (punkt == 0)
			return T(n, stopien, punkt);
		else
			return T(n, stopien, punkt) / Math.pow(punkt, stopien % q);
	}

}

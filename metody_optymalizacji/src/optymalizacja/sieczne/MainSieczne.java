package optymalizacja.sieczne;

/**
 * Metoda siecznych dla wielomianow
 */
public class MainSieczne {
	// stopien wielomianu <==
	public static int n = 5;
	
	public static double a[];
	public static int p, q;

	public static void main(String[] args) {
		// poczatek przedzialu <==
		double y = -100;
		// koniec przedzialu <==
		double z = 100;
		// liczba iteracji <==
		int l = 100;
		
		int k;
		double c, d, e;
		d = 0;

		// Metoda Siecznych - obliczanie zer funkcji nie liniowych na przykladzie wielomianow
		a = new double[n + 1];
		if (n < 2) {
			System.out.println("Za maly stopien wielomianu");
			return;
		}

		// Podaj teraz kolejne wspolczynniki wielomianu. Zaczynij od tego z najwieksza potega <==
//		for (k = n; k >= 0; k--) {
////			a[k] = Console.readDouble("a" + k);
//		}
		a[1]=1;
		a[2]=-1;
		a[3]=0;
		a[4]=1;
		a[5]=1;				

		if (z < y) {
			System.out.println("Koniec przedzialu jest mniejszy od poczatku");
			return;
		}

		p = 1;
		q = n + 1;

		// pierwsze dwa przyblizenia z regula falsi
		if ((pochodna(1, y) * pochodna(2, y)) < 0) {
			c = z;
			c = c - (w(0, c) / (w(0, y) - w(0, c))) * (y - c);
		} else {
			c = y;
			c = c - (w(0, c) / (w(0, z) - w(0, c))) * (z - c);
		}

		for (k = 1; k < l - 1; k++) {
			if ((w(0, c) == 0) || ((w(0, c) - w(0, d)) == 0)) {
				break;
			}
			e = c;
			c = c - ((w(0, c) * (c - d)) / (w(0, c) - w(0, d)));
			d = e;
		}

		if (w(0, c) == 0) {
			System.out.println("Dokladny pierwiastek wynosi " + c);
		} else {
			System.out.println("Przyblizony pierwiastek wynosi " + c);
		}

		return;

	}

	// algorytm Hornera - obliczanie wartosci wielomianu
	public static double w(int k, double x) {
		if (k == n)
			return a[n];
		else
			return w(k + 1, x) * x + a[k];
	}

	// algorytm Show-Trauba funkcja pomocnicza s(j)
	public static double s(int j) {
		return (n - j) % q;
	}

	// algorytm show-Trauba funkcja pomocnicza r(j)
	public static double r(int j) {
		if (j % q == 0)
			return q;
		else
			return 0;
	}

	// Algorytm Show-Trauba - glowna funkcja
	public static double T(int i, int j, double x) {
		if (x == 0) // by mozna bylo obliczyc pochodna w punkcie x=0
			return a[j];
		else if (j == -1)
			return a[n - i - 1] * Math.pow(x, s(i + 1));
		else if (i == j)
			return a[n] * Math.pow(x, s(0));
		else
			return T(i - 1, j - 1, x) + T(i - 1, j, x) * Math.pow(x, r(i - j));
	}

	public static double pochodna(int stopien, double punkt) {
		if (punkt == 0)
			return T(n, stopien, punkt);
		else
			return T(n, stopien, punkt) / Math.pow(punkt, stopien % q);
	}

}

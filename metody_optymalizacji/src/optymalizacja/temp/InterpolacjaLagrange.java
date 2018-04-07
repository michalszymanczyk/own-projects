package optymalizacja.temp;

/**
 * 
 * interpolacja za pomoc� wielomian�w (interpolacja wielomianowa)
 * wartosc funkcji w punkcie
 * polega na przyblizaniu funkcji za pomoca wielomianow
 *
 */
public class InterpolacjaLagrange {

	public static void main(String[] args) {
		System.out.println("INTERPOLACJA LAGRANGE'A");
		System.out.println("Cos(1.15) = " + Math.cos(1.15));
		double[] f = new double[20];
		double[] x = new double[20];
		double temp = 0;
		double score = 0;
		double temp2;

		for (int i = 0; i < x.length; i++) {
			x[i] = 1 + temp;
			temp = temp + 0.1;
		}

		for (int i = 0; i < f.length; i++) {
			f[i] = Math.cos(x[i]);
		} 
		// interpolacja lagrange
		for (int i = 0; i < x.length; i++) {
			temp2 = 1.0;
			for (int j = 0; j < x.length; j++) {
				if (j != i) {
					temp2 = temp2 * ((1.15 - x[j]) / (x[i] - x[j]));
				}

			}
			score += temp2 * f[i];
			System.out.println(i + ". " + score);
		}
	}
}

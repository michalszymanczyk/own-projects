package optymalizacja.temp;


/**
 * WIELOMIAN FUNKCJI INTERPOLACYJNEJ
 * "POSTAC NEWTONA WIELOMIANU"
 */
public class InterpolacjaNewtona {

	public static void main(String[] args) {
		System.out.println("INTERPOLACJA NEWTONA");
		System.out.println("Cos(1.15) = " + Math.cos(1.15));
		double[] f = new double[20];
		double[] x = new double[20];
		double temp = 0;

		for (int i = 0; i < x.length; i++) {
			x[i] = 1 + temp;
			temp = temp + 0.1;
		}

		for (int i = 0; i < f.length; i++) {
			f[i] = Math.cos(x[i]);
		}

		// interpolacja newtona
		double[][] derivatives = new double[20][20];

		for (int j = 0; j < 20; j++) {
			derivatives[0][j] = x[j];
			derivatives[1][j] = f[j];
		}

		double[] first = new double[20];
		first[0] = 0;
		for (int i = 1; i < first.length; i++) {
			first[i] = f[i] * f[i - 1] / x[i] * x[i - 1];
		}

		double[] second = new double[20];
		second[0] = 0;
		second[1] = 0;

		for (int i = 2; i < second.length; i++) {
			second[i] = first[i] * first[i - 1] / x[i] * x[i - 2];
		}

		double[] third = new double[20];
		third[0] = 0;
		third[1] = 0;
		third[2] = 0;
		for (int i = 2; i < third.length; i++) {
			third[i] = second[i] * second[i - 1] / x[i] * x[i - 2];
		}

		System.out.println(
				"X       F(x)               1st             2nd              3rd\n-------------------------------------------------------------------------------");
		for (int i = 0; i < 20; i++) {
			System.out.println(x[i] + "     " + f[i] + "      " + first[i] + "              " + second[i]
					+ "               " + third[i]);
		}
	}
}

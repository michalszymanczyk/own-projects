package optymalizacja.temp;

public class MetodaTrapezy {
	public static void main(String[] args) {
		// PRZYBLIZONE LICZENIE CA�EK OZNACZONYCH

		// Ca�ka od 0 do pi/2 z cos(x) METODA TRAPEZU
		double a = 0;
		double b = Math.PI / 2;
		double fa = Math.cos(a);
		double fb = Math.cos(b);
		double score = (Math.PI / 2) * (fa / 2 + fb / 2);
		System.out.println(score);
	}
}

package optymalizacja.temp;

public class KwadraturyNewtona {

	public static void main(String[] args) {
//		KWADRATURY (NEWTONA) Z�O�ONE
		System.out.println("KWADRATURA NEWTONA");

//		TRAPEZY Z�O�ONE
		double a = 0;
		double b = Math.PI*4;
		double n = 1000;
		double fa = Math.pow(Math.cos(a), 2);
		double fb = Math.pow(Math.cos(b), 2);	
		double score = 0.0;
		
		double h = (b - a) / n;	// dlugosc odcinka
		
		for(int i = 0; i < 1000; i++ ) {
			score = Math.pow(Math.cos(a + i*h), 2) + score;
		}
		
		score = (score + (fa/2.00) + (fb/2.00)) * h;

		System.out.println(score);
		
//		WERSJA DRUGA

		score = 0;
		
		for(int i = 0; i < 1001; i++ ) {
			if(i % 2 == 0) {
				score = 4 * Math.pow(Math.cos(a + i*h), 2) + score;
			} else {
				score = 2 * Math.pow(Math.cos(a + i*h), 2) + score;
			}
		}
		
		score = (score + (fa/2.00) + (fb/2.00)) * (h/3.00);
		System.out.println(score);
	}
}

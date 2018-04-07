package optymalizacja.bisekcja;

public class Bisection {

	public static double RecursiveBisection(Function fct, final double left, final double right,
			final double tolerance) {
		double x = 0;
		double dx = 0;
		if (Math.abs(right - left) < tolerance) // base case
			return (left + right) / 2;
		else { // recursive case
			x = (left + right) / 2;
			System.out.println("Root obtained: " + x);
			dx = right - left;
			System.out.println("Estimated error: " + dx);
			if (fct.f(left) * fct.f(x) > 0) // on same side
				return RecursiveBisection(fct, x, right, tolerance);
			else // opposite side
				return RecursiveBisection(fct, left, x, tolerance);

		}
	}

}

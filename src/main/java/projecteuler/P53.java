package projecteuler;


public class P53 {
	/**
	 * How many, not necessarily distinct, values of nCr, for 1 n 100, are
	 * greater than one-million?
	 */
	public static void func() {
		int count = 0;
		double[] fact = new double[101];

		fact[0] = fact[1] = 1;
		for (int i = 2; i < 101; i++) {
			fact[i] = fact[i - 1] * i;
		}
		for (int i = 1; i <= 100; i++) {
			int j = 1;
			for (; j <= i / 2; j++) {
				double x = fact[i]/(fact[j]*fact[i-j]);
				if (x > 1000000) {
					break;
				}
			}
			if (j != (i / 2) + 1) {
				count += i - 1 - (j - 1) * 2;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		long i = System.nanoTime();
		func();
		System.out.println((System.nanoTime() - i)/1000000.0);
	}
}

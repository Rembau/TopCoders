package projecteuler;

import projecteuler.tool.MathTool;

public class P12 {
	public static void func() {
		long triangleNum = 0;
		for (int i = 1; true; i++) {
			triangleNum += i;
			int count = getDivisorNum(triangleNum);
			System.out.println(triangleNum);
			if (count >= 500) {
				System.out.println(count);
				System.out.println(triangleNum);
				break;
			}
		}
	}

	public static int getDivisorNum(long n) {
		long i = 1;
		int count = 0;
		int limit = (int) Math.sqrt(n);

		while (i <= limit) {
			if (n % i == 0) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static void func_() {
		int n = 3; // start with a prime
		int Dn = 2; // number of divisors for any prime
		int cnt = 0; // to insure the while loop is entered
		int n1, Dn1, i, exponent;
		int P=500;
		int primearray[]=MathTool.generatePrime(P);
		while (cnt <= 500) {
			n = n + 1;
			n1 = n;
			if (n1 % 2 == 0) {
				n1 = n1 / 2;
			}
			Dn1 = 1;
			for (i = 0; i < P; i++) {
				// If your array indexing starts at 0, change to i=0 and i<P
				if (primearray[i] * primearray[i] > n1) {
					Dn1 = 2 * Dn1;
					System.out.println(primearray[i]);
					break;
				}
				// When the prime divisor would be greater than the residual n1,
				// that residual n1 is the last prime factor with an exponent=1
				// No necessity to identify it.
				exponent = 1;
				while (n1 % primearray[i] == 0) {
					exponent++;
					n1 = n1 / primearray[i];
				}
				if (exponent > 1) {
					Dn1 = Dn1 * exponent;
				}
				if (n1 == 1) {
					break;
				}
			}
			cnt = Dn * Dn1;
			Dn = Dn1;
		}
		System.out.println(n * (n - 1) / 2);
	}

	public static void main(String[] args) {
		func_();
	}

}

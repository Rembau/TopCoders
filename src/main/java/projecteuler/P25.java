package projecteuler;

import java.util.Arrays;

public class P25 {
	/**
	 * first term in the Fibonacci sequence to contain 1000 digits
	 */
	public static void func() {
		int n = 1000;
		int num1[] = new int[n];
		Arrays.fill(num1, 0);
		int num2[] = new int[n];
		Arrays.fill(num2, 0);
		num1[0] = 1;
		num2[0] = 1;
		int current = 1;
		int carry = 0;
		int position=2;
		while (current < n) {
			for (int i = 0; i < current; i++) {
				int s = num1[i] + num2[i]+carry;
				//System.out.println(num1[i]+" "+num2[i]+" "+s+" "+current+" i="+i);
				num2[i] = s % 10;
				carry = s / 10;
				if (i==current-1 && carry > 0) {
					current++;
				}
				//System.out.println(num1[i]+" "+num2[i]+" "+s+" "+current+" i="+i);
			}
			position++;
			int num3[] = new int[n];
			num3 = Arrays.copyOf(num1, current+1);
			num1 = Arrays.copyOf(num2, current+1);
			num2 = num3;
			//System.out.println(" "+current);
			//System.out.println(num1.length +" "+num2.length);
		}
		System.out.println(position);
	}

	public static void main(String[] args) {
		func();
	}

}

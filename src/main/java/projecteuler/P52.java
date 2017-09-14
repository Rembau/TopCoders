package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P52 {
	/**
	 * It can be seen that the number, 125874, and its double, 251748, 
	 * contain exactly the same digits, but in a different order.
	 * 
	 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
	 * contain the same digits.
	 */
	public static void func(){
		label:
		for (int i = 1; true; i++) {
			//System.out.println(i);
			int xx[] = getds(i);
			Arrays.sort(xx);
			for (int j = 2; j < 7; j++) {
				int xx1[] = getds(i*j);
				Arrays.sort(xx1);
				for (int k = 0; k < xx.length; k++) {
					if(xx[k]!=xx1[k]){
						//System.out.println("C");
						continue label;
					}
				}
			}
			System.out.println("i = "+i+" "+2*i+" "+3*i+" "+4*i+" "+5*i+" "+6*i);
			return;
		}
	}
	static int[] getds(int n){
		int dn = MathTool.getDigitNum(n);
		int ds[] = new int[dn];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = n%10;
			n=n/10;
		}
		return ds;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

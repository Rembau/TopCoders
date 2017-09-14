package projecteuler;

import java.util.Arrays;

public class P57 {
	/**
	 * By expanding this for the first four iterations, we get:

	1 + 1/2 = 3/2 = 1.5
	1 + 1/(2 + 1/2) = 7/5 = 1.4
	1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
	1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
	The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 
	1393/985, is the first example where the number of digits in the 
	numerator exceeds the number of digits in the denominator.

	In the first one-thousand expansions, how many fractions contain 
	a numerator with more digits than denominator?
	 */
	public static void func(){
		int count=0;
		int[][] init = new int[][]{new int[]{1},new int[]{2}};
		for (int i = 2; i <= 1000; i++) {
			init[0]=add(init[0],multiply(init[1],2));
			swap(init);
			if(add(init[0],init[1]).length>init[1].length){
				count++;
			}
		}
		System.out.println(count);
	}
	public static int[][] gen(int index){
		int[][] init = new int[][]{new int[]{1},new int[]{2}};
		for (int i = 1; i < index; i++) {
			init[0]=add(init[0],multiply(init[1],2));
			swap(init);
		}
		init[0] = add(init[0],init[1]);
		return init;
	}
	public static int[] multiply(int a[], int f){
		int remainder =0;
		int c[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int t = a[i]*f+remainder;
			c[i] = t%10;
			remainder = t/10;
		}
		if(remainder!=0){
			c=Arrays.copyOf(c, c.length+1);
			c[c.length-1]=remainder;
		}
		return c;
	}
	public static int[] add(int a[],int b[]){
		int remainder =0;
		int d[];
		if(a.length>b.length){
			d=a;
		} else {
			d=b;
		}
		int c[] = new int[Math.max(a.length, b.length)];
		int l=Math.min(a.length, b.length);
		int i;
		for (i = 0; i < l; i++) {
			int sum = a[i]+b[i]+remainder;
			c[i] = sum%10;
			remainder=sum/10;
		}
		for (; i < c.length; i++) {
			int sum = d[i]+remainder;
			c[i] = sum%10;
			remainder=sum/10;
		}
		if(remainder!=0){
			c=Arrays.copyOf(c, c.length+1);
			c[c.length-1]=remainder;
		}
		return c;
	}
	public static void swap(int init[][]){
		int tem[] = init[0];
		init[0] = init[1];
		init[1] = tem;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
		/*int n[][]=gen(1000);
		for (int i = 0; i < n.length; i++) {
			for (int j = n[i].length-1; j >=0 ; j--) {
				System.out.print(n[i][j]);
			}
			System.out.println();
		}*/
		/*int n[] = add(new int[]{1,5,3,9},new int[]{1,5,3,4});
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}*/
		/*int n[] = multiply(new int[]{5,2,3,5},2);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}*/
	}

}

package projecteuler;

import java.util.LinkedList;

public class P92 {
/**
 * A number chain is created by continuously adding the square of the digits 
 * in a number to form a new number until it has been seen before.
 * For example,
 * 44  32  13  10  1  1
 * 85  89  145  42  20  4  16  37  58  89
 * 
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. 
 * What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
 * How many starting numbers below ten million will arrive at 89?
 */
	public static void func(){
		int count=0;
		int n=10000000;
		int r[] = new int[600];
		r[1]=1;
		r[89]=2;
		int i=0;
		for (i = 1; i < n; i++) {
			int tem=f(i);
			if(r[tem]==2){
				count++;
				continue;
			}
			if(r[tem]==1){
				continue;
			}
			LinkedList<Integer> list = new LinkedList<Integer>();
			while(r[tem]==0){
				list.add(tem);
				tem=f(tem);
			}
			for (Integer integer : list) {
				r[integer]=r[tem];
			}
			//System.out.println(list);
			//System.out.println(r[tem]);
			if(r[tem]==2){
				count++;
			}
		}
		System.out.println(count);
	}
	public static int f(int n){
		int product = 0;
		while(n>0){
			int d=n%10;
			product += d*d;
			n=n/10;
		}
		return product;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

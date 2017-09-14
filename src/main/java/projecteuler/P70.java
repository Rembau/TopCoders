package projecteuler;

import java.util.Arrays;
import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P70 {
/**
 * Euler's Totient function, ¦Õ(n) [sometimes called the phi function], 
 * is used to determine the number of positive numbers less than or equal to 
 * n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, 
 * are all less than nine and relatively prime to nine, ¦Õ(9)=6.
 * 
 * The number 1 is considered to be relatively prime to every positive number, so ¦Õ(1)=1.
 * Interestingly, ¦Õ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
 * Find the value of n, 1 < n < 10(7), 
 * for which ¦Õ(n) is a permutation of n and the ratio n/¦Õ(n) produces a minimum.
 * 
 */
	static int maxn=10000000;
	public static void func(){
		final int ps[] = MathTool.generatePrime(1000000);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int tem=0;
		int v=1;
		for (int i = 0; (tem=v*ps[i])<maxn && tem>0; i++) {
			list.add(ps[i]);
			f(ps,tem,i,list);
			list.remove(new Integer(ps[i]));
		}
		System.out.println(min+" "+rr+" "+count);
	}
	static double min=Double.MAX_VALUE;
	static long rr=0;
	static int count=0;
	public static void f(int ps[],long v,int index,LinkedList<Integer> list){
		long r=v;
		count++;
		for (Integer integer : list) {
			r/=integer;
			r*=(integer-1);
		}
		//System.out.println(v+" "+r+" "+list+" "+(v*1.0)/r);
		double m;
		
		if((m=(v*1.0)/r)<min && judge(v,r)){
		//	System.out.println(v+ " " +r+" "+m+" "+list);
			min = m;
			rr=v;
		}
		long tem;
		/*if((tem=v*ps[index])<maxn && tem>0){
			f(ps,tem,index,list);
		}*/
		for (int i = index+1; (tem=v*ps[i])<maxn && tem>0; i++) {
			list.add(ps[i]);
			f(ps,tem,i,list);
			list.remove(new Integer(ps[i]));
		}
	}
	public static boolean judge(long a,long b){
		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
		char[] ca = sa.toCharArray();
		char[] cb = sb.toCharArray();
		if(ca.length!=cb.length){
			return false;
		}
		Arrays.sort(ca);
		Arrays.sort(cb);
		for (int i = 0; i < cb.length; i++) {
			if(ca[i]!=cb[i]){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

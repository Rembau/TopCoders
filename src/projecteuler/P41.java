package projecteuler;

import java.util.Arrays;
import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P41 {
/**
 * We shall say that an n-digit number is pandigital 
 * if it makes use of all the digits 1 to n exactly once. 
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * What is the largest n-digit pandigital prime that exists?
 */
	static LinkedList<Integer> r = new LinkedList<Integer>();
	static int rn=0;
	public static void func(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 9; i++) {
			list.add(i);
			f(list,i,1);
			list.remove(new Integer(i));
		}
		System.out.println(rn);
	}
	private static void f(LinkedList<Integer> list,int num,int len){
		if(isSuit(num) && MathTool.isFactor(num)){
			r.add(num);
			rn=num;
			//System.out.println(num);
		}
		if(len==9){
			return;
		}
		for (int i = 1; i < 9; i++) {
			if(list.contains(i)){
				continue;
			}
			list.add(i);
			f(list,num*10+i,len+1);
			list.remove(new Integer(i));
		}
	}
	public static void func1(){
		boolean ps[] = generatePrime(987654322);
		for (int i = 987654321; i > 1; i-=2) {
			if(!ps[i] && isSuit(i)){
				System.out.println(i);
				break;
			}
		}
	}
	private static boolean isSuit(int num){
		char ch[] = (num+"").toCharArray();
		Arrays.sort(ch);
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]-'0' != i+1){
				return false;
			}
		}
		return true;
	}
	private static boolean[] generatePrime(int n){
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i < x; i+=2) {
			if(!d[i]){			//如果没有标记则是素数
				for (int j = i*i; j < n; j+=2*i) {  //小于i的倍数 在之前已经处理了，这里的i，j一定是奇数如果加上个i
													//变为偶数，偶数直接可以跳过
					d[j]=true;
				}
			}
		}
		return d;
	}
	public static void main(String[] args) {
		long i = System.currentTimeMillis();
		func();
		long j = System.currentTimeMillis();
		System.out.println(j-i);
	}

}

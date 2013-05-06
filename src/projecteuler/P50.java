package projecteuler;

import java.util.Arrays;
import java.util.HashMap;

import projecteuler.tool.MathTool;

public class P50 {
/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds to a prime, 
 * contains 21 terms, and is equal to 953.
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
	public static void func(){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		boolean psb[] = generatePrime();
		int ps[] = MathTool.generatePrime(100000);
		System.out.println(ps[99999]);
		int max=0;
		for (int i = 0; ps[i] < 1000000; i++) {
			int n = ps[i];
			int j=i;
			while(n<1000000){
				if(!psb[n]){
					int num =j-i+1;
					if(map.containsKey(n)){
						if(map.get(new Integer(n)) < num){
							map.put(n, num);
						}
					} else {
						map.put(n, num);
					}
					if(num > max){
						max=num;
						System.out.println(max+" "+n+" "+i+" "+j);
					}
				}
				j++;
				n+=ps[j];
			}
		}
		
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
	public static boolean[] generatePrime(){
		int n = 1000000;
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
}

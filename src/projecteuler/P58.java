package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P58 {
	/**
	 * Starting with 1 and spiralling anticlockwise in the following way, 
	 * a square spiral with side length 7 is formed.

	37 36 35 34 33 32 31
	38 17 16 15 14 13 30
	39 18  5  4  3 12 29
	40 19  6  1  2 11 28
	41 20  7  8  9 10 27
	42 21 22 23 24 25 26
	43 44 45 46 47 48 49

	It is interesting to note that the odd squares lie along the bottom right diagonal, 
	but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; 
	that is, a ratio of 8/13  62%.

	If one complete new layer is wrapped around the spiral above, 
	a square spiral with side length 9 will be formed. If this process is continued, 
	what is the side length of the square spiral for which the ratio of primes along 
	both diagonals first falls below 10%?
	 */
	public static void func(){
		//boolean d[] = generatePrime();
		int count=0;
		for (int i = 3; true; i+=2) {
			int start = (int) (Math.pow((i-2),2)+1);
			int n1 = start+(i-2);
			int n2 = n1+(i-1);
			int n3 = n2+(i-1);
			int n4 = n3+(i-1);
	
			if(MathTool.isFactor(n1)){
				count++;
			}
			if(MathTool.isFactor(n2)){
				count++;
			}
			if(MathTool.isFactor(n3)){
				count++;
			}
			if(MathTool.isFactor(n4)){
				count++;
			}
			//System.out.print(n1+" "+n2+" "+n3+" "+n4);
			//System.out.println(" "+count+" "+(1+4*(i-1)/2));
			if(count*10<(1+4*(i-1)/2)){
				System.out.println(i);
				System.out.print(n1+" "+n2+" "+n3+" "+n4);
				break;
			}
		}
	}
	public static boolean[] generatePrime(){
		int n = 1000000000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i <= x; i+=2) {
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
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

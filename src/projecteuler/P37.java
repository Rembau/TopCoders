package projecteuler;

import projecteuler.tool.MathTool;

public class P37 {
/**
 * The number 3797 has an interesting property. Being prime itself, 
 * it is possible to continuously remove digits from left to right, 
 * and remain prime at each stage: 3797, 797, 97, and 7. Similarly 
 * we can work from right to left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable 
 * from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
	public static void func(){
		int count=0;
		int sum=0;
		for (int i = 11; true; i+=2) {
			if(MathTool.isFactor(i)){
				int d =MathTool.getDigitNum(i);
				if(right(d,i) && left(d,i)){
					count++;
					sum+=i;
					System.out.println("=============="+i);
				}
				//System.out.println(" i="+i);
				if(count==11){
					break;
				}
			}
		}
		System.out.println(sum);
	}
	public static boolean right(int d,int i){
		int n;
		for (int j = d-1; j > 0; j--) {
			n = i%(int)Math.pow(10, j);
			//System.out.print(n+"-");
			if(!MathTool.isFactor(n)){
				return false;
			}
		}
		return true;
	}
	public static boolean left(int d,int i){
		int n=i;
		for (int j = 1; j < d; j++) {
			n = n/10;
			//System.out.print(n+"=");
			if(!MathTool.isFactor(n)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		func();
	}

}

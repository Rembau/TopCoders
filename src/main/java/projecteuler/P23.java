package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

public class P23 {
/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
 * which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant 
 * if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written 
 * as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers 
 * greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot 
 * be reduced any further by analysis even though it is known that the greatest number that cannot be expressed 
 * as the sum of two abundant numbers is less than this limit.
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
	public static void func(){
		boolean mark[] = new boolean[28124];
		Arrays.fill(mark, true);
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for(int i=12;i<= 28123 ;i++){
			int r = getDivisorSum(i);
			if(r>i){
				//System.out.println(i+" "+r);
				abundant.add(i);
			}
		}
		for (int i = 0; i < abundant.size(); i++) {
			for (int j = 0; j < abundant.size(); j++) {
				if(abundant.get(i)+abundant.get(j)<mark.length)
					mark[abundant.get(i)+abundant.get(j)]=false;
			}
		}
		int sum=0;
		for (int i = 1; i < mark.length; i++) {
			if(mark[i]){
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	public static int getDivisorSum(int n){
		int sum=1;
		double q=Math.sqrt(n);
		for (int i = 2; i < q; i++) {
			if(n%i==0){
				sum+=i;
				sum+=n/i;
			}
		}
		if(n%q==0){
			sum+=q;
		}
		return sum;
	}
	public static void main(String[] args) {
		func();
	}

}

package projecteuler;

import java.util.LinkedList;

/**
 * 
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called 
amicable numbers.
For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
Evaluate the sum of all the amicable numbers under 10000.
 *
 */
public class P21 {
	public static void func(){
		LinkedList<Integer> record = new LinkedList<Integer>();
		int sum=0;
		for(int i=1;i<10000;i++){
			if(record.contains(i)){
				continue;
			}
			int r = sum(i);
			//System.out.println(r);
			if(r!=i && sum(r)==i){
				record.add(i);
				sum+=i;
				if(r<10000){
					record.add(r);
					sum+=r;
				}
			}
		}
		System.out.println("220 "+sum(220));
		System.out.println(sum);
	}
	public static int sum(int n){
		int sum=1;
		int i;
		for (i = 2; i < Math.sqrt(n); i++) {
			if(n%i==0){
				sum+=i;
				sum+=n/i;
			}
		}
		if(i*i==n){
			sum+=i;
		}
		return sum;
	}
	public static void main(String[] args) {
		func();
	}

}

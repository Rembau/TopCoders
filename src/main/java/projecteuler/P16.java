package projecteuler;

import java.util.Arrays;

/**
 * 
 * 	215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	What is the sum of the digits of the number 21000?
 * @author Rembau
 *
 */
public class P16 {
	public static void func(){
		int n=500000;
		int num[]=new int[n];
		int m=0;
		Arrays.fill(num, 0);
		num[0]=2;
		int carry=0;
		for (int i = 0; i < 999; i++) {
			for (int j = 0; j <= m; j++) {
				int x = num[j]*2;
				x=x+carry;
				num[j]=x%10;
				/*if(num[j]!=0){
					System.out.println(m+" "+num[j]);
				}*/
				carry=x/10;
				if(carry>0){
					m++;
				}
			}
		}
		long sum=0;
		for (int i = 0; i < num.length; i++) {
			sum+=num[i];
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		func();
	}

}

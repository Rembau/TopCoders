package projecteuler;

import java.util.Arrays;

public class P20 {
	public static void func(){
		int nums[]=new int[10000];
		Arrays.fill(nums, 0);
		nums[0]=1;
		int m=1;
		int carry=0;
		int sum=0;
		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j < m; j++) {
				int x = nums[j]*i;
				x=x+carry;
				nums[j]=x%10;
				if(nums[j]!=0){
					System.out.println(m+" "+nums[j]+" "+carry+" "+i);
				}
				carry=x/10;
				if(carry>0){
					m++;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		func();
	}
}

package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P55 {

	public static void func(){
		int count = 0;
		for (int i = 1; i < 10000; i++) {
			int j=1;
			int num[] = new int[MathTool.getDigitNum(i)];
			int tem=i;
			for (int k = 0; k < num.length; k++) {
				num[k]=tem%10;
				tem/=10;
			}
			while(j<50){
				num=addReverse(num);
				if(isPalindrome(num)){
					count++;
					/*System.out.println(i+" "+j+" "+count);
					for (int k : num) {
						System.out.print(k);
					}
					System.out.println();*/
					break;
				}
				j++;
			}
		}
		System.out.println(9999-count);
	}
	public static boolean isPalindrome(int num[]){
		if(num.length==1){
			return false;
		}
		for (int i = 0; i <= num.length/2; i++) {
			if(num[i]!=num[num.length-1-i]){
				return false;
			}
		}
		return true;
	}
	public static int[] addReverse(int []num){
		/*for (int i : num) {
			System.out.print(i);
		}
		System.out.println();*/
		int newnum[];
		newnum=new int[num.length+1];

		int remainder=0;
		int i;
		for (i = 0; i < num.length; i++) {
			int tem = remainder+num[i]+num[num.length-1-i];
			newnum[i]=tem%10;
			remainder=tem/10;
		}
		if(remainder!=0){
			newnum[i]=remainder;
		}
		if(newnum[num.length]==0){
			newnum=Arrays.copyOf(newnum, num.length);
		}
		return newnum;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

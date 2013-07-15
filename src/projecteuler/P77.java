package projecteuler;

import projecteuler.tool.MathTool;

public class P77 {
/**
* 
It is possible to write ten as the sum of primes in exactly five different ways:

7 + 3
5 + 5
5 + 3 + 2
3 + 3 + 2 + 2
2 + 2 + 2 + 2 + 2

What is the first value which can be written as the sum of primes in over five thousand different ways?
思路：
把每一个数分为一个质数 与 余数的和
求出有多少组 N个质数相加和为余数，条件是N个质数全部不大于当前质数
使用二维数组记录，当前余数N1，与不大于的质数N2 ，nums[N1][N2]表示由不大于N2的质数相加可得N1的 质数组数
求4到N的结果，在求每一个n的时候在二维数组中记录，当前质数为N3，组数为n3时，nums[n<=n.<N][N3]+=n3
*/
	static int n=11;
	static int nums[][] = new int[n][n];
	public static void func(){
		for (int i = 2; i < n; i++) {
			if(MathTool.isFactor(i)){
				for (int j = i; j < n; j++) {
					nums[i][j]=1;
				}
			}
		}
		for (int i = 4; i < nums.length; i++) {
			int r = f(i);
			System.out.println("============="+i+" "+r);
			if(r>5000){
				System.out.println("============="+i+" "+r);
				break;
			}
		}
	}
	public static int f(int num){
		int count=0;
		for (int i = num; i >=2 ; i--) {
			if(MathTool.isFactor(i)){
				if(nums[num-i][i]==0)
					continue;
				count+=nums[num-i][i];
				nums[num][i]+=nums[i][num-i];
				for (int j = i; j < n; j++) {
					nums[num][j]+=nums[num-i][i];
					System.out.print(num+" "+j+"="+nums[num][j]+",");
				}
				System.out.print(nums[num-i][i]);
				System.out.println();
				System.out.println((num-i)+" "+i+" "+nums[num-i][i]);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

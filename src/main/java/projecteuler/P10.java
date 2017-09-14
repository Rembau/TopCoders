package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P10 {
	public static void func(){
		int i=2000000;
		long c=0;
		for (int j = 2; j < i; j++) {
			if(MathTool.isFactor(j)){
				c+=j;
			}
		}
		System.out.println(c);
	}
	public static void func_(){
		int n=2000000;
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
		long c=0;
		for (int i = 2; i < n; i++) {
			if(!d[i]){
				c+=i;
			}
		}
		//142913828922
		//999536317295
		System.out.println(c);
	}
	public static void main(String[] args) {
		long i=System.currentTimeMillis();
		func_();
		System.out.println(System.currentTimeMillis()-i);
	}

}

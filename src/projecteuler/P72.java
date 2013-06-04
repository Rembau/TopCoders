package projecteuler;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P72 {
/**
 * Consider the fraction, n/d, where n and d are positive integers. 
 * If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 * 
 * If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * 
 * It can be seen that there are 21 elements in this set.
 * How many elements would be contained in the set of reduced proper fractions for d <= 1,000,000?
1000 304191
1500 684181
2000 1216587
2500 1899877
3000 2736187
3500 3724311
4000 4863601
4500 6155995
5000 7600457
 */ 
	static int ps[];
	public static void func(){
		int n = 8;
		long count=0;
		//HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashSet<Integer> r = new HashSet<Integer>();
		for (int i = 2; i <= n; i++) {
			/*HashSet<Integer> list = MathTool.getNoRepeatFactors(i);
			int tem=0;
			for (Integer integer : list) {
				tem += n/integer;
			}*/
			int tem = n/i;
			System.out.println(i+" "+tem+" ");
			count+=(n-i-tem+1);
		}
		System.out.println(count);
	}
	public static void general(){
		int n = 8;
		long count=0;
		boolean p[] = generatePrime(n+1);
		for (int i = 2; i <= n; i++) {
			count+=(i-1);
			if(!p[i]){
				continue;
			}
			for (int j = 2; j < i; j++) {
				/*if(!p[j] && i%j!=0){
					count++;
					continue;
				}*/
				int k=2;
				while(k<=j){
					if(i%k==0 && j%k==0){
						count--;
						//System.out.println(j+" "+i);
						break;
					}
					k++;
				}
			}
		}
		System.out.println(count);
	}
	public static boolean[] generatePrime(int n){
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
	public static void ff(){
		int count=0;
		int d = 5000;
		int n[] = new int[d+1];
		for (int i = 2; i <= d; i++) {
			n[i]=i;
		}
		ps = MathTool.generatePrime(100001);
		System.out.println(ps[100001]);
		for (int i = 0; ps[i] < d; i++) {
			for (int j = 2; j <= d; j++) {
				if(j%ps[i]==0){
					n[j]-=j/ps[i];
					//System.out.println(j+"rem"+j/ps[i]);
				}
			}
		}
		System.out.println(new Date());
		for (int i = 0; ps[i] <= d; i++) {
			int tem = ps[i+1]*ps[i];
			for (int j = i+2; 0 <tem && tem <= d; j++) {
				n[tem]++;
				tem = ps[j]*ps[i];
			}
		}
		for (int i = 2; i < n.length; i++) {
			count+=n[i];
			System.out.println(i+" "+n[i]);
		}
		System.out.println(count);
	}
	public static int f(int n){
		for (int i = 0; i < ps.length; i++) {
			if(n<ps[i]){
				return i-1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

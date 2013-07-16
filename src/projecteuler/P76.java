package projecteuler;

import java.util.HashMap;

public class P76 {
/**
* 
5可以以6种方式写成至少两个正整数之和：

4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1

100可以以多少种方式写成至少两个正整数之和？
*/
			
	public static void func(){
		System.out.println(f(100,99));
		//System.out.println(eulerGenerateFunction(100)-1);
	}
	static HashMap<Integer,Long> map = new HashMap<Integer,Long>();
	public static long eulerGenerateFunction(int n){
		if(n==0){
			return 1;
		} else if(n<0){
			return 0;
		}
		int sign=-1;
		long l =0;
		for (int i = 1; i <= n; i++) {
			sign*=(-1);
			int x1 = (int) (n-0.5*i*(3*i-1));
			long v1 = 0;
			if(map.containsKey(x1)){
				v1= map.get(x1);
			} else {
				v1 = eulerGenerateFunction(x1);
				map.put(x1, v1);
			}
			
			int x2 = (int) (n-0.5*i*(3*i+1));
			long v2 = 0;
			if(map.containsKey(x2)){
				v2= map.get(x2);
			} else {
				v2 = eulerGenerateFunction(x2);
				map.put(x2, v2);
			}
			
			l +=sign*(v1+v2);
		}
		return l;
	}
	static long mark[][] = new long[101][101];
	public static long f(int n,int m){
		if(m==1){
			return 1;
		}
		if(m>n){
			return f(n,n);
		}
		if(m==n){
			return f(n,n-1)+1;
		}
		if(m<n){
			long v1=0;
			if(mark[n][m-1] !=0){
				v1= mark[n][m-1];
			} else{
				v1=f(n,m-1);
				mark[n][m-1] = v1;
			}
			long v2=0;
			if(mark[n-m][m] !=0){
				v2= mark[n-m][m];
			} else{
				v2=f(n-m,m);
				mark[n-m][m] = v2;
			}
			return v1+v2;
		}
		return 0;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

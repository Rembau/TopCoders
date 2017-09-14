package projecteuler;

import java.util.Arrays;

public class P14 {
	static boolean states[];
	public static void func(){
		int n=1000000;
		states=new boolean[n+1];
		Arrays.fill(states, false);
		int l=0;
		int r=0;
		for(int i=n;i>0;i--){
			if(!states[i]){
				int l_ = getLength(i);
				if(l_>l){
					l=l_;
					r=i;
				}
			}
		}
		System.out.println(l+" "+r);
	}
	public static int getLength(int m){
		int c=1;
		long n=m;
		while(n!=1){
			//System.out.println(n);
			if(n<1000000)
				states[(int) n]=true;
			if(n%2==0){
				n=n/2;
			} else {
				n=3*n+1;
			}
			c++;
		}
		return c;
	}
	public static void main(String[] args) {
		func();
	}

}

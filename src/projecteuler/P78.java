package projecteuler;

import java.util.HashMap;

public class P78 {

	/**
	 * Let p(n) represent the number of different ways in which n coins can be separated into piles. 
	 * For example, five coins can separated into piles in exactly seven different ways, so p(5)=7.
	 * OOOOO
	 * OOOO   O
	 * OOO   OO
	 * OOO   O   O
	 * OO   OO   O
	 * OO   O   O   O
	 * O   O   O   O   O
	 * Find the least value of n for which p(n) is divisible by one million.
	 *  m=1		f(n,1)=1
	 *  m>n		f(n,n)
	 *  m=n		f(n,m-1)+1
	 *  m<n		f(n,m-1)+f(n-m,m)
	 */
	static int len=30000;
	static int r[][]=new int[len][len/2+1];
	static HashMap<Integer,HashMap<Integer,Integer>> record= new HashMap<Integer,HashMap<Integer,Integer>>();
	static int mark=0;
	public static void func(){
		long k =System.currentTimeMillis();	
		/*for (int i = 0; i < len; i++) {
			record.put(i, new HashMap<Integer,Integer>());
		}*/
		for (int i = 1; i <len; i++) {
			mark=i;
			//record.remove(new Integer(i-2));
			int tem=f1(i,i,1);
			map.put(i, tem);
			System.out.println("i="+i+" time="+(System.currentTimeMillis()-k)+"\nvalue="+tem+" -----------------------");
			
			if(tem==0){
				System.out.println("r="+tem+" "+i+"==================");
				break;
			}
			//System.out.println(f(i,i)+" "+i);
		}
	}
	public static int f2(int n,int m,int index){
		if(m==1){
			return 1;
		}
		if(m>n){
			return map.get(new Integer(n));
		} else if(m==n){
			return 1+f2(n,n-1,1);
		}
		int t1;
		int t2;
		if(n+m-1<len){
			//System.out.println("1 "+(n+m-1)+" "+m+" ");
			if(record.get(n+m-1).get(n)==null){
				t1=f2(n,m-1,1);
				record.get(n+m-1).put(n, t1);
				//System.out.println("2 "+(n)+" "+(m-1)+" ");
			} else{
				t1=record.get(n+m-1).get(n);
				//System.out.println("2 "+n+" "+(m-1)+" "+t1);
			}
		} else{
			t1 = f2(n,m-1,1);
		}
		if(m<=len/2){
			//System.out.println("1 "+(n)+" "+m+" ");
			if(record.get(n).get(m)==null){
				t2=f2(n-m,m,1);
				//System.out.println("1 "+(n-m)+" "+m+" ");
				record.get(n).put(m, t2);
			} else {
				t2=record.get(n).get(m);
				//System.out.println("1 "+(n-m)+" "+m+" "+t2);
			}
		} else {
			t2=f2(n-m,m,1);
		}
		return (t1+t2)%1000000;
	}
	static long count=0;
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static int f1(int n,int m,int index){
		if(m==1){
			return 1;
		}
		if(m>n){
			//System.out.println("3-"+n);
			return map.get(new Integer(n));
		} else if(m==n){
			return 1+f1(n,n-1,1);
		}
		int t1;
		int t2;
		if((m-1)<=len/2){
			if(r[n][m-1]==0){
				t1=f1(n,m-1,1);
				r[n][m-1]=t1;
				//System.out.println("2-"+(n)+" "+(m-1)+" ");
			} else{
				//System.out.println("2-"+n+" "+(m-1)+"="+r[n][m-1]);
				t1=r[n][m-1];
			}
		} else{
			t1 = f1(n,m-1,1);
		}
		if(m<=len/2){
			if(r[n-m][m]==0){
				t2=f1(n-m,m,1);
				//System.out.println("1-"+(n-m)+" "+m+" ");
				r[n-m][m]=t2;
			} else {
				//System.out.println("1-"+(n-m)+" "+m+"="+r[n-m][m]);
				t2=r[n-m][m];
			}
		} else {
			t2=f1(n-m,m,1);
		}
		return (t1+t2)%1000000;
	}
	
 	/*public static int f(int remainder,int max,int index){
 		//System.out.println(count++);
		if(remainder==0 || max==1){
			//System.out.println("==========="+max);
			return 1;
		}
		int c=0;
		for (int i = max; i > 0; i--) {
			int rem=remainder-i;
			if(rem>=0){
				if(r[rem][i]==0){
					//System.out.println(i+" "+(rem));
					if(i>rem)
						r[rem][i]=f(rem,rem,index+1);
					else{
						r[rem][i]=f(rem,i,index+1);
					}
				}
				//if(index==1)
				//System.out.print("r="+rem+" i="+i+" "+r[rem][i]+"-  ");
				c+=r[rem][i];
				c%=1000000;
			}
		}
		return c%1000000;
		//return c;
	}*/
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

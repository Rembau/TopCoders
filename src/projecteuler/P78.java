package projecteuler;

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
	 */
	static int r[][]=new int[10000][10000];
	static int r1[][] = new int[10000][10000];
	static int mark=0;
	public static void func(){
		long k =System.currentTimeMillis();	
		for (int i = 1; i < 10000; i++) {
			mark=i;
			long tem=f1(i,i,1);
			long tem1=f(i,i,1);
			if(tem!=tem1){
				System.out.println(" i="+i+" time="+(System.currentTimeMillis()-k)+"\nvalue="+tem+" "+tem1);
			}
			
			if(tem==0){
				System.out.println("r="+tem+" "+i+"==================");
				break;
			}
			//System.out.println(f(i,i)+" "+i);
		}
	}
	static long count=0;
	public static int f1(int n,int m,int index){
		if(m==1){
			return 1;
		}
		if(m>n){
			if(r[n][n]==0){
				return f1(n,n,1);
			}
			else {
				//System.out.println(n+" "+n);
				return r[n][n];
			}
		} else if(m==n){
			return 1+f1(n,n-1,1);
		}
		int t1;
		if(r[n][m-1]==0){
			t1=f1(n,m-1,1);
			r[n][m-1]=t1;
		} else{
			//System.out.println("2 "+n+" "+(m-1));
			t1=r[n][m-1];
		}
		
		int t2;
		if(r[n-m][m]==0){
			t2=f1(n-m,m,1);
			r[n-m][m]=t2;
		} else{
			//System.out.println("1 "+(n-m)+" "+m);
			t2=r[n-m][m];
		}
		return (t1+t2)%1000000;
	}
	
 	public static int f(int remainder,int max,int index){
 		//System.out.println(count++);
		if(remainder==0 || max==1){
			//System.out.println("==========="+max);
			return 1;
		}
		int c=0;
		for (int i = max; i > 0; i--) {
			int rem=remainder-i;
			if(rem>=0){
				if(r1[rem][i]==0){
					//System.out.println(i+" "+(rem));
					if(i>rem)
						r1[rem][i]=f(rem,rem,index+1);
					else{
						r1[rem][i]=f(rem,i,index+1);
					}
				}
				//if(index==1)
				//System.out.print("r="+rem+" i="+i+" "+r[rem][i]+"-  ");
				c+=r1[rem][i];
				c%=1000000;
			}
		}
		return c%1000000;
		//return c;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		/*for (int j = 1; j <= 50; j++) {
			f1(j,j,1);
			System.out.println("-----------------------------------------"+j);
		}*/

		System.out.println(System.currentTimeMillis()-i);
	}
}

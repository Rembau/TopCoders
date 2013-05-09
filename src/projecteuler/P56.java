package projecteuler;

public class P56 {

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
	static long r[][]=new long[50000][50000];
	public static void func(){
		long k =System.currentTimeMillis();	
		for (int i = 8000; i < 100000; i++) {
			System.out.print(i+" ");
			System.out.println(System.currentTimeMillis()-k);
			if(f(i,i)==0){
				System.out.println(f(i,i)+" "+i);
				break;
			}
			//System.out.println(f(i,i)+" "+i);
		}
	}
	static long count=0;
	public static long f(int remainder,int max){
		//System.out.println(count++);
		if(remainder==0){
			//System.out.println("==========="+max);
			return 1;
		}
		long c=0;
		for (int i = max; i > 0; i--) {
			int rem=remainder-i;
			if(rem>=0){
				if(r[rem][i]==0){
					//System.out.println(i+" "+(rem));
					if(i>rem)
						r[rem][i]=f(rem,rem);
					else{
						r[rem][i]=f(rem,i);
					}
				}
				c+=r[rem][i];
			}
		}
		return c%1000000;
		//return c;
	}
	public static void main(String[] args) {
		//func();
	
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

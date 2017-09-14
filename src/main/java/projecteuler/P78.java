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
	 * http://mathworld.wolfram.com/PartitionFunctionP.html  Item(11)
	 */
	static int len=100000;
	static int mark=0;
	public static void func(){
		for (int i = 1; ; i++) {
			long x = eulerGenerateFunction(i);
			System.out.println(i);
			if(x%1000000==0){
				System.out.println(i);
				break;
			}
		}
	}
	static int map[] = new int[len]; 
	public static int eulerGenerateFunction(int n){
		if(n==0){
			return 1;
		} else if(n<0){
			return 0;
		}
		int sign=-1;
		int l =0;
		for (int i = 1; i <= n; i++) {
			sign*=(-1);
			int x1 = (int) (n-0.5*i*(3*i-1));
			int v1 = 0;
			if(x1>=0){
				if(map[x1]!=0){
					v1= map[x1];
				} else {
					v1 = eulerGenerateFunction(x1);
					map[x1]=v1%1000000;
				}
			}
			
			
			int x2 = (int) (n-0.5*i*(3*i+1));
			int v2 = 0;
			if(x2>=0){
				if(map[x2]!=0){
					v2= map[x2];
				} else {
					v2 = eulerGenerateFunction(x2);
					map[x1] = v2%1000000;
				}
			}
			
			l +=sign*((v1+v2));
		}
		return l%1000000;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

package projecteuler;

public class P28 {
	/**
	 * 21 22 23 24 25
	 * 20  7  8  9 10
	 * 19  6  1  2 11
	 * 18  5  4  3 12
	 * 17 16 15 14 13
	 */
	public static void func(){
		int start=2;
		int sum=1;
		for (int n = 2;1+2*(n-1)<=1001; n++) {
			int width=1+2*(n-1);
			int n1=start+1+2*(n-2);
			int n2=n1+width-1;
			int n3=n2+width-1;
			int n4=n3+width-1;
			
			start=n4+1;
			System.out.println(n1+" "+n2+" "+n3+" "+n4+" width="+width);
			sum+=n1;
			sum+=n2;
			sum+=n3;
			sum+=n4;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		func();
	}

}

package projecteuler;

public class P4 {
	public static void func(){
		int x=0;
		for (int i = 999; i > 100; i--) {
			for (int j = 999; j > i; j--) {
				int t = i*j;
				if(x<t && is(t)){
					x=t;
				}
			}
		}
		System.out.println(x);
	}
	/**
	 * 	P=100000x+10000y+1000z+100z+10y+x
		P=100001x+10010y+1100z
		P=11(9091x+910y+100z)
		a or b at least one must hava a factor of 11
		if a%11==0 lagest b is 999 and minus 1 every step;
		if not, lagest b is 990 and minus 11 every step;
	 */
	public static void func_(){
		int largestPalindrome = 0;
		int a = 999;
		int b;
		int db;int c=0;
		while (a >= 100){
			if (a % 11 == 0){
				b = 999;
				db = 1;
			}else{
				b = 990; //The largest number less than or equal 999
				 //and divisible by 11
				db = 11;
			}
				while(b >= a){
					c++;
					if (a*b <= largestPalindrome)
						break;
					if (is(a*b))
						largestPalindrome = a*b;
					b = b-db;
				}
				a = a-1;
		}
		System.out.println(largestPalindrome);
		System.out.println(c);
	}
	public static boolean is(int a){
		String str = String.valueOf(a);
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		long i = System.currentTimeMillis();
		func_();
		System.out.println(System.currentTimeMillis()-i);
	}
}

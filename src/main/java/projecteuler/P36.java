package projecteuler;

public class P36 {
/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
	public static void func(){
		int n=1000000;
		int sum=0;
		for (int i = 1; i < n; i+=2) {
			if(isP(i) && isP(Integer.toBinaryString(i))){
				System.out.println(i);
				sum+=i;
			}
		}
		System.out.println(sum);
	}
	public static boolean isP(char[] ch){
		if(ch.length==1){
			return true;
		}
		for (int i = 0; i < ch.length/2; i++) {
			if(ch[i]!=ch[ch.length-i]){
				return false;
			}
		}
		return true;
	}
	public static boolean isP(int n){
		String str = String.valueOf(n);
		return isP(str);
	}
	public static boolean isP(String str){
		return isP(str.toCharArray());
	}
	public static void main(String[] args) {
		func();
	}

}

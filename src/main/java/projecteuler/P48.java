package projecteuler;

import java.math.BigInteger;

public class P48 {
/**
 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
 * 
 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */
	static int num[] = new int[10];
	public static void func(){
		BigInteger num = new BigInteger("0");
		for (int i = 1; i <= 1000; i++) {
			BigInteger n = BigInteger.valueOf(i);
			BigInteger r=n;
			for (int j = 1; j < i; j++) {
				r=r.multiply(n);
				
				String str = r.toString();
				if(str.length()>10){
					str = str.substring(str.length()-10, str.length());
				}
				//System.out.println(str+" "+i+" "+j);
				r=new BigInteger(str);
			}
			num=num.add(r);
		}
		String str = num.toString();
		if(str.length()>10){
			str = str.substring(str.length()-10, str.length());
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		func();
	}

}

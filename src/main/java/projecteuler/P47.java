package projecteuler;

import java.util.HashSet;


public class P47 {
	/**
	 * The first two consecutive numbers to have two distinct prime factors are:
	 * 
	 * 14 = 2 * 7 
	 * 15 = 3 * 5
	 * 
	 * The first three consecutive numbers to have three distinct prime factors
	 * are:
	 * 
	 * 644 = 2² * 7 * 23 
	 * 645 = 3 * 5 * 43 
	 * 646 = 2 * 17 * 19.
	 * 
	 * Find the first four consecutive integers to have four distinct prime
	 * factors. What is the first of these numbers?
	 */
	public static void func(){
		int len = 1000000;
		int nums[] = new int[len];
		for (int i = 2; i < len; i++) {
			if(nums[i]==0)
			for (int j = i*2; j < len; j+=i) {
				nums[j]++;
			}
		}
		int l=0;
		for(int i=0;i<len;i++){
			System.out.println(i+" "+nums[i]);
	        if(nums[i]==4){
	        	l++;
	        	if(l==4){
	        		System.out.println(i-3);
		            break;
	        	}
	        } else {
	        	l=0;
	        }
	    }
	}
	public static void func1(){
		for (int i = 2; true; i++) {
			if(isSuit(i)){
				i++;
				if(isSuit(i)){
					i++;
					if(isSuit(i)){
						i++;
						if(isSuit(i)){
							System.out.println(i-3);
							break;
						}
					}
				}
			}
		}
	}
	private static boolean isSuit(int i){
		HashSet<Integer> ps = getFactors(i);
		if(ps.size()==4){
			//System.out.println(i+" "+ps);
			return true;
		}
		return false;
	}
	/**
	 * 获得质因子
	 */
	public static HashSet<Integer> getFactors(int num){
		HashSet<Integer> f = new HashSet<Integer>();
		int i=2;
		while(num>=i){
			//System.out.println(num);
			while(num%i==0){
				num=num/i;
				//System.out.print(" "+i);
				f.add(i);
			}
			i++;
		}
		//System.out.println();
		return f;
	}
	public static void main(String[] args) {
		func();
	}

}

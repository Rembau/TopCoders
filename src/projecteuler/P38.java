package projecteuler;

import java.util.Arrays;
import java.util.LinkedList;

public class P38 {
/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 192 * 1 = 192
 * 192 * 2 = 384
 * 192 * 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 
 * 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, 
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the 
 * concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
	public static void func(){
		boolean mark[] = new boolean[10];
		Arrays.fill(mark, false);
		int r=0;
		int dn=4;
		while(true){
			int n=9/dn;
			LinkedList<Integer> nums= new LinkedList<Integer>();
			int num=0;
			int currdn=0;
			while(currdn<dn){
				for (int i = 9; i > 0; i--) {
					if(nums.contains(new Integer(i))){
						continue;
					} else {
						nums.add(i);
						num=num*10+i;
					}
				}
			}
			String str ="";
			for (int i = 1; i < n+1; i++) {
				str+=i*num;
			}
			if(isSuit(str) && Integer.valueOf(str)>r){
				r = Integer.valueOf(str);
			}
		}
	}
	public static boolean isSuit(String str){
		if(str.length()!=9){
			return false;
		}
		char ch[]=str.toCharArray();
		Arrays.sort(ch);
		for (int i = 1; i < 10; i++) {
			if(ch[i-1]-'0' != i){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {

	}

}

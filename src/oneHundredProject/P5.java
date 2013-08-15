package oneHundredProject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rembau
 * Date: 13-8-15
 * Time: ÏÂÎç3:58
 * To change this template use File | Settings | File Templates.
 */
public class P5{
	public static void func(){
		System.out.println(transfer(100,2));
	}
	public static String transfer(int num,int scale){
		String strBit[]={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
		List<Integer> list = new LinkedList<Integer>();
		int bits[] = getBit(num,scale);
		while(bits[0]!=0){
			list.add(bits[1]);
			bits = getBit(bits[0],scale);
		}
		list.add(bits[1]);

		StringBuffer sb = new StringBuffer();
		for (Integer integer : list) {
			sb.insert(0,strBit[integer]);
		}
		return new String(sb);
	}
	private static int[] getBit(int x,int scale){
		int []bits = new int[2];
		bits[0] = x/scale;
		bits[1] = x%scale;
		return bits;
	}
	public static void main(String args[]){
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

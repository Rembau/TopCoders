package projecteuler;

import java.util.LinkedList;

public class P43 {
	static long sum=0;
	public static void func(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 9; i++) {
			list.add(i);
			f(list,i,1);
			list.remove(new Integer(i));
		}
		System.out.println(sum);
	}
	private static void f(LinkedList<Integer> list,long num,int len){
		if(len==10 && isSuit(num)){
			System.out.println(num);
			sum+=num;
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if(list.contains(i)){
				continue;
			}
			list.add(i);
			f(list,num*10+i,len+1);
			list.remove(new Integer(i));
		}
	}
	private static boolean isSuit(long num){
		int p[] = new int[]{2,3,5,7,11,13,17};
		for (int i = 9; i > 2; i--) {
			int a =(int) ((int)(num%Math.pow(10, i)/Math.pow(10, i-3)));
			if(a%p[9-i]!=0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		func();
	}

}

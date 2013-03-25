package projecteuler;

import java.util.LinkedList;

public class P24 {
	/**
	 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible 
	 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically 
	 * or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 		012   021   102   120   201   210
	 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 */
	public static void func(){
		int order=1000000;
		int num=9;
		LinkedList<Integer> list=new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		LinkedList<Integer> list_num=new LinkedList<Integer>();
		while(num>=0){
			int total = nums(num);
			int i=1;
			while(order>i*total){
				i++;
			}
			i--;
			list_num.add(list.get(i));
			list.remove(i);
			order-=i*total;
			num--;
		}
		for (Integer integer : list_num) {
			System.out.print(integer);
		}
		System.out.println();
	}
	public static int nums(int i){ //278391546
		int sum=1;
		for (int j = 1; j <= i; j++) {
			sum*=j;
		}
		return sum;
	}
	public static void main(String[] args) {
		long i=System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

package projecteuler;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, 
 * is unusual in two ways: 
 * (i) each of the three terms are prime, and, 
 * (ii) each of the 4-digit numbers are permutations of one another.
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 * @author Rembau
 */
public class P49 {
	static LinkedList<Integer> list;
	static boolean d[];
	public static void func(){
		d= generatePrime();
		for (int i = 1023; i < 10000; i=i+2) {
			if(!d[i]){
				list = new LinkedList<Integer>();
				LinkedList<Integer> digits = new LinkedList<Integer>();
				digits.add(i%10);
				digits.add(i%100/10);
				digits.add(i%1000/100);
				digits.add(i/1000);
				for (int j = 0; j < digits.size(); j++) {
					int x = digits.remove();
					if(x!=0)
						genL(1,digits,x);
					digits.add(x);
				}
				if(list.size()<3){
					continue;
				}
				Collections.sort(list);
				//System.out.println(i+"  "+list.size()+" "+list);
				for (int j = 0; j < list.size()-2; j++) {
					int i0=j;
					int i1=j+1;
					int i2=j+2;
					while(true){
						int d1 = list.get(i1)-list.get(i0);
						int d2 = list.get(i2)-list.get(i1);
						if(d1==0){
							break;
						}
						if(d1==d2){
							System.out.println(i+" "+j+" "+list.size()+" "+list);
							System.out.println(list.get(i0)+" "+list.get(i1)+" "+list.get(i2));
							break;
						} else if(d1<d2){
							i1++;
							i2++;
							if(i2>=list.size()){
								break;
							}
						} else{
							i2++;
							if(i2>=list.size()){
								break;
							}
						}
					}
					
				}
			}
		}
	}
	public static void genL(int index, LinkedList<Integer> digits,int v){
		if(index==4){
			if(!d[v] && !list.contains(v))
				list.add(v);
			return ;
		}
		for (int j = 0; j < digits.size(); j++) {
			int x = digits.remove();
			int vx = v*10+x;
			genL(index+1,digits,vx);
			digits.add(x);
		}
	}
	public static boolean[] generatePrime(){
		int n = 10000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i < x; i+=2) {
			if(!d[i]){			//如果没有标记则是素数
				for (int j = i*i; j < n; j+=2*i) {  //小于i的倍数 在之前已经处理了，这里的i，j一定是奇数如果加上个i
													//变为偶数，偶数直接可以跳过
					d[j]=true;
				}
			}
		}
		return d;
	}
	public static void main(String str[]){
		func();
	}
}

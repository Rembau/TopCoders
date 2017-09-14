package projecteuler;

import java.util.HashSet;
import java.util.LinkedList;

public class P32 {
	public static void func(){
		int sum=0;
		HashSet<Integer> unusual = new HashSet<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		for (int i = 2; i < 10000; i++) {
			for (int j = i+1; j < 10000; j++) {
				int k=i*j;
				int digts = (int) (Math.floor(Math.log10(i))+Math.floor(Math.log10(j))+Math.floor(Math.log10(k))+3);
				if(digts<9){
					continue;
				} else if(digts>9){
					break;
				} else{
					LinkedList<Integer> list_ = new LinkedList<Integer>();
					String str =i+""+j+""+k;
					for (char ch : str.toCharArray()) {
						list_.add(ch-'0');
					}
					if(list_.containsAll(list)){
						System.out.println(i+" "+j+" "+k);
						unusual.add(k);
					}
				}
			}
		}
		for (Integer integer : unusual) {
			sum+=integer;
		}
		System.out.println(sum);
	}
	public static void main(String[] args){
		func();
	}
}

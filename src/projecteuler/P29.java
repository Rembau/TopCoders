package projecteuler;

import java.util.HashSet;

public class P29 {
	public static void func(){
		HashSet<Double> list = new HashSet<Double>();
		//in java,double can discribe 
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				double d = Math.pow(i, j);
				list.add(d);
				//System.out.println(d +" "+(long)d);
			}
		}
		System.out.println(list.size());
	}
	public static void main(String[] args) {
		func();
	}

}

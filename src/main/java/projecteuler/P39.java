package projecteuler;

import java.util.HashMap;

public class P39 {
	static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static void func(){
		for (int i = 1; i < 334; i++) {
			for (int j = i; j < 500; j++) {
				for (int k = j; i+j+k <= 1000; k++) {
					if(isTriangle(i,j,k) && i*i+j*j==k*k){
						add(i+j+k);
					}
				}
			}
		}
		int r=0;
		int maxCount=0;
		for (Integer v : map.keySet()) {
			if(map.get(v)>maxCount){
				maxCount=map.get(v);
				r=v;
			}
		}
		System.out.println(r+" "+maxCount);
	}
	public static void add(int x){
		if(map.containsKey(x)){
			map.put(x, map.get(x)+1);
		} else {
			map.put(x, 1);
		}
	}
	public static boolean isTriangle(int a,int b,int c){
		if(a+b>c && Math.abs(a-b)<c){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		func();
	}

}

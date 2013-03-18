package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class P15 {
	static Map<Integer,Integer> g =new HashMap<Integer,Integer>();
	public static void func(){
		long r=1;
		for (int i = 21; i < 41; i++) {
			g(i);
		}
		for (int i = 1; i < 21; i++) {
			r(i);
		}
		for(Integer n:g.keySet()){
			r*=Math.pow(n, g.get(n));
		}
		System.out.println(g);
		System.out.println(r);
	}
	public static void g(int n){
		int i=2;
		while(i<=n){
			while(n%i==0){
				n=n/i;
				add(i);
			}
			i++;
		}
	}
	public static void r(int n){
		int i=2;
		while(i<=n){
			while(n%i==0){
				n=n/i;
				remove(i);
			}
			i++;
		}
	}
	public static void add(int n){
		System.out.println("add "+n);
		if(g.containsKey(n)){
			g.put(n, g.get(n)+1);
		} else {
			g.put(n, 1);
		}
	}
	public static void remove(int n){
		System.out.println("remove "+n);
		if(g.containsKey(n)){
			g.put(n, g.get(n)-1);
		} else {
			g.put(n, -1);
		}
	}
	public static void main(String[] args) {
		func();
	}

}

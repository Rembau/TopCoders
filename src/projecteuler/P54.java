package projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class P54 {
	static LinkedList<Pork[]> o = new LinkedList<Pork[]>();
	static LinkedList<Pork[]> t = new LinkedList<Pork[]>();
	public static void func(){
		InputStream in = P54.class.getClassLoader().getResourceAsStream("projecteuler/file/poker.txt");
		BufferedReader d = new BufferedReader(new InputStreamReader(in));
		try {
			String str;
			while((str=d.readLine())!=null){
				//System.out.println(str);
				add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count=0;
		for (int i = 0; i < o.size(); i++) {
			boolean b=ogreatthant(o.get(i),t.get(i));
			if(b){
				count++;
			}
		}
		System.out.println(count);
	}
	public static void add(String str){
		String s[] = str.split(" ");
		Pork[] x = new Pork[5];
		for (int i = 0; i < 5; i++) {
			x[i] = new Pork(s[i]);
			//System.out.print(x[i]+" ");
		}
		//System.out.println();
		Arrays.sort(x);
		o.add(x);
		Pork[] xx = new Pork[5];
		for (int j = 5; j < s.length; j++) {
			int i=j-5;
			xx[i] = new Pork(s[j]);
			//System.out.print(x[i]+" ");
		}
		//System.out.println();
		Arrays.sort(xx);
		t.add(xx);
	}
 	public static boolean ogreatthant(Pork[] o,Pork[] t){
		boolean b =true;
		int o_[] = getT(o);
		int t_[] = getT(t);
		
		if(o_[0]<=1 || t_[0]<=1){
			for (int i = 0; i < o.length; i++) {
				System.out.print(o[i]+" ");
			}
			System.out.println();
			for (int i = 0; i < o_.length; i++) {
				System.out.print(o_[i]+" ");
			}
			System.out.println();
			for (int i = 0; i < t.length; i++) {
				System.out.print(t[i]+" ");
			}
			System.out.println();
			for (int i = 0; i < t_.length; i++) {
				System.out.print(t_[i]+" ");
			}
			System.out.println();
		}
		
		if(o_[0]<t_[0]){
			return true;
		} else if(o_[0]>t_[0]){
			return false;
		} else {
			if(o_[0]==2|| o_[0]==4||o_[0]==5||o_[0]==6||o_[0]==7||o_[0]==10){
				if(o_[1]>t_[1]){
					return true;
				} else{
					return false;
				}
			}
			if(o_[0]==8){
				if(o_[3]>t_[3]){
					return true;
				} 
				if(o_[3]==t_[3]){
					if(o_[2]>t_[2]){
						return true;
					} 
					if(o_[2]==t_[2]){
						if(o_[1]>t_[1]){
							return true;
						} 
					}
				}
				return false;
			}
			if(o_[0]==9){
				if(o_[1]>t_[1]){
					return true;
				} 
				if(o_[1]==t_[1]){
					if(o_[2]>t_[2]){
						return true;
					} 
				}
				return false;
			}
		}
		return b;
	}
	public static int[] getT(Pork p[]){
		int r[];
		if((r=isRF(p))!=null){
			return r;
		} else if((r=isSF(p))!=null){
			return r;
		} else if((r=isFV(p))!=null){
			return r;
		} else if((r=isFH(p))!=null){
			return r;
		} else if((r=isF(p))!=null){
			return r;
		} else if((r=isS(p))!=null){
			return r;
		} else if((r=isTK(p))!=null){
			return r;
		} else if((r=isTP(p))!=null){
			return r;
		} else if((r=isOP(p))!=null){
			return r;
		} else {
			return getMax(p);
		}
	}
	public static int[] getMax(Pork[] p){
		int m=0;
		for (int i = 0; i < p.length; i++) {
			if(p[i].v>m){
				m=p[i].v;
			}
		}
		return new int[]{10,m};
	}
	public static int[] isOP(Pork[] p){
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for (int i = 0; i < p.length; i++) {
			if(map.containsKey(p[i].v)){
				map.put(p[i].v, map.get(p[i].v)+1);
			} else {
				map.put(p[i].v, 1);
			}
		}
		int x[]=new int[5];
		int j=0;
		int rem=0;
		for (Integer i : map.keySet()) { 
			if(map.get(i)==2){
				rem=i;
			}else{
				x[j++]=i;
			}
		}
		Arrays.sort(x);
		if(rem!=0){
			return new int[]{9,rem,x[4]};
		}
		return null;
	}
	/**
	 * 1:单张大小
	 * 2:小对大小
	 * 3:大对大小
	 */
	public static int[] isTP(Pork[] p){
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for (int i = 0; i < p.length; i++) {
			if(map.containsKey(p[i].v)){
				map.put(p[i].v, map.get(p[i].v)+1);
			} else {
				map.put(p[i].v, 1);
			}
		}
		int x[]= new int[4];
		int j=0;
		Integer rem=0;
		for (Integer i : map.keySet()) { 
			if(map.get(i)==2){
				x[j++]=i;
			}
			if(map.get(i)==1){
				rem=i;
			}
		}
		if(j!=2){
			return null;
		}
		Arrays.sort(x);
		x[1]=rem;
		x[0]=8;
		return x;
	}
	public static int[] isTK(Pork[] p){
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for (int i = 0; i < p.length; i++) {
			if(map.containsKey(p[i].v)){
				map.put(p[i].v, map.get(p[i].v)+1);
			} else {
				map.put(p[i].v, 1);
			}
		}
		for (Integer i : map.keySet()) {
			if(map.get(i)==3){
				return new int[]{7,i};
			}
		}
		return null;
	}
	public static int[] isS(Pork[] p){
		int v=p[0].v;
		for (int i = 1; i < p.length; i++) {
			if((p[i].v-v)!=i){
				return null;
			}
		}
		return new int[]{6,v};
	}
	public static int[] isF(Pork[] p){
		int s = p[0].t;
		for (int i = 1; i < p.length; i++) {
			if(s!=p[i].t){
				return null;
			}
		}
		int max = getMax(p)[1];
		return new int[]{5,max};
	}
	public static int[] isFH(Pork[] p){
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for (int i = 0; i < p.length; i++) {
			if(map.containsKey(p[i].v)){
				map.put(p[i].v, map.get(p[i].v)+1);
			} else {
				map.put(p[i].v, 1);
			}
		}
		if(map.size()!=2){
			return null;
		}
		for (Integer i : map.keySet()) {
			if(map.get(i)==3){
				return new int[]{4,i};
			}
		}
		return null;
	}
	public static int[] isFV(Pork[] p){
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for (int i = 0; i < p.length; i++) {
			if(map.containsKey(p[i].v)){
				map.put(p[i].v, map.get(p[i].v)+1);
			} else {
				map.put(p[i].v, 1);
			}
		}
		for (Integer i:map.keySet()) {
			if(map.get(i)==4){
				return new int[]{3,i};
			}
		}
		return null;
	}
	public static int[] isSF(Pork[] p){
		int s = p[0].t;
		int v=p[0].v;
		for (int i = 1; i < p.length; i++) {
			if((p[i].v-v)!=i){
				return null;
			}
			if(s!=p[i].t){
				return null;
			}
		}
		return new int[]{2,v};
	}
	public static int[] isRF(Pork[] p){
		int s = p[0].t;
		for (int i = 1; i < p.length; i++) {
			if(s!=p[i].t){
				return null;
			}
		}
		for (int i = 0; i < p.length; i++) {
			if(p[i].v!=(i+10)){
				return null;
			}
		}
		return new int[]{1};
	}
	public static void main(String[] args) {
		long i = System.nanoTime();
		func();
		System.out.println((System.nanoTime() - i)/1000000.0);
	}
	static class Pork implements Comparable<Pork>{
		int v;
		int t;
		String str;
		public Pork(String s){
			this.str=s;
			if(s.charAt(0)=='T'){
				v=10;
			} else if(s.charAt(0)=='J'){
				v=11;
			} else if(s.charAt(0)=='Q'){
				v=12;
			} else if(s.charAt(0)=='K'){
				v=13;
			} else if(s.charAt(0)=='A'){
				v=14;
			} else {
				v=s.charAt(0)-'0';
			}
			if(s.charAt(1)=='C'){
				t=1;
			} else if(s.charAt(1)=='D'){
				t=2;
			} else if(s.charAt(1)=='S'){
				t=3;
			} else if(s.charAt(1)=='H'){
				t=4;
			}
		}
		public int compareTo(Pork i) {
			if(v>i.v){
				return 1;
			} else if(v<i.v){
				return -1;
			}
			return 0;
		}
		public String toString(){
			//return "v="+v+",t="+t;
			return str;
		}
	}
}

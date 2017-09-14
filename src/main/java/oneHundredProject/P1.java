package oneHundredProject;

import java.util.LinkedList;

public class P1 {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void func(){
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		f(0,new LinkedList<Integer>());
	}
	public static void f(int s,LinkedList<Integer> r){
		if(s==10){
			if(d(r.get(0),r.get(1),r.get(2),r.get(3),r.get(4),r.get(5),r.get(6),
					r.get(7),r.get(8),r.get(9))){
				String tem[][] = new String[][]{
					new String[]{" ",r.get(0)+"",r.get(1)+"",r.get(2)+"",r.get(3)+"",r.get(4)+""},
					new String[]{" "," "," ",r.get(3)+"",r.get(5)+"",r.get(6)+""},
					new String[]{"+"," "," ",r.get(3)+"",r.get(5)+"",r.get(6)+""},
					new String[]{"-","-","-","-","-","-","-"},
					new String[]{" ",r.get(7)+"",r.get(8)+"",r.get(9)+"",r.get(3)+"",r.get(4)+""}
				};
				for (int i = 0; i < tem.length; i++) {
					for (int j = 0; j < tem[0].length; j++) {
						System.out.print(tem[i][j]+" ");
					}
					System.out.println();
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			int t = list.removeFirst();
			r.add(t);
			f(s+1,r);
			list.add(new Integer(t));
			r.remove(new Integer(t));
		}
	}
	public static boolean d(int a,int b,int c,int d,int e,int f,int g,int x,int y,int z){
		if(x*10000+y*1000+z*100+d*10+e == a*10000+b*1000+c*100+d*10+e+2*(d*100+f*10+g)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		func();
	}

}

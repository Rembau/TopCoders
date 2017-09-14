package projecteuler;

import java.util.HashMap;

public class P74 {
	static int n=1000000;
	static int fac[] = new int[10];
	public static void func(){
		int cc=0;
		int pro=1;
		for (int i = 0; i < fac.length; i++) {
			fac[i]=pro;
			pro*=(i+1);
		}
		HashMap<Integer,Integer> m2 = new HashMap<Integer,Integer>();
		m2.put(169, 3);
		m2.put(363601 , 3);
		m2.put(1454 , 3);
		m2.put(871  , 2);
		m2.put(45361  , 2);
		m2.put(872  , 2);
		m2.put(45362  , 2);
		for (int i = 1; i <= n; i++) {
			int tem = fac(i);
			if(tem==i){
				m2.put(tem, 0);
				continue;
			}
			//System.out.println(i+" "+tem);
			HashMap<Integer,Integer> m1 = new HashMap<Integer,Integer>();
			int count=1;
			
			while(!m2.keySet().contains(tem)){
				count++;
				m1.put(tem, 0);
				for (Integer temi : m1.keySet()) {
					m1.put(temi,m1.get(temi)+1);
				}
				int tem2 = fac(tem);
				if(tem == tem2){
					m2.put(tem, 1);
					m1.put(tem, 1);
					//System.out.println(tem+" 0");
					break;
				}
				tem=tem2;
				//System.out.println(i+" mid "+tem+" count "+count);
			}
			for (Integer temi : m1.keySet()) {
				//System.out.println(temi+" "+tem+" ---"+m1.get(temi)+" "+m2.get(tem));
				m1.put(temi,m1.get(temi)+m2.get(new Integer(tem)));
			}
			m2.putAll(m1);
			count+=m2.get(tem);
			if(count==60){
				cc++;
			}
			//System.out.println(i+" count "+count+" "+m2.get(i)+" last "+m2.get(new Integer(tem))+" tem "+tem);
			m2.putAll(m1);
		}
		System.out.println("cc "+cc);
	}
	public static int fac(int i){
		int sum=0;
		while(i>0){
			sum+=fac[i%10];
			i/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

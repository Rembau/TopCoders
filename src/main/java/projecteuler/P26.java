package projecteuler;

import java.util.LinkedList;

public class P26 {
	public static void func(){
		int maxr = 0;
		int n=2;
		for (int i = 2; i < 1000; i++) {
			int num=1;
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(1);
			//System.out.println(i);
			while(true){
				while(num<i){
					num*=10;
				}
				int remainder=num%i;
				num=remainder;
				//System.out.print("num="+num+" remainder="+remainder+" ");
				if(remainder==0){
					break;
				}
				//System.out.println(list);
				if(list.indexOf(remainder)!=-1){
					int length = list.size()-list.indexOf(remainder);
					//System.out.print("length="+length);
					if(maxr<length){
						maxr = length;
						n=i;
					}
					break;
				}
				list.add(remainder);
			}
			//System.out.println();
		}
		System.out.println(n);
	}
	public static void main(String[] args) {
		long i=System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

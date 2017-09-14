package projecteuler;

import java.util.LinkedList;

public class P5 {
	/**
	 * 1获取1到20所有数的质因子，并标记每一个因子为0
	 * 2在所有数中任选一个因子，标记为3（保留），从其他数中，每个数找到且只找一个相同的因子，并标记为1丢弃
	 * 3遍历把标记为保留的因子相乘
	 */
	
	public static void func(){
		int num=20;
		LinkedList<LinkedList<Integer[]>> factorss = new LinkedList<LinkedList<Integer[]>>();
		while(num>1){
			LinkedList<Integer[]> t =getFactors(num);
			factorss.add(t);
			num--;
		}
		boolean f=true;
		while(f){
			int x=0;
			f=false;
			for (LinkedList<Integer[]> linkedList : factorss) {
				for (Integer[] integers : linkedList) {
					if(integers[1]==0){
						f=true;
						if(x==0){
							x=integers[0];
							integers[1]=3;
							break;
						} else if(integers[0]==x){
							integers[1]=1;
							break;
						}
					}
				}	
			}
		}
		int r=1;
		for (LinkedList<Integer[]> t:factorss){
			for (Integer[] i : t) {
				if(i[1]==3){
					r*=i[0];
				}
			}
		}
		System.out.println("r="+r);
	}
	/**
	 * 濮瑰倸锟介崶鐘茬摍 10 = 2*5閿涳拷=2*2*2
	 */
	public static LinkedList<Integer[]> getFactors(int num){
		LinkedList<Integer[]> f = new LinkedList<Integer[]>();
		int i=2;
		while(num>=i){
			//System.out.println(num);
			while(num%i==0){
				num=num/i;
				System.out.print(" "+i);
				f.add(new Integer[]{i,0});
			}
			i++;
		}
		System.out.println();
		return f;
	}
	public static void main(String[] args) {
		func();
	}

}

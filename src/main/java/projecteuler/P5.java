package projecteuler;

import java.util.LinkedList;

public class P5 {
	/**
	 * 1��ȡ1��20�������������ӣ������ÿһ������Ϊ0
	 * 2������������ѡһ�����ӣ����Ϊ3�������������������У�ÿ�����ҵ���ֻ��һ����ͬ�����ӣ������Ϊ1����
	 * 3�����ѱ��Ϊ�������������
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
	 * 姹傚�鍥犲瓙 10 = 2*5锛�=2*2*2
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

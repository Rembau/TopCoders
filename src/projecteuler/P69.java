package projecteuler;

import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P69 {
	/**
	 * ŷ��������(n)����ʱҲ����phi������������������С��n ����������n���ʵ����ֵĸ��������磬
	 * ��Ϊ1,2,4,5,7,8ȫ��С��9������9���ʣ����Ԧ�(9)=6��
	 * 
	 	n		������	��(n)	n/��(n)
	 	2		1		1		2
		3		1,2		2		1.5
		4		1,3		2		2
		5	1,2,3,4		4		1.25
		6		1,5		2		3
		7	1,2,3,4,5,6	6		1.1666...
		8	1,3,5,7		4		2
		9	1,2,4,5,7,8	6		1.5
		10	1,3,7,9		4		2.5
	* ���Կ�������n  10��n=6ʱ ��n/��(n)ȡ�����ֵ��
	* �ҳ� n  1,000,000 �� n ��ʹ��n/��(n)ȡ������ n ֵ��
	*/
	public static void func(){
		ps = MathTool.generatePrime(100001);
		func1();
	}
	static int n=1000000;
	static int max=0;
	static double maxd=0;
	static int ps[];
	public static void func1(){
		func11(new LinkedList<Integer>(),0);
		System.out.println(max+" "+maxd);
	}
	public static void func11(LinkedList<Integer> list,int index){
		long product =1;
		for (Integer integer : list) {
			product*=integer;
		}

		for (int i = index; i < ps.length; i++) {
			long tem = product*ps[i];
			if(tem<n){
				list.add(ps[i]);
				func111(list,(int) tem,0);
				
				func11(list,i+1);
				list.remove(new Integer(ps[i]));
			} else{
				break;
			}
		}
		
	}
	public static void func111(LinkedList<Integer> list,long product,int index){
		int tem=MathTool.euler(list, (int) product);
		double temd = product*1.0/tem;
		//System.out.println(temd);
		if( temd > maxd){
			max = (int) product;
			maxd = temd;
		}
		for (int i=index;i<list.size();i++) {
			long tem1 = product*list.get(i);
			if(tem1 >= n){
				break;
			}
			func111(list,tem1,i);
		}
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

package projecteuler;

import java.util.LinkedList;

public class P68 {
	/**
	 * 将每组解的数字连接起来，可以得到一个9位的字符串；三角环所能形成的最大字符串为432621513。
	 * 使用数字1到10，通过不同的安排，可以得到16位或17位的字符串。五角环所能形成的最大的16位的字符串是什么？
	 */
	public static void func(){
		LinkedList<Integer> listIn = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			listIn.add(i);
		}
		LinkedList<Integer> listOu = new LinkedList<Integer>();
		f1(listIn,listOu,1);
		
		System.out.println(max);
	}
	static long max=0;
	static int group[][] = new int[5][3];
	static int sum;
	public static void f1(LinkedList<Integer> listIn,LinkedList<Integer> listOu,int index){
		if(listOu.size()==4){
			listOu.add(10);
			int sumt=0;
			sumt=(1+10)*10;
			for (Integer integer : listOu) {
				sumt-=integer;
			}
			if(sumt%5==0){
				System.out.println(listOu+" "+listIn);
				sum=sumt/5;
				f2(listIn,listOu);
			}
			
			listOu.remove(new Integer(10));
			return;
		}
		for (int i = index; i < 10; i++) {
			listOu.add(i);
			listIn.remove(new Integer(i));
			f1(listIn,listOu,i+1);
			listIn.add(i);
			listOu.remove(new Integer(i));
		}
	}
	public static void f2(LinkedList<Integer> listIn,LinkedList<Integer> listOu){
		LinkedList<Integer> newlistOut = new LinkedList<Integer>(listOu);
		group[0][0] = newlistOut.remove();
		f3(listIn,new LinkedList<Integer>(),newlistOut);
	}
	public static void f3(LinkedList<Integer> listIn,LinkedList<Integer> list,LinkedList<Integer> listOu){
		if(listIn.size()==0){
			//System.out.println(list);
			if((group[0][0]+list.get(0)+list.get(1))!=sum){
				return ;
			}
			for (int i = 0; i < group.length; i++) {
				group[i][1]=list.get(i);
				group[i][2]=list.get((i+1)%(group.length));
			}

			LinkedList<Integer> newlistOut = new LinkedList<Integer>(listOu);
			int i=1;
			boolean flag=false;
			while(newlistOut.size()!=0){
				flag = false;
				for (Integer integer : newlistOut) {
					if(group[i][1]+group[i][2]+integer==sum){
						group[i][0]=integer;
						i++;
						newlistOut.remove(integer);
						flag=true;
						break;
					}
				}
				if(!flag){
					break;
				}
			}
			if(flag){
				System.out.println("----------------分割线--------------------");
				System.out.println("sum="+sum);
				String str="";
				for (int j = 0; j < group.length; j++) {
					for (int k = 0; k < 3; k++) {
						System.out.print(group[j][k]+" ");
						str+=group[j][k];
					}
					System.out.println();
				}
				long tem = Long.valueOf(str);
				if(tem>max){
					max = tem;
				}
				System.out.println("tem="+tem);
				System.out.println("----------------分割线--------------------");
			}
			return ;
		}
		for (int i = 0; i < listIn.size(); i++) {
			int tem = listIn.remove();
			list.add(tem);
			f3(listIn,list,listOu);
			listIn.add(tem);
			list.remove(new Integer(tem));
			
		}
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}

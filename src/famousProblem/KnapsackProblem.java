package famousProblem;

import java.util.HashMap;
import java.util.LinkedList;

public class KnapsackProblem {
	public static int maxWeight=10;
	public static int maxValue=0;
	public static HashMap<Integer,Integer> goods= new HashMap<Integer,Integer>();
	public static LinkedList<Integer> key= new LinkedList<Integer>();
	public static void add(){
		goods.put(3,4);
		key.add(3);
		goods.put(4,5);
		key.add(4);
		goods.put(5,6);
		key.add(5);
	}
	public static void func(){
		add();
		record = new int[maxWeight+1];
		//f1(0,0);
		f2();
		System.out.println(maxValue);
	}
	static int record[];
	public static void f2(){
		/*for (int i = 1; i < record.length; i++) {
			record[i] = Integer.MIN_VALUE;
		}*/
		for (int i = 1; i <= key.size(); i++) {
			System.out.println(key.get(i-1));
			for (int j = maxWeight; j >= key.get(i-1); j--) {
				record[j] = Math.max(record[j],record[j-key.get(i-1)]+goods.get(key.get(i-1)));
			}
		}
		for (int j = 0; j < record.length; j++) {
			System.out.print(record[j]+" ");
		}
		System.out.println();
		maxValue=record[maxWeight];
	}
	public static void f1(int currentWeight,int currentValue){
		for (int i = 0;i<key.size();i++) {
			int _int = key.getFirst();
			int temWeight = currentWeight+_int;
			if(temWeight>maxWeight){
				if(currentValue>maxValue){
					maxValue=currentValue;
				}
			} else{
				key.remove(new Integer(_int));
				f1(temWeight,currentValue+goods.get(_int));
				key.add(new Integer(_int));
			}
		}
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

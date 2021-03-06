package projecteuler;

import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P61 {
/**
Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate 
(polygonal) numbers and are generated by the following formulae:

Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Square	 		P4,n=n*n	 		1, 4, 9, 16, 25, ...
Pentagonal	 	P5,n=n(3n-1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	P6,n=n(2n-1)	 	1, 6, 15, 28, 45, ...
Heptagonal	 	P7,n=n(5n-3)/2	 	1, 7, 18, 34, 55, ...
Octagonal	 	P8,n=n(3n-2)	 	1, 8, 21, 40, 65, ...
The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

The set is cyclic, in that the last two digits of each number is the first two digits of the 
next number (including the last number with the first).
Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882), 
is represented by a different number in the set.
This is the only set of 4-digit numbers with this property.

Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: 
triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
*/
	public static void func(){
		int num=0;
		LinkedList<Integer> oct = new LinkedList<Integer>();
		LinkedList<Integer> hep = new LinkedList<Integer>();
		LinkedList<Integer> hex = new LinkedList<Integer>();
		LinkedList<Integer> pen = new LinkedList<Integer>();
		LinkedList<Integer> squ = new LinkedList<Integer>();
		LinkedList<Integer> tri = new LinkedList<Integer>();
		
		int j=0;
		LinkedList<LinkedList<Integer>> m=new LinkedList<LinkedList<Integer>>();
		while(j<6){
			num=0;
			for (int i = 1; MathTool.getDigitNum(num)<5; i++) {
				if(j==4){
					num=hep(i);
					if(MathTool.getDigitNum(num)==4){
						hep.add(num);
					}
				} else if(j==3){
					num=hex(i);
					if(MathTool.getDigitNum(num)==4){
						hex.add(num);
					}
				} else if(j==2){
					num=pen(i);
					if(MathTool.getDigitNum(num)==4){
						pen.add(num);
					}
				} else if(j==1){
					num=squ(i);
					if(MathTool.getDigitNum(num)==4){
						squ.add(num);
					}
				} else if(j==0){
					num=tri(i);
					if(MathTool.getDigitNum(num)==4){
						tri.add(num);
					}
				} else if(j==5){
					num=oct(i);
					if(MathTool.getDigitNum(num)==4){
						oct.add(num);
					}
				}
			}
			if(j==0){
				m.add(tri);
			} else if(j==1){
				m.add(squ);
			} else if(j==2){
				m.add(pen);
			} else if(j==3){
				m.add(hex);
			} else if(j==4){
				m.add(hep);
			} 
			j++;
		}
		for (Integer n: oct) {
			LinkedList<Integer> mm =new LinkedList<Integer>();
			mm.add(n);
			if(ff(mm,m)){
				break;
			}
		}
	}
	public static boolean ff(LinkedList<Integer> list,LinkedList<LinkedList<Integer>> rem){
		if(rem.size()==0){
			if(list.size()==6){
				if(judge(list,list.getFirst())){
					System.out.println(list);
					int count=0;
					for (Integer n : list) {
						count+=n;
					}
					System.out.println(count);
					return true;
				}
			}
		}
		for (int i=0;i<rem.size();i++) {
			LinkedList<Integer> tem = rem.remove();
			for (Integer integer : tem) {
				if(judge(list,integer)){
					list.add(integer);
					if(ff(list,rem)){
						return true;
					}
					list.remove(new Integer(integer));
				} else {
					continue;
				}
			}
			rem.add(tem);
		}
		return false;
	}
	public static boolean judge(LinkedList<Integer> list,Integer num){
		if(list.getLast()/100 == num%100){
			//System.out.println(list.getLast()+" "+num+" ========");
			return true;
		}
		return false;
	}
	public static int tri(int n){
		return n*(n+1)/2;
	}
	public static int squ(int n){
		return n*n;
	}
	public static int pen(int n){
		return n*(3*n-1)/2;
	}
	public static int hex(int n){
		return n*(2*n-1);
	}
	public static int hep(int n){
		return n*(5*n-3)/2;
	}
	public static int oct(int n){
		return n*(3*n-2);
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}

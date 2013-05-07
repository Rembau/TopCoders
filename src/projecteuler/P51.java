package projecteuler;

import java.util.Arrays;
import java.util.LinkedList;

import projecteuler.tool.MathTool;

public class P51 {
	/**
	 * By replacing the 1st digit of *3, 
	 * it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
	 * By replacing the 3rd and 4th digits of 56**3 with the same digit, 
	 * this 5-digit number is the first example having seven primes among the ten generated numbers, 
	 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, 
	 * being the first member of this family, is the smallest prime with this property.
	 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) 
	 * with the same digit, is part of an eight prime value family.
	 */
	public static void func(){
		boolean d[] = generatePrime(1000000);
		System.out.println(d[120383]);
		int prime[] = new int[60000];
		int j=2;
		for (int i = 0; i < prime.length; i++) {
			while(d[j]){
				j++;
			}
			prime[i]=j;
			j++;
		}
		LinkedList<Integer> r_list;;
		int high[] = {1,2,3,4,5,6,7,8,9};
		int mid[] = {0,1,2,3,4,5,6,7,8,9};
		for (int pv : prime) {
		//int pv=120383;
			int dn = MathTool.getDigitNum(pv);
			for (int i = 1; i <= dn-1; i++) {
				list = new LinkedList<int[]>();
				
				g(0,i,dn-1,new LinkedList<Integer>());
				
				//System.out.println(list.size());
				for (int[] k : list) {
					char[] pst = String.valueOf(pv).toCharArray();
					int nums[] =mid; 
					if(k[0]==1){ //如果包含第一位，则把替换的数字中的0去掉
						nums=high;
					}
					r_list= new LinkedList<Integer>();
					//int numj=pv;
					int nop=0;
					for (int l : nums) {
						for (int k2 : k) {
							pst[k2-1]=(char) (l+'0');
							//int dnn = dn-k2;
							//int tdnn = (int) Math.pow(10, dnn);
							//System.out.println(tdnn);
							//numj=numj-((numj/tdnn)%10-l)*tdnn;
						}
						int numi = Integer.valueOf(new String(pst));
						
						if(!d[numi]){
							r_list.add(numi);
							//System.out.println(numj+" -");
							//System.out.println(numi);
						} else {
							nop++;
							if(nums.length-nop<8){
								break;
							}
						}
					}
					/*for (int l : k) {
						System.out.print(l);
					}
					System.out.println(" "+r_list.size());*/
					if(r_list.size()==8){
						System.out.println(r_list);
						return;
					}
				}
			}
		}
	}
	public static LinkedList<int[]> list = new LinkedList<int[]>();
	/**
	 * v 当前值，用来标记从何位置开始
	 * t 从n个中取出的位数
	 * l 已经取出的数
	 */
	public static void g(int v,int t,int n,LinkedList<Integer> l){
		if(t==0){
			int x[]= new int[l.size()];
			int j=0;
			for (int i : l) {
				x[j]=i;
				j++;
			}
			//System.out.println(l);
			list.add(x);
			return ;
		}
		for (int i = v+1; i <= n-t+1; i++) {
			l.add(i);
			g(i,t-1,n,l);
			l.remove(new Integer(i));
		}
		
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
	public static boolean[] generatePrime(int n){
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i <= x; i+=2) {
			if(!d[i]){			//如果没有标记则是素数
				for (int j = i*i; j < n; j+=2*i) {  //小于i的倍数 在之前已经处理了，这里的i，j一定是奇数如果加上个i
													//变为偶数，偶数直接可以跳过
					d[j]=true; 
				}
			}
		}
		return d;
	}
}

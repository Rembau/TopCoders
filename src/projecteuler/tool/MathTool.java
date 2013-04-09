package projecteuler.tool;

import java.util.Arrays;
import java.util.LinkedList;

public class MathTool {
	/**
	 * 是否为素数
	 */
	public static boolean isFactor(int a){
		if(a<2){
			return false;
		}
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 比较两个char数组，组成的数字的大小
	 */
	public static int compareTo(char a[],char b[]){
		int i=0;
		while(i<a.length){
			if(a[i]>b[i]){
				return 1;
			} else if(a[i]<b[i]){
				return -1;
			}
			i++;
		}
		return 0;
	}
	/**
	 * 获得m个素数，从小到大排列
	 */
	public static int[] generatePrime(int m){
		int n = 10000000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //把除了2的偶数都标记为丢弃
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i < x; i+=2) {
			if(!d[i]){			//如果没有标记则是素数
				for (int j = i*i; j < n; j+=2*i) {  //小于i的倍数 在之前已经处理了，这里的i，j一定是奇数如果加上个i
													//变为偶数，偶数直接可以跳过
					d[j]=true;
				}
			}
		}
		int v[]=new int[m+1];
		int r=0;
		for (int i = 2; i < d.length; i++) {
			if(r>m){
				break;
			}
			if(!d[i]){
				v[r]=i;
				r++;
			}
		}
		return v;
	}
	/**
	 * 求阶乘
	 */
	public static long factorial(int n){
		long r=1;
		for (int i = 1; i <= n; i++) {
			r*=i;
		}
		return r;
	}
	/**
	 * 获得质因子
	 */
	public static LinkedList<Integer> getFactors(int num){
		LinkedList<Integer> f = new LinkedList<Integer>();
		int i=2;
		while(num>=i){
			//System.out.println(num);
			while(num%i==0){
				num=num/i;
				//System.out.print(" "+i);
				f.add(i);
			}
			i++;
		}
		//System.out.println();
		return f;
	}
	/**
	 * 求得数字的位数
	 */
	public static int getDigitNum(int num){
		return (int) Math.floor(Math.log10(num)+1);
	}
	/**
	 * 判断是否是回文
	 */
	public static boolean isP(char[] ch){
		if(ch.length==1){
			return true;
		}
		for (int i = 0; i < ch.length/2; i++) {
			if(ch[i]!=ch[ch.length-i-1]){
				return false;
			}
		}
		return true;
	}
	public static boolean isP(int n){
		String str = String.valueOf(n);
		return isP(str);
	}
	public static boolean isP(String str){
		return isP(str.toCharArray());
	}
	/**
	 * 二分查找
	 */
	public static boolean binarySearch(long p[],long n){
		int t=p.length;
		int l=0;
		int index;
		while(t>l){
			index=(t+l)/2;
			if(n==p[index]){
				return true;
			} else if(n>p[index]){
				l=index+1;
			} else if(n<p[index]){
				t=index-1;
			}
		}
		return false;
	}
	public static boolean binarySearch(int p[],int n){
		int t=p.length;
		int l=0;
		int index;
		while(t>l){
			index=(t+l)/2;
			if(n==p[index]){
				return true;
			} else if(n>p[index]){
				l=index+1;
			} else if(n<p[index]){
				t=index-1;
			}
		}
		return false;
	}
	public static void main(String[] args) {

	}

}

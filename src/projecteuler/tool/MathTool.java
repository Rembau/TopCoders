package projecteuler.tool;

import java.util.Arrays;
import java.util.LinkedList;

public class MathTool {
	/**
	 * �Ƿ�Ϊ����
	 */
	public static boolean isFactor(int a){
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0){
				return false;
			}
		}
		return true;
	}
	/**
	 * �Ƚ�����char���飬��ɵ����ֵĴ�С
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
	 * ���m����������С��������
	 */
	public static int[] generatePrime(int m){
		int n = 10000000;
		boolean d[] = new boolean[n];
		Arrays.fill(d, false);
		for (int i = 4; i < n; i+=2) {
			d[i]=true;        //�ѳ���2��ż�������Ϊ����
		}
		int x = (int) Math.sqrt(n);
		for (int i = 3; i < x; i+=2) {
			if(!d[i]){			//���û�б����������
				for (int j = i*i; j < n; j+=2*i) {  //С��i�ı��� ��֮ǰ�Ѿ������ˣ������i��jһ��������������ϸ�i
													//��Ϊż����ż��ֱ�ӿ�������
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
	 * ��׳�
	 */
	public static long factorial(int n){
		long r=1;
		for (int i = 1; i <= n; i++) {
			r*=i;
		}
		return r;
	}
	/**
	 * ���������
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
	 * ������ֵ�λ��
	 */
	public static int getDigitNum(int num){
		return (int) Math.floor(Math.log10(num)+1);
	}
	public static void main(String[] args) {

	}

}

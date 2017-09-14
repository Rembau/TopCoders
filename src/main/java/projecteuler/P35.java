package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P35 {
/**
 * The number, 197, is called a circular prime because all rotations of the digits: 
 * 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 */
	public static void func(){
		boolean p[] = generatePrime();
		int count=13;
		for (int i = 101; i < p.length; i++) {
			if(p[i]) continue;
			int dnum = MathTool.getDigitNum(i);
			int tem =i;
			boolean flag =true;
			for (int j = 1; j < dnum; j++) {
				tem = getRotation(tem,dnum);
				if(p[tem]){
					flag = false;
					break;
				}
			}
			if(flag){
				//System.out.println(i);
				count+=1;
			}
		}
		System.out.println(count);
	}
	public static int getRotation(int tem,int dnum){
		int a = tem%((int)(Math.pow(10, dnum-1)))*10;
		int b =tem/((int)(Math.pow(10, dnum-1)));
		tem = a+b;
		return tem;
	}
	public static boolean[] generatePrime(){
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
		return d;
	}
	public static void main(String[] args) {
		long i = System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis() - i +" ms");
	}

}

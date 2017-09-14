package projecteuler;

import java.util.Arrays;

import projecteuler.tool.MathTool;

public class P56 {

	/**
	 * Considering natural numbers of the form, a(b), where a, b<100, what is the maximum digital sum?
	 */
	public static void func(){
		int max=0;
		for (int i = 1; i < 100; i++) {
			int ds[];
			int num[] = getArrayForInt(i);
			ds = Arrays.copyOf(num, 200);
			int index = num.length;
			for (int j = 1; j < 100; j++) {
				/*for (int j2 = 0; j2 < ds.length; j2++) {
					System.out.print(ds[j2]);
				}
				System.out.println();*/
				int sum = getdsum(ds,index);
				max=sum>max?sum:max;
				ds = multiply(ds,num);
			}
		}
		System.out.println(max);
	}
	static int[] multiply(int ds[],int num[]){
		int line[][] = new int[num.length][ds.length+1];
		for (int i = 0; i < line.length; i++) {
			int u=num[i];
			int remainder=0;
			for (int j = 0; j < ds.length; j++) {
				int tem = u*ds[j];
				line[i][i+j]=tem%10+remainder;
				remainder=tem/10;
			}
		}
		int remainder =0;
		for (int i = 0; i < ds.length; i++) {
			int sum=remainder;
			for (int j = 0; j < line.length; j++) {
				sum+=line[j][i];
			}
			ds[i]=sum%10;
			remainder=sum/10;
		}
		return ds;
	}
	static int[] getArrayForInt(int i){
		int num[] = new int[MathTool.getDigitNum(i)];
		int tem=i;
		for (int k = 0; k < num.length; k++) {
			num[k]=tem%10;
			tem/=10;
		}
		return num;
	}
	static int getdsum(int ds[],int index){
		int sum=0;
		for (int i = 0; i < ds.length; i++) {
			sum+=ds[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}

}
package projecteuler;

import projecteuler.tool.MathTool;

public class P63 {
/**
 * The 5-digit number, 16807=7(5), is also a fifth power. Similarly, 
 * the 9-digit number, 134217728=8(9), is a ninth power.
 * 
 * How many n-digit positive integers exist which are also an nth power?
 */
	public static void func(){
		int count=0;
		for (int i = 1; i < 10; i++) {
			double v=i;
			for (int j = 1; true; j++) {
				if(j==MathTool.getDigitNum(v)){
					count++;
				} else{
					System.out.println(i+" "+j+" "+v);
					break;
				}
				v*=i;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		func();
	}

}

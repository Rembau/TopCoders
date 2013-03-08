package projecteuler;

import projecteuler.tool.MathTool;

public class P7 {
	public static void func(){
		int i=0;
		int n=2;
		while(i<10001){
			if(MathTool.isFactor(n)){
				i++;
			}
			n++;
		}
		System.out.println(n-1);
	}
	public static void main(String[] args) {
		func();
	}

}

package projecteuler;
import projecteuler.tool.MathTool;

public class P34 {

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/
	static int f[];
	static int sumt=0;
	public static void func(){
		f = new int[10];
		for (int i = 0; i < 10; i++) {
			f[i] = (int) MathTool.factorial(i);
			System.out.println(i+" "+f[i] );
		}
		for (int i = 1; i < 10; i++) {
			int r[] = new int[1];
			r[0]=i;
			f(1,i,f[i],r);
		}
		System.out.println(sumt-1-2);
	}
	static void f(int i,int num,int sum,int r[]){
		if(i>=7){
			return ;
		}
		if(i == (Math.floor(Math.log10(sum)+1))){
			int rr[] = new int[i];
			int k=0;
			for (char ch : (sum+"").toCharArray()) {
				rr[k]=ch-'0';
				k++;
			}
			boolean flag=true;
			for (int j = 0; j < rr.length; j++) {
				if(r[j]!=rr[j]){
					flag=false;
				}
			}
			if(flag){
				/*for (int j = 0; j < r.length; j++) {
					System.out.print(r[j]);
				}
				System.out.println(" "+sum);
				System.out.print(true);*/
				sumt+=sum;
				//System.out.println(sum+" ===== "+sumt+"=======");
			}
		}
		for (int j = 0; j < 10; j++) {
			int rr[] = new int[r.length+1];
			for (int k = 0; k < r.length; k++) {
				rr[k] = r[k];
			}
			rr[r.length]=j;
			f(i+1,j,sum+f[j],rr);
		}
	}
	public static void main(String[] args) {
		func();
	}

}

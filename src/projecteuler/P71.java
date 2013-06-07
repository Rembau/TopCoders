package projecteuler;

public class P71 {
/**
Consider the fraction, n/d, where n and d are positive integers. If nd and HCF(n,d)=1, 
it is called a reduced proper fraction.
If we list the set of reduced proper fractions for d  8 in ascending order of size, we get:
1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
It can be seen that 2/5 is the fraction immediately to the left of 3/7.
By listing the set of reduced proper fractions for d <= 1,000,000 in ascending order of size, 
find the numerator of the fraction immediately to the left of 3/7.
*/
	static int maxn=1000000;
	static double min=0;
	static int o=0;
	static int d=0;
	static int count=0;
	static double max=3.0/7;
	public static void func(){
		for (int i = 8; i <= maxn; i++) {
			double tem = Math.floor(i*max);
			if(i%7==0){
				tem--;
			}
			while(j((int) tem,i)!=1){
				if(tem/i < min){
					break;
				}
				tem--;
			}
			double temd = tem/i;
			if(temd>min){
				o=(int) tem;
				d=i;
				min=temd;
				//System.out.println(temd);
			}
		}
		System.out.println(min+" "+max+" "+o+" "+d+" "+count);
	}
	public static int j(int o,int d){
		int c=0;
		for(c = d % o ; c >0 ; c = d % o){
			d = o;
			o = c;
		}
		return o;
	}
	public static void main(String[] args) {
		long i =System.currentTimeMillis();
		func();
		System.out.println(System.currentTimeMillis()-i);
	}
}
